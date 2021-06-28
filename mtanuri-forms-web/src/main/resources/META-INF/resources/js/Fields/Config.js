  class Config {
    constructor(defaultValue, required, cssClass) {
      this.defaultValue = defaultValue;
      this.required = required;
      this.cssClass = cssClass;
    }
  }

  class SelectConfig extends Config {
    constructor(defaultValue, required, cssClass, dataSource, valAttr, labelAttr, parentField) {
      super(defaultValue, required, cssClass);
      this.dataSource = dataSource; // URL for data. JSON format is expected in the response
      this.valAttr = valAttr; // JSON atribute used as value <option value='it goes here'>
      this.labelAttr = labelAttr; // JSON atribute used as label <option label='it goes here'>
      this.parentField = parentField; // Other select that triggers the load of this select
    }
  }

  module.exports.Config = Config;
  module.exports.SelectConfig = SelectConfig;