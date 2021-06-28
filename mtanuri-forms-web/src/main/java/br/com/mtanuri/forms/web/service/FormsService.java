package br.com.mtanuri.forms.web.service;

import br.com.mtanuri.forms.model.Forms;
import br.com.mtanuri.forms.service.FormsLocalService;
import br.com.mtanuri.forms.web.exception.FileUploadException;
import br.com.mtanuri.forms.web.exception.FormsException;
import br.com.mtanuri.forms.web.exception.FormsPersistenceException;
import br.com.mtanuri.forms.web.exception.InvalidRequestException;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Reference;



/**
 * @author marceltanuri
 */
@Component(
        service = FormsService.class
)
public class FormsService {


    public Forms submit(ResourceRequest resourceRequest, ResourceResponse resourceResponse, JSONObject config) throws FormsException {

        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);

        if (uploadPortletRequest == null) {
            throw new InvalidRequestException("empty data");
        }

        String content = ParamUtil.getString(uploadPortletRequest, "content");
        _log.debug(content);

        File[] files = uploadPortletRequest.getFiles("formFile[]");

        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(
                WebKeys.THEME_DISPLAY);

        Forms forms = null;

        // Handle files upload
        boolean hasFileUpload = files != null;

        if (hasFileUpload) {
            try {
                String[] filesURL = this.saveFiles(files, themeDisplay.getSiteGroupId(), config.getLong("attachmentsFolderId"));
                // persists form with files included
                forms = formsLocalService.addForm(themeDisplay.getSiteGroupId(), FormsService.class.getName(), content, filesURL);

            } catch (PortalException | IOException e) {
                e.printStackTrace();
                throw new FileUploadException(e.getMessage());
            }
        } else {
            // persists form (no files included)
            forms = formsLocalService.addForm(themeDisplay.getSiteGroupId(), FormsService.class.getName(), content);
        }

        boolean success = forms != null;

        if (success) {
            return forms;
        } else {
            _log.error("It was not possible to persist the form. Content: " + content);
            throw new FormsPersistenceException("Form couldn't be persisted");
        }
    }

    private String[] saveFiles(File[] files, long groupId, long folderId) throws PortalException, IOException {
        Collection<String> filesURL = new ArrayList<>(files.length);

        long defaultUserId = userLocalService.getDefaultUserId(
                PortalUtil.getDefaultCompanyId());

        for (File file : files) {
            if (!file.exists()) {
                continue;
            }
            if ((file != null) && file.exists()) {
                Path path = file.toPath();
                FileEntry fileEntry = dlAppLocalService.addFileEntry(defaultUserId, groupId, folderId, file.getName(), Files.probeContentType(path), Files.readAllBytes(path), new ServiceContext());
                filesURL.add("/documents/"+fileEntry.getGroupId()+"/"+fileEntry.getFolderId()+"/"+fileEntry.getFileName()+"?t="+System.currentTimeMillis());
            }
        }

        return filesURL.toArray(new String[filesURL.size()]);
    }

    @Reference
    private DLAppLocalService dlAppLocalService;

    @Reference
    private UserLocalService userLocalService;

    @Reference
    private FormsLocalService formsLocalService;

    private static final Log _log = LogFactoryUtil.getLog(FormsService.class);

}