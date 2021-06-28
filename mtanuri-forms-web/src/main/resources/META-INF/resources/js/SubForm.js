const Form = require('./Form').Form;

class SubForm extends Form {
    constructor(parentId) {
        super();
        this.parentId = parentId;
    }

    // Append additional fields to the form using a special div to organize them
    render() {
        let row = document.getElementById(this.parentId + "-row")
        let divSubForm = document.getElementById("divSubForm")

        if (divSubForm != undefined) {
            divSubForm.remove();
        }

        divSubForm = document.createElement("div")
        divSubForm.className = "col"
        divSubForm.id = "divSubForm" //ID used when recreating subForms

        let divSubFormRow = document.createElement("div")
        divSubFormRow.className = "row"
        divSubForm.appendChild(divSubFormRow)

        for (const [key, obj] of Object.entries(this.fields)) {
            let element = obj.render();
            if (element != undefined) {
                let div = document.createElement("div")
                div.appendChild(element)
                div.className = obj.config.grid;
                divSubFormRow.appendChild(div);
            }
        }
        row.appendChild(divSubForm)
    }
}

module.exports.SubForm = SubForm;