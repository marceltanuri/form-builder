<%@ include file="/fale-conosco/init.jsp" %>
<%@taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>

<portlet:resourceURL var="formAction" id="formAction"/>
<portlet:resourceURL id="captcha" var="captchaResourceURL"/>

<p>
	<b><liferay-ui:message key="faleconosco.caption"/></b>
</p>

<%--Container DIV where JS renders elements--%>
<div id="faleconoso-container-div">
</div>


<script>
	let form = new FaleConoscoForm(
		{
			"action" : "<%=formAction %>",
			"container" : "faleconoso-container-div",
			"method" : "post",
			"id" : "fale-conosco",
			"termsOfUse" : true
		}
	).render();
</script>