const Form = require('../../js/Form').Form;
const Field = require('../../js/Fields/Field');
const Subjects = require('./Subjects/Subjects');

class FaleConoscoForm extends Form {
    constructor(config) {
        /**
         1. Attribute name must be equal to name parameter. Ex: this.fields.title .... new (.... "title"...
         2. Placeholders and Labels are set automatically based on fieldName and JSON object defined on init.jsp
         **/
        super(config);
        this.fields.fullName = new Field.Text("fullName", true)
        this.fields.emailAddress = new Field.Email("emailAddress", true)
        this.fields.country = new Field.Paises("country", true)
        this.fields.country.config.grid="col-xs-12 col-lg-2 col-md-4";

        this.fields.phoneNumber = new Field.PhoneNumber("phoneNumber", true)
        this.fields.phoneNumber.config.grid="col-xs-12 col-lg-4 col-md-6";

        this.fields.subject = new Field.Subject("subject", true)

        for (let subject of Subjects.subjects) {
            this.fields.subject.config.items.push({"value": subject, "text": subject});
        }
    }

    setSubject(value) {
        super.setValue("subject", value);

        // using a helper class to instantiate the correct subForm class based on selected value
        this.subForm = Subjects.initSubForm(this.fields.subject.value, this.id)

        if (this.subForm == null || this.subForm == undefined) {
            this.subForm = this.emptySubForm();
        } else {
            this.subForm.render();
        }

        return this;
    }

    emptySubForm() {
        if (document.getElementById("divSubForm") != undefined) {
            document.getElementById("divSubForm").remove();
        }
        return null;
    }

}

module.exports.FaleConoscoForm = FaleConoscoForm;