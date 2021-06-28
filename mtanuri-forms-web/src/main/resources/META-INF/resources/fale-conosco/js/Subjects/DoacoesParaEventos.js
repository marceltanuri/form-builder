const SubForm = require('../../../js/SubForm').SubForm;
const Fields = require('../../../js/Fields/Field');


class DoacoesParaEventos extends SubForm{
constructor(parentId){
    super(parentId);
    this.fields.message = new Fields.TextArea("message", true)
    }
}

module.exports.DoacoesParaEventos = DoacoesParaEventos;