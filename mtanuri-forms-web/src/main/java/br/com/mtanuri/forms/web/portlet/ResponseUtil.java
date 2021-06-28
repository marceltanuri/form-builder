package br.com.mtanuri.forms.web.portlet;

import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import java.io.IOException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;


public class ResponseUtil {

    public static void sendSuccess(ResourceRequest resourceRequest, ResourceResponse resourceResponse, final String message) throws IOException {
        resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE,
                Integer.toString(HttpServletResponse.SC_OK));
        String successMessage = "{\"success\": \"" + message + "\"}";
        JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, successMessage);
    }

    public static void sendJSONSuccess(ResourceRequest resourceRequest, ResourceResponse resourceResponse, final String json) throws IOException {
        resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE,
                Integer.toString(HttpServletResponse.SC_OK));
        JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, json);
    }

    public static void sendBadRequest(ResourceRequest resourceRequest, ResourceResponse resourceResponse, final String message) throws IOException {
        resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE,
                Integer.toString(HttpServletResponse.SC_BAD_REQUEST));
        String errorMessage = "{\"error\": \"" + message.replace("\"","'") + "\"}";
        JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, errorMessage);
    }

    public static void sendServerInternalError(ResourceRequest resourceRequest, ResourceResponse resourceResponse, final String message) throws IOException {
        resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE,
                Integer.toString(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
        String errorMessage = "{\"error\": \"" + message.replace("\"","'") + "\"}";
        JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, errorMessage);
    }

}
