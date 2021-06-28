package br.com.mtanuri.forms.web.configuration;

import java.util.ArrayList;
import java.util.List;

public class DepartmentsConfig {

    public DepartmentsConfig(String department) {
        this.department = department;
    }

    public DepartmentsConfig() {
    }

    private String department = "";
    private List<String> destinationEmailAddresses = new ArrayList<>(1);

    public String getDepartment() {
        return department;
    }

    public List<String> getDestinationEmailAddresses() {
        return destinationEmailAddresses;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDestinationEmailAddresses(List<String> destinationEmailAddresses) {
        this.destinationEmailAddresses = destinationEmailAddresses;
    }
}
