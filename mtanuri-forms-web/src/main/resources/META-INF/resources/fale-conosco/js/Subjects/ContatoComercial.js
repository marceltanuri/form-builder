const SubForm = require('../../../js/SubForm').SubForm;
const Fields = require('../../../js/Fields/Field');

class ContatoComercial extends SubForm {
    constructor(parentId) {
        super(parentId);
        this.fields.companyName = new Fields.Text("companyName", true)
        this.fields.cnpj = new Fields.Text("cnpj", true)
        this.fields.message = new Fields.TextArea("message", true)
    }
}

module.exports.ContatoComercial = ContatoComercial;