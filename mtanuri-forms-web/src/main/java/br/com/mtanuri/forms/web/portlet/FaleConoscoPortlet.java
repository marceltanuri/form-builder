package br.com.mtanuri.forms.web.portlet;

import br.com.mtanuri.forms.model.Forms;
import br.com.mtanuri.forms.web.configuration.FormsConfig;
import br.com.mtanuri.forms.web.exception.FormsException;
import br.com.mtanuri.forms.web.service.FormsService;
import com.google.gson.Gson;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailService;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Reference;


/**
 * @author marceltanuri
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/fale-conosco/css/main.css",
                "com.liferay.portlet.header-portlet-javascript=/fale-conosco/build/js/main.js",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=FaleConosco",
                "javax.portlet.init-param.template-path=/fale-conosco/",
                "javax.portlet.init-param.view-template=/fale-conosco/view.jsp",
                "javax.portlet.init-param.config-template=/fale-conosco/configuration.jsp",
                "javax.portlet.name=" + FormsPortletKeys.FALECONOSCO,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        configurationPid = "br.com.mtanuri.forms.web.configuration.FormsConfiguration",
        service = Portlet.class
)
public class FaleConoscoPortlet extends MVCPortlet {

    @Override
    public void serveResource(ResourceRequest req, ResourceResponse res) throws IOException {
        try {
            PortletPreferences portletPreferences = req.getPreferences();
            FormsConfig formsConfig = new Gson().fromJson(portletPreferences.getValue("formsConfig", new JSONObject(new FormsConfig()).toString()), FormsConfig.class);
            _log.debug(new JSONObject(formsConfig));

            Forms forms = formsService.submit(req, res, new JSONObject(formsConfig));

            JSONObject jsonResponse = new JSONObject();

            jsonResponse.put("content", new JSONObject(forms.getContent()));
            jsonResponse.put("files", forms.getFiles());
            jsonResponse.put("formId", forms.getFormId());

            ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(
                    WebKeys.THEME_DISPLAY);
            jsonResponse.put("host", themeDisplay.getURLPortal());

            String assunto = jsonResponse.getJSONObject("content").getString("Assunto");
            boolean assuntoIsNotNull = assunto != null && !assunto.isEmpty();

            // only forms with declared subject triggers email notification
            if (assuntoIsNotNull) {
                _log.debug(jsonResponse);
                sendEmailNotification(req, jsonResponse, formsConfig);
            }

            ResponseUtil.sendJSONSuccess(req, res, jsonResponse.toString());
        } catch (FormsException e) {
            ResponseUtil.sendBadRequest(req, res, e.getMessage());
        } catch (JSONException e) {
            ResponseUtil.sendBadRequest(req, res, e.getMessage());
        }
    }

    // gets formsConfig from portlet preferences && send email notification
    private void sendEmailNotification(ResourceRequest resourceRequest, JSONObject message, FormsConfig formsConfig) {
        try {
            InternetAddress from = new InternetAddress(formsConfig.getFromEmailAddress(), formsConfig.getFromName());

            // Used by all forms (required)
            final String formSubject = message.getJSONObject("content").getString("Assunto");

            // Only used by CadastroForncedor form. (required) when CadastroForncedor is selected
            final String formDepartment = message.getJSONObject("content").optString("Área");

            if (formSubject == null || formSubject.isEmpty()) {
                return;
            }

            _log.debug(new JSONObject(formsConfig));

            // merge subject and department mailto configuration
            List<JSONObject> mailtoConfig = new ArrayList<>(10);
            formsConfig.getSubjectConfig().stream().forEach(o -> {
                o.getDestinationEmailAddresses().stream().forEach(mail -> {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("rule", o.getSubject());
                    jsonObject.put("mailto", mail);
                    mailtoConfig.add(jsonObject);
                });
            });
            formsConfig.getDepartmentsConfig().stream().forEach(o -> {
                o.getDestinationEmailAddresses().stream().forEach(mail -> {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("rule", o.getDepartment());
                    jsonObject.put("mailto", mail);
                    mailtoConfig.add(jsonObject);
                });
            });

            //filtering email addresses based on subject and departments rules
            List<JSONObject> mailtoConfigList = mailtoConfig.stream().filter(o -> o.getString("rule").equals(formSubject) || o.getString("rule").equals(formDepartment)).collect(Collectors.toList());
            if (!mailtoConfigList.isEmpty()) {

                // building email body based on form fields
                StringBuilder mailBodySB = new StringBuilder();
                mailBodySB.append("<h2>Formulário</h2>");
                mailBodySB.append("<br/>");
                message.getJSONObject("content").toMap().forEach((k, v) -> {
                    mailBodySB.append(k);
                    mailBodySB.append(": ");
                    mailBodySB.append(message.getJSONObject("content").getString(k));
                    mailBodySB.append("<br/>");
                });

                if (message.getString("files") != null && !message.getString("files").isEmpty()) {
                    mailBodySB.append("<br/>");
                    mailBodySB.append("<h3>Anexos</h3>");
                    mailBodySB.append("<br/>");
                    String host = message.getString("host");
                    Arrays.stream(message.getString("files").split(";")).forEach(f -> {
                        mailBodySB.append(host + f);
                        mailBodySB.append("<br/>");
                    });
                }

                // sending email message to address found in configuration
                mailtoConfigList.stream().forEach(obj -> {
                    String _email = obj.getString("mailto");
                    InternetAddress to = null;
                    try {
                        to = new InternetAddress(_email);
                        String emailSubject = formSubject + " - new Entry";
                        MailMessage mailMessage = new MailMessage(
                                from, to, emailSubject, mailBodySB.toString(), true);
                        _mailService.sendEmail(mailMessage);
                    } catch (AddressException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (JSONException e) {
            _log.error("Unable to get formsConfig. It can impact email notifications and other admin features");
            _log.error(e);
        } catch (Exception e) {
            _log.error("Unable to get formsConfig. It can impact email notifications and other admin features");
            _log.error(e);
        }
    }

    private static final Log _log = LogFactoryUtil.getLog(FaleConoscoPortlet.class);

    @Reference
    private MailService _mailService;

    @Reference
    private FormsService formsService;

}