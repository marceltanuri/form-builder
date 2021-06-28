const Field = require("./Fields/Field").Field;

class Form {
    constructor(config) {
        this.id = config != undefined && config.id != undefined && config.id != "" ? config.id : "random_" + new Date().getTime();
        this.fields = {}
        this.subForm = {};
        this.subForm.fields = {};
        this.action = config != undefined && config.action != undefined && config.action != "" ? config.action : "foo";
        this.method = config != undefined && config.method != undefined && config.method != "" ? config.method : "post";
        this.btnText = getFormsMessages().label.submit;
        this.btnRandomID = "fmb_" + new Date().getTime() + "_submit";
        this.cssClass = "form-builder fmb-form"
        this.container = config != undefined && config.container != undefined && config.container != "" ? config.container : "div-fool";
        this.termsOfUse = config != undefined && config.termsOfUse != undefined && config.termsOfUse != "" ? config.termsOfUse : false;
    }

    setBtnSubmitText(text) {
        this.btnText = text;
        return this;
    }

    getFieldByName(fieldName) {
        return this.fields[fieldName];
    }

    setValue(fieldName, value) {
        this.fields[fieldName].setValue(value);
        return this;
    }

    setElementContainer(container) {
        this.container = container
        return this;
    }

    getElementContainer() {
        if (this.container != undefined) {
            let container = document.getElementById(this.container);
            if (container != undefined) {
                return container
            }
        }
        return document.body;
    }

    // create the form containg all of its fields and append the form to the document
    render() {

        //recreates form element
        let mainDiv = document.getElementById(this.id + "-main-div")
        if (mainDiv != undefined) {
            mainDiv.remove()
        }
        mainDiv = document.createElement("div")
        mainDiv.id = this.id + "-main-div"

        let form = document.createElement("form")
        form.id = this.id
        form.method = this.method
        form.className = this.cssClass

        let row = document.createElement("div")
        row.className = "row"
        row.id = this.id + "-row";
        form.appendChild(row)

        mainDiv.appendChild(form)
        this.getElementContainer().appendChild(mainDiv)

        //get render of each element and append elements to the form
        for (const [key, obj] of Object.entries(this.fields)) {
            let element = obj.render();
            if (element != undefined) {
                let div = document.createElement("div")

                // set grid system based on field config
                div.className = obj.config.grid;

                div.appendChild(element)
                row.appendChild(div);
            }
        }

        // adds termsOfUse element if it is enabled
        if (this.termsOfUse) {
            let termsOfUseElm = document.createElement("input")
            termsOfUseElm.type = "checkbox"
            termsOfUseElm.id = "fmb_termsOfUse"
            termsOfUseElm.name = "termsOfUse"
            termsOfUseElm.required = true
            termsOfUseElm.className = "form-check-input"
            termsOfUseElm.style.width = "auto"
            termsOfUseElm.innerText = getFormsMessages().label.termsOfUse;

            let termsOfUseLabel = document.createElement("label")
            termsOfUseLabel.id = "fmb_termsOfUseLabel"
            termsOfUseLabel.for = "fmb_termsOfUse"
            termsOfUseLabel.name = "termsOfUseLabel"
            termsOfUseLabel.className = "form-check-label"
            termsOfUseLabel.for = termsOfUseElm.id
            termsOfUseLabel.innerHTML = "<i style='margin-left: 10px;'>" + getFormsMessages().placeholder.termsOfUse + "</i>";

            let termsOfUseDiv = document.createElement("div")
            termsOfUseDiv.className = "form-check"
            termsOfUseDiv.appendChild(termsOfUseElm)
            termsOfUseDiv.appendChild(termsOfUseLabel)
            form.appendChild(termsOfUseDiv)
        }

        // adds submit button
        let submit = document.createElement("button")
        submit.type = "button"
        submit.className = "btn btn-primary"
        submit.id = this.btnRandomID

        submit.innerText = this.btnText;
        let _self = this

        submit.addEventListener("click", function () {
            _self.submit().then(r => console.debug(r));
        })

        let divSubmit = document.createElement("div")
        divSubmit.className = "col-xs-12"
        divSubmit.style.marginTop = "15px";
        divSubmit.appendChild(submit)
        mainDiv.appendChild(divSubmit)
        this.getElementContainer().appendChild(mainDiv)

        return this;
    }

    toString() {
        console.debug(this);
    }

    // create a JSON contaning all fields with theis current values
    async toJSON() {

        let _toJSON = async () => {
            let json = {}
            for (const [key, obj] of Object.entries(this.fields)) {
                if (!(obj instanceof Field)) {
                    continue;
                }
                let _value = await obj.getValue();
                if (_value != "" && _value != undefined)
                    json[obj.label] = _value;
            }

            if (this.subForm != undefined && this.subForm != "") {
                for (const [key, obj] of Object.entries(this.subForm.fields)) {
                    if (!(obj instanceof Field)) {
                        continue;
                    }
                    let _value = await obj.getValue();
                    if (_value != "" && _value != undefined)
                        json[obj.label] = _value; // all fields (form and subform) are placed together in the level 0 of the JSON object
                }
            }

            return json
        }
        return _toJSON;
    }

    async submit() {

        //Validate Form
        let domForm = document.getElementById(this.id);
        if (!domForm.checkValidity()) {
            domForm.reportValidity()
            return;
        }

        //set btn state as waiting
        document.getElementById(this.btnRandomID).setAttribute("disabled", "true");
        document.getElementById(this.btnRandomID).innerText = getFormsMessages().label.wait;

        let _toJSON = await this.toJSON();
        let _self = this
        _toJSON().then(obj => {
            let formData = new FormData();

            // adds files when exists
            let _file = _self.subForm.fields.file;
            if (_file != undefined) {
                for (let i = 0; i < _file.value.length; i++) {
                    formData.append('formFile[]', _file.value[i], _file.value[i].name);
                }
            }

            formData.append('content', JSON.stringify(obj));

            fetch(_self.action,
                {
                    body: formData,
                    method: _self.method,
                }).then(response => {
                if (response.status == 200) {
                    response.json().then(obj => {
                        this.successMessage(obj)
                    })
                    this.render();
                } else {
                    response.json().then(obj => {
                        this.errorMessage(obj)
                    })
                }

                //restore btn state
                document.getElementById(this.btnRandomID).removeAttribute("disabled");
                document.getElementById(this.btnRandomID).innerText = getFormsMessages().label.submit;
            });
        })
    }

    successMessage(jsonResponse) {
        alert("Obrigado! Seu formulário enviado com sucessos. Protocolo: #" + jsonResponse.formId)
    }

    errorMessage(jsonResponse) {
        alert("Ops! Ocorreu um erro ao salvar o seu formulário. " + JSON.stringify(jsonResponse))
    }
}

module.exports.Form = Form;