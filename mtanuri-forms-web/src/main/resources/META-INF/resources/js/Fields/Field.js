const uf = require('../data/UF').data;
const paises = require('../data/Paises').data;
const municipios = require('../data/Municipios').data;

class Field {
    constructor(name, type, label, placeholder) {
        this.name = name;
        this.label = label;
        this.type = type;
        this.config = {};
        this.config.attrs = [];
        this.value = "";
        this.placeholder = placeholder
        this.config.refreshElement = ""; // ElementId of the element to be refreshed when the value of this field changes.
        this.config.grid = "col-xs-12" // default value for grid system (1 - 12)
        this.id = "fmb_" + new Date().getTime() + "_" + name;
        this.cssClass = "form-builder fmb-" + type;

        if (this.label == undefined || this.label == "") {
            this.label = getFormsMessages().label[this.name];
            if (this.label == undefined || this.label == "") {
                this.label = this.name;
            }
        }

        if (this.placeholder == undefined || this.placeholder == "") {
            this.placeholder = getFormsMessages().placeholder[this.name];
        }

    }

    setValue(value) {
        this.value = value;
    }

    getValue() {
        return this.value;
    }

    //Generates a DOM element containing the main attributes and an event listener that updates de form object whenever the DOM element get an update
    render() {
        let elem = document.createElement(this.type);
        elem.name = this.name
        elem.id = this.id
        elem.className = this.cssClass

        if (this.placeholder != undefined) {
            elem.placeholder = this.placeholder
        }

        if (this.config.attrs != undefined) {
            this.config.attrs.forEach(obj => {
                elem[obj.name] = obj.value
            })
        }

        const _self = this;

        // add listener to update the obj when element values changes
        elem.addEventListener('change', function () {
            if (form.fields[this.name] != undefined) {
                form.fields[this.name].value = this.value;
            } else if (form.subForm.fields[this.name] != undefined) {
                form.subForm.fields[this.name].value = this.value;
            }
        });
        this.populate(elem)
        this.addRefreshListener(elem)
        this.extraRenderConfig(elem)
        return elem;
    }

    //abstract method to populate element
    populate() {
        return this;
    }

    // method to add an event listener that refresh other element when this element changes
    addRefreshListener(elem) {
        let _self = this;
        if (this.config != undefined && this.config.refreshElement != "" && this.config.refreshElement != undefined) {
            elem.addEventListener('change', function () {
                if (form.fields[_self.config.refreshElement] != undefined) {
                    form.fields[_self.config.refreshElement].refresh(this.value);
                } else if (form.subForm.fields[_self.config.refreshElement] != undefined) {
                    form.subForm.fields[_self.config.refreshElement].refresh(this.value);
                }
            });
        }
        return this;
    }

    //abstract method for add extra configuration to the super render method
    extraRenderConfig() {
        return this;
    }

    //abstract method used to refresh a select element based on the values of other element
    refresh() {
    }
}

class Select extends Field {
    constructor(name, required, label, placeholder) {
        super(name, "select", label, placeholder);
        this.config.attrs.push({"name": "required", "value": required})
        this.config.items = [];
    }

    setItems(items) {
        this.config.items[0] = {"value": "", "text": this.placeholder}
        this.config.items.concat(items);
        return this;
    }

    populate(elem, filter) {
        let option = document.createElement("option");
        option.value = "";
        option.text = this.placeholder != undefined ? this.placeholder : "";
        elem.appendChild(option);
        let _items = this.config.items;
        if (filter != undefined) {
            _items.filter(filter)
            _items = _items.filter(filter)
        }
        _items.forEach(obj => {
            let option = document.createElement("option");
            option.value = obj.value;
            option.text = obj.text;
            elem.appendChild(option);
        })
    }
}

class Text extends Field {
    constructor(name, required, label, placeholder) {
        super(name, "input", label, placeholder);
        this.config.attrs.push({"name": "required", "value": required});
    }
}

class Numeric extends Field {
    constructor(name, required, label, placeholder) {
        super(name, "input", label, placeholder);
        this.config.attrs.push({"name": "required", "value": required});
        this.config.allowDecimal = true;
        this.config.range = [];
        this.config.attrs = [{"name": "type", "value": "number"}];
    }
}

class TextArea extends Field {
    constructor(name, required, label, placeholder) {
        super(name, "textarea", label, placeholder);
        this.config.attrs.push({"name": "required", "value": required});
    }
}

class Paises extends Select {
    constructor(name, required, label, placeholder) {
        super(name, required, label, placeholder)
        this.config.items = paises.map(obj => {
            return {value: obj.nome_pais, text: obj.nome_pais}
        }).sort((a, b) => {
            if (a.value < b.value) return -1
            return a.value > b.value ? 1 : 0
        });
    }
}

class Estados extends Select {
    constructor(name, required, targetElement, label, placeholder) {
        super(name, required, label, placeholder)
        this.config.items = uf.map(obj => {
            return {value: obj.sigla, text: obj.sigla}
        }).sort((a, b) => {
            if (a.value < b.value) return -1
            return a.value > b.value ? 1 : 0
        });
        this.config.refreshElement = targetElement
    }
}

class Municipios extends Select {
    constructor(name, required, label, placeholder) {
        super(name, required, label, placeholder);
        this.config.items = municipios.map(obj => {
            return {value: obj.nome, text: obj.nome, uf: obj.uf}
        })
    }

    refresh(filter) {
        let elm = document.getElementById(this.id);
        elm.querySelectorAll('*').forEach(n => n.remove());
        let _filter = obj => obj.uf == filter
        this.populate(elm, _filter);
    }
}

class CheckBox extends Field {
    constructor(name, required, label, placeholder) {
        super(name, "input", label, placeholder);
        this.config.attrs.push({"name": "required", "value": required});
        this.config.attrs = [{"name": "type", "value": "checkbox"}];

    }
}

class Subject extends Select {
    constructor(name, required, label, placeholder) {
        super(name, required, label, placeholder);
    }

    setItems(items) {
        this.config.items = items;
        return this;
    }

    extraRenderConfig(elm) {
        elm.addEventListener('change', function () {
            form.setSubject(this.value)
        });
    }
}

class Email extends Field {
    constructor(name, required, label, placeholder) {
        super(name, "input", label, placeholder);
        this.config.attrs = [{"name": "type", "value": "email"}];
        this.config.attrs.push({"name": "required", "value": required});
    }
}

class PhoneNumber extends Field {
    constructor(name, required, label, placeholder) {
        super(name, "input", label, placeholder);
        this.config.attrs = [{"name": "type", "value": "phone"}];
        this.config.attrs.push({"name": "required", "value": required});
    }
}

class CPF extends Field {
    constructor(name, required, label, placeholder) {
        super(name, "input", label, placeholder);
        this.config.attrs.push({"name": "required", "value": required});
    }
}

class CNPJ extends Field {
    constructor(name, required, label, placeholder) {
        super(name, "input", label, placeholder);
        this.config.attrs.push({"name": "required", "value": required});
    }
}

class File extends Field {
    constructor(name, required, multiple, label) {
        super(name, "input", label);
        this.config.attrs = [{"name": "type", "value": "file"}]
        this.config.attrs.push({"name": "required", "value": required});
        if (multiple == true) {
            this.config.attrs.push({"name": "multiple", "value": "true"})
        }
        this.value = []
    }

    extraRenderConfig(elm) {
        let _self = this;
        elm.addEventListener('change', function () {
            if (this.files != undefined) {
                _self.value = this.files
            }
        });
    }

    getBase64(file) {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = () => resolve(reader.result);
            reader.onerror = error => reject(error);
        });
    }

    async getValueBase64() {
        let base64Value = []
        let promises = []
        for (var i = 0; i < this.value.length; i++) {
            promises.push(this.getBase64(this.value[i]))
        }
        base64Value = await Promise.all(promises)
        return base64Value;
    }

    getValue() {
        return "";
    }

}

module.exports.Field = Field;
module.exports.Text = Text;
module.exports.File = File;
module.exports.CNPJ = CNPJ;
module.exports.CPF = CPF;
module.exports.PhoneNumber = PhoneNumber;
module.exports.Email = Email;
module.exports.Select = Select;
module.exports.Numeric = Numeric;
module.exports.CheckBox = CheckBox;
module.exports.TextArea = TextArea;
module.exports.Estados = Estados;
module.exports.Municipios = Municipios;
module.exports.Subject = Subject;
module.exports.Paises = Paises;