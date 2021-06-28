const SubForm = require('../../../js/SubForm').SubForm;
const Fields = require('../../../js/Fields/Field');


//Solicitação de Perfil Profissiográfico Previdenciário (PPP)
class PPP extends SubForm {
    constructor(parentId) {
        super(parentId);
        this.fields.personalId = new Fields.Text("personalId", true)
        this.fields.personalId.config.grid="col-xs-12 col-md-6 col-lg-4"
        this.fields.deliveryAddress = new Fields.Text("deliveryAddress", true)
        this.fields.functionsDescription = new Fields.TextArea("functionsDescription", true)
        this.fields.file = new Fields.File("file", true, true);
    }
}

module.exports.PPP = PPP;