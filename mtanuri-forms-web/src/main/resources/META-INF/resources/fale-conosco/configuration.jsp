<%@ include file="/fale-conosco/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="br.com.mtanuri.forms.web.configuration.FormsConfig" %>
<%@ page import="com.google.gson.GsonBuilder" %>

<%
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String defaultValue = gson.toJson(new FormsConfig());
    String formsConfig = portletPreferences.getValue("formsConfig", defaultValue);
    if(formsConfig==null||formsConfig.isEmpty()){
        formsConfig = defaultValue;
    }
%>

<liferay-portlet:actionURL portletConfiguration="<%=true%>" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="<%=true%>" var="configurationRenderURL" />

<aui:form action="<%=configurationActionURL%>" method="post" name="fm">
    <aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
    <aui:input name="redirect" type="hidden" value="<%=configurationRenderURL%>" />

    <div class="portlet-configuration-body-content">
        <div class="container-fluid-1280">
            <aui:fieldset>
                <aui:input type="textarea" autoFocus="true" cssClass="myFormsConfig" label="Config" name="formsConfig" value="<%= formsConfig %>" />
            </aui:fieldset>
        </div>
    </div>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
    </aui:button-row>
</aui:form>

<style>
    .myFormsConfig{

    }
</style>