'use strict';
const fs = require('fs');

let maxSize = 0;    
let perDay = [];

const miniJSON = [];

let rawdata = fs.readFileSync('Municipios.json');
let data = JSON.parse(rawdata);
data.forEach(function(obj){
    let miniObj = {}
    miniObj.nome = obj.nome;
    miniObj.uf = obj.microrregiao.mesorregiao.UF.sigla;
    miniJSON.push(miniObj);
});

fs.writeFile('Municipios_mini.txt', JSON.stringify(miniJSON), function (err) {
    if (err) return console.log(err);
    console.log('Hello World > helloworld.txt');
  });
