const SubForm = require('../../../js/SubForm').SubForm;
const Fields = require('../../../js/Fields/Field');
const Heading = require('../../../js/Fields/Heading').Heading;

class QueroSerUmFornecedorEmpresa extends SubForm {
    constructor(parentId) {
        super(parentId);
        this.fields.companyName = new Fields.Text("companyName", true)

        // Heading
        this.fields.infoCompany = new Heading("2", "infoCompany")
        this.fields.infoCompany.config.grid="col-xs-12 text-center"

        this.fields.postalCode = new Fields.Text("postalCode", true)
        this.fields.postalCode.config.grid="col-xs-12 col-md-4 col-lg-3"
        this.fields.address = new Fields.Text("address", true)
        this.fields.address.config.grid="col-xs-12 col-md-8 col-lg-9"

        this.fields.addressNumber = new Fields.Text("addressNumber", true)
        this.fields.addressNumber.config.grid="col-xs-12 col-md-6 col-lg-3"
        this.fields.addressComplement = new Fields.Text("addressComplement", true)
        this.fields.addressComplement.config.grid="col-xs-12 col-md-6 col-lg-3"
        this.fields.companyCountry = new Fields.Paises("companyCountry", true)
        this.fields.companyCountry.config.grid="col-xs-12 col-md-6 col-lg-3"
        this.fields.companyState = new Fields.Estados("companyState", true, "companyCity")
        this.fields.companyState.config.grid="col-xs-12 col-md-6 col-lg-3"

        this.fields.companyCity = new Fields.Municipios("companyCity", true)

        this.fields.webSite = new Fields.Text("webSite", true)
        this.fields.webSite.config.grid="col-xs-12 col-md-6 col-lg-3"
        this.fields.companyCNPJ = new Fields.Text("companyCNPJ", true)
        this.fields.companyCNPJ.config.grid="col-xs-12 col-md-6 col-lg-3"
        this.fields.inscricaoEstadual = new Fields.Text("inscricaoEstadual", true)
        this.fields.inscricaoEstadual.config.grid="col-xs-12 col-md-6 col-lg-3"
        this.fields.inscricaoMunicipal = new Fields.Text("inscricaoMunicipal", true)
        this.fields.inscricaoMunicipal.config.grid="col-xs-12 col-md-6 col-lg-3"

        // Heading
        this.fields.companyDepartment = new Heading("2", "companyDepartment")
        this.fields.companyDepartment.config.grid="col-xs-12 text-center"
        this.fields.companyDepartmentOption = new Fields.Select("companyDepartmentOption", true)
        let departmentItems = [
            {"value": "Logística", "text": "Logística"},
            {"value": "Compras de materiais", "text": "Compras de materiais"},
            {"value": "Compras de serviços", "text": "Compras de serviços"},
            {"value": "Compras de matérias-primas", "text": "Compras de matérias-primas"}
        ];
        this.fields.companyDepartmentOption.config.items = departmentItems;
        this.fields.offeredServices = new Fields.TextArea("offeredServices", true)

        // Heading
        this.fields.bankInfo = new Heading("2", "bankInfo")
        this.fields.bankInfo.config.grid="col-xs-12 text-center"
        this.fields.bank= new Fields.Text("bank", true)
        this.fields.bank.config.grid="col-xs-12 col-md-4 col-lg-4"
        this.fields.agency= new Fields.Text("agency", true)
        this.fields.agency.config.grid="col-xs-12 col-md-4 col-lg-4"
        this.fields.account= new Fields.Text("account", true)
        this.fields.account.config.grid="col-xs-12 col-md-4 col-lg-4"

        this.fields.other = new Heading("2", "other")
        this.fields.other.config.grid="col-xs-12 text-center"

        this.fields.message= new Fields.TextArea("message", true)
        this.fields.commercial= new Fields.TextArea("commercial", true)
        this.fields.file= new Fields.File("file", false, true)

    }
}

module.exports.QueroSerUmFornecedorEmpresa = QueroSerUmFornecedorEmpresa;