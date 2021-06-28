const Comunidades = require("./Comunidades").Comunidades
const CentroDeMemoriaEmpresa = require("./CentroDeMemoriaEmpresa").CentroDeMemoriaEmpresa
const ContatoComercial = require("./ContatoComercial").ContatoComercial
const DoacoesParaEventos = require("./DoacoesParaEventos").DoacoesParaEventos
const OutrosAssuntos = require("./OutrosAssuntos").OutrosAssuntos
const PPP = require("./PPP").PPP
const QueroSerUmFornecedorEmpresa = require("./QueroSerUmFornecedorEmpresa").QueroSerUmFornecedorEmpresa
const Sustentabilidade = require("./Sustentabilidade").Sustentabilidade

function initSubForm(name, formId) {
    switch (name) {
        case "Comunidades":
            return new Comunidades(formId);
        case "Sustentabilidade":
            return new Sustentabilidade(formId);

        case "Outros assuntos":
            return new OutrosAssuntos(formId);

        case "Solicitação de Perfil Profissiográfico Previdenciário (PPP)":
            return new PPP(formId);

        case "Doações para projetos sociais":
            return new DoacoesParaEventos(formId);

        case "Doações para eventos":
            return new DoacoesParaEventos(formId);

        case "Contato comercial":
            return new ContatoComercial(formId);

        case "Centro de memória Empresa":
            return new CentroDeMemoriaEmpresa(formId);

        case "Cadastro de fornecedores":
            return new QueroSerUmFornecedorEmpresa(formId);

        default:
            return null;
    }
}

const subjects = ["Cadastro de fornecedores", "Centro de memória Empresa", "Comunidades", "Contato comercial", "Doações para eventos", "Solicitação de Perfil Profissiográfico Previdenciário (PPP)", "Sustentabilidade", "Outros assuntos"];

module.exports.initSubForm = initSubForm
module.exports.subjects = subjects

