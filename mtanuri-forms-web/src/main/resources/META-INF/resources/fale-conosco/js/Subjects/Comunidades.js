const SubForm = require('../../../js/SubForm').SubForm;
const Fields = require('../../../js/Fields/Field');


class Comunidades extends SubForm {
    constructor(parentId) {
        super(parentId);
        this.fields.state = new Fields.Estados("state", true, "city")
        this.fields.state.config.grid = "col-xs-12 col-lg-3 col-md-4";

        this.fields.city = new Fields.Municipios("city", true)
        this.fields.city.config.grid = "col-xs-12 col-lg-3 col-md-4";

        this.fields.message = new Fields.TextArea("message", true)

    }
}

module.exports.Comunidades = Comunidades;