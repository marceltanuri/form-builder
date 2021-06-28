<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects/>
<portlet:defineObjects/>

<script>
    function getFormsMessages(){
        // converts message from Language.properties to JSON object. Should be nice to implement a logic to convert them automatically.
        return {
            'placeholder': {
                'emailAddress': '<liferay-ui:message key="forms.fields.placeholder.email"/>',
                'fullName': '<liferay-ui:message key="forms.fields.placeholder.fullName"/>',
                'phoneNumber': '<liferay-ui:message key="forms.fields.placeholder.phoneNumber"/>',
                'country': '<liferay-ui:message key="forms.fields.placeholder.country"/>',
                'title': '<liferay-ui:message key="forms.fields.placeholder.title"/>',
                'desc': '<liferay-ui:message key="forms.fields.placeholder.smallDescription"/>',
                'termsOfUse': '<liferay-ui:message key="forms.fields.placeholder.termsOfUse"/>',
                'subject': '<liferay-ui:message key="forms.fields.placeholder.subject"/>',
                'city': '<liferay-ui:message key="forms.fields.placeholder.city"/>',
                'state': '<liferay-ui:message key="forms.fields.placeholder.state"/>',
                'message': '<liferay-ui:message key="forms.fields.placeholder.message"/>',
                'companyName': '<liferay-ui:message key="forms.fields.placeholder.companyName"/>',
                'cnpj': '<liferay-ui:message key="forms.fields.placeholder.cnpj"/>',
                'personalId': '<liferay-ui:message key="forms.fields.placeholder.personalId"/>',
                'deliveryAddress': '<liferay-ui:message key="forms.fields.placeholder.deliveryAddress"/>',
                'functionsDescription': '<liferay-ui:message key="forms.fields.placeholder.functionsDescription"/>',
                'postalCode': '<liferay-ui:message key="forms.fields.placeholder.postalCode"/>',
                'address': '<liferay-ui:message key="forms.fields.placeholder.address"/>',
                'addressNumber': '<liferay-ui:message key="forms.fields.placeholder.addressNumber"/>',
                'addressComplement': '<liferay-ui:message key="forms.fields.placeholder.addressComplement"/>',
                'companyCountry': '<liferay-ui:message key="forms.fields.placeholder.companyCountry"/>',
                'companyState': '<liferay-ui:message key="forms.fields.placeholder.companyState"/>',
                'companyCity': '<liferay-ui:message key="forms.fields.placeholder.companyCity"/>',
                'webSite': '<liferay-ui:message key="forms.fields.placeholder.webSite"/>',
                'companyCNPJ': '<liferay-ui:message key="forms.fields.placeholder.companyCNPJ"/>',
                'inscricaoEstadual': '<liferay-ui:message key="forms.fields.placeholder.inscricaoEstadual"/>',
                'inscricaoMunicipal': '<liferay-ui:message key="forms.fields.placeholder.inscricaoMunicipal"/>',
                'companyDepartmentOption': '<liferay-ui:message key="forms.fields.placeholder.companyDepartmentOption"/>',
                'offeredServices': '<liferay-ui:message key="forms.fields.placeholder.offeredServices"/>',
                'bank': '<liferay-ui:message key="forms.fields.placeholder.bank"/>',
                'agency': '<liferay-ui:message key="forms.fields.placeholder.agency"/>',
                'account': '<liferay-ui:message key="forms.fields.placeholder.account"/>',
                'commercial': '<liferay-ui:message key="forms.fields.placeholder.commercial"/>',
            },
            'label': {
                'submit': '<liferay-ui:message key="forms.fields.label.submit"/>',
                'upload': '<liferay-ui:message key="forms.fields.label.upload"/>',
                'emailAddress': '<liferay-ui:message key="forms.fields.label.email"/>',
                'fullName': '<liferay-ui:message key="forms.fields.label.fullName"/>',
                'phoneNumber': '<liferay-ui:message key="forms.fields.label.phoneNumber"/>',
                'country': '<liferay-ui:message key="forms.fields.label.country"/>',
                'title': '<liferay-ui:message key="forms.fields.label.title"/>',
                'desc': '<liferay-ui:message key="forms.fields.label.smallDescription"/>',
                'termsOfUse': '<liferay-ui:message key="forms.fields.label.termsOfUse"/>',
                'subject': '<liferay-ui:message key="forms.fields.label.subject"/>',
                'city': '<liferay-ui:message key="forms.fields.label.city"/>',
                'state': '<liferay-ui:message key="forms.fields.label.state"/>',
                'message': '<liferay-ui:message key="forms.fields.label.message"/>',
                'wait': '<liferay-ui:message key="forms.fields.label.wait"/>',
                'companyName': '<liferay-ui:message key="forms.fields.label.companyName"/>',
                'cnpj': '<liferay-ui:message key="forms.fields.label.cnpj"/>',
                'personalId': '<liferay-ui:message key="forms.fields.label.personalId"/>',
                'deliveryAddress': '<liferay-ui:message key="forms.fields.label.deliveryAddress"/>',
                'functionsDescription': '<liferay-ui:message key="forms.fields.label.functionsDescription"/>',
                'postalCode': '<liferay-ui:message key="forms.fields.label.postalCode"/>',
                'address': '<liferay-ui:message key="forms.fields.label.address"/>',
                'addressNumber': '<liferay-ui:message key="forms.fields.label.addressNumber"/>',
                'addressComplement': '<liferay-ui:message key="forms.fields.label.addressComplement"/>',
                'companyCountry': '<liferay-ui:message key="forms.fields.label.companyCountry"/>',
                'companyState': '<liferay-ui:message key="forms.fields.label.companyState"/>',
                'companyCity': '<liferay-ui:message key="forms.fields.label.companyCity"/>',
                'webSite': '<liferay-ui:message key="forms.fields.label.webSite"/>',
                'companyCNPJ': '<liferay-ui:message key="forms.fields.label.companyCNPJ"/>',
                'inscricaoEstadual': '<liferay-ui:message key="forms.fields.label.inscricaoEstadual"/>',
                'inscricaoMunicipal': '<liferay-ui:message key="forms.fields.label.inscricaoMunicipal"/>',
                'companyDepartmentOption': '<liferay-ui:message key="forms.fields.label.companyDepartmentOption"/>',
                'offeredServices': '<liferay-ui:message key="forms.fields.label.offeredServices"/>',
                'bank': '<liferay-ui:message key="forms.fields.label.bank"/>',
                'agency': '<liferay-ui:message key="forms.fields.label.agency"/>',
                'account': '<liferay-ui:message key="forms.fields.label.account"/>',
                'commercial': '<liferay-ui:message key="forms.fields.label.commercial"/>',
            },
            'headings': {'infoCompany': '<liferay-ui:message key="forms.headings.infoCompany"/>',
                'companyDepartment': '<liferay-ui:message key="forms.headings.companyDepartment"/>',
                'bankInfo': '<liferay-ui:message key="forms.headings.bankInfo"/>',
                'other': '<liferay-ui:message key="forms.headings.other"/>',
            }
        }
    }

</script>


