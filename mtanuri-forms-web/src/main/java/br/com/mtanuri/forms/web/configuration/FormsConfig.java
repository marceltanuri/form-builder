package br.com.mtanuri.forms.web.configuration;

import java.util.ArrayList;
import java.util.List;

public class FormsConfig {

    private String fromEmailAddress = "";
    private String fromName = "";
    private List<SubjectConfig> subjectConfig = new ArrayList<>(1);
    private List<DepartmentsConfig> departmentsConfig = new ArrayList<>(1);
    private long attachmentsFolderId  = 0l;

    public FormsConfig() {
        String[] subjects = {"Cadastro de fornecedores", "Centro de memória Empresa", "Comunidades", "Contato comercial", "Doações para eventos", "Solicitação de Perfil Profissiográfico Previdenciário (PPP)", "Sustentabilidade", "Outros assuntos"};
        String[] departments = {"Logística", "Compras de materiais", "Compras de serviços", "Compras de matérias-primas"};
        for (String subject : subjects) {
            this.subjectConfig.add(new SubjectConfig(subject));
        }
        for (String department : departments) {
            this.departmentsConfig.add(new DepartmentsConfig(department));
        }
    }

    public String getFromEmailAddress() {
        return fromEmailAddress;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromEmailAddress(String fromEmailAddress) {
        this.fromEmailAddress = fromEmailAddress;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public List<SubjectConfig> getSubjectConfig() {
        return subjectConfig;
    }

    public void setSubjectConfig(List<SubjectConfig> subjectConfig) {
        this.subjectConfig = subjectConfig;
    }

    public List<DepartmentsConfig> getDepartmentsConfig() {
        return departmentsConfig;
    }

    public void setDepartmentsConfig(List<DepartmentsConfig> departmentsConfig) {
        this.departmentsConfig = departmentsConfig;
    }

    public long getAttachmentsFolderId() {
        return attachmentsFolderId;
    }

    public void setAttachmentsFolderId(long attachmentsFolderId) {
        this.attachmentsFolderId = attachmentsFolderId;
    }


}
