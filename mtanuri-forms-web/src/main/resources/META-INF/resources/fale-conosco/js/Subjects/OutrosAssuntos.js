const SubForm = require('../../../js/SubForm').SubForm;
const Fields = require('../../../js/Fields/Field');


class OutrosAssuntos extends SubForm{
constructor(parentId){
    super(parentId);
    this.fields.message = new Fields.TextArea("message", true)
    }
}

module.exports.OutrosAssuntos = OutrosAssuntos;