package br.com.mtanuri.forms.web.configuration;

import br.com.mtanuri.forms.web.constants.FormsPortletKeys;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;



@Component(
        configurationPid = FormsPortletKeys.CONFIG,
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        immediate = true,
        property = "javax.portlet.name=" + FormsPortletKeys.FALECONOSCO,
        service = ConfigurationAction.class
)
public class FormsConfigurationAction extends DefaultConfigurationAction {

    private final String CONFIG_NAME = "formsConfig";

    @Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {
        String formsConfig = ParamUtil.getString(actionRequest, CONFIG_NAME);
        setPreference(actionRequest, CONFIG_NAME, formsConfig);

        super.processAction(portletConfig, actionRequest, actionResponse);
    }

}

