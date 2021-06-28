package br.com.mtanuri.forms.web.configuration;

import java.util.ArrayList;
import java.util.List;

public class SubjectConfig {

    public SubjectConfig(String subject) {
        this.subject = subject;
    }

    public SubjectConfig() {
    }

    private String subject = "";
    private List<String> destinationEmailAddresses = new ArrayList<>(1);

    public String getSubject() {
        return subject;
    }

    public List<String> getDestinationEmailAddresses() {
        return destinationEmailAddresses;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDestinationEmailAddresses(List<String> destinationEmailAddresses) {
        this.destinationEmailAddresses = destinationEmailAddresses;
    }
}
