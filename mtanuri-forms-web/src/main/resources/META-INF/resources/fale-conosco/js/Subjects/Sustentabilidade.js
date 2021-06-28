const SubForm = require('../../../js/SubForm').SubForm;
const Fields = require('../../../js/Fields/Field');

class Sustentabilidade extends SubForm {
    constructor(parentId) {
        super(parentId);
        this.fields.message = new Fields.TextArea("message", true)
    }
}

module.exports.Sustentabilidade = Sustentabilidade;