class Heading {
    constructor(type, name, text) {
        this.name = name;
        this.text = text;
        this.type = type;
        this.config = {};
        this.config.attrs = [];
        this.config.grid = "col-xs-12" // default value for grid system (1 - 12)
        this.cssClass = "form-builder fmb-" + type;

        if (this.text == undefined || this.text == "") {
            this.text = getFormsMessages().headings[this.name];
            if (this.text == undefined || this.text == "") {
                this.text = this.name;
            }
        }
    }

    //Generates a DOM element containing the main attributes and an event listener that updates de form object whenever the DOM element get an update
    render() {
        let elem = document.createElement("h"+this.type);
        elem.id = this.id
        elem.className = this.cssClass
        elem.innerHTML = this.text

        if (this.config.attrs != undefined) {
            this.config.attrs.forEach(obj => {
                elem[obj.name] = obj.value
            })
        }
        return elem;
    }
}

module.exports.Heading = Heading;