package com.thoughtworks.springbootemployee.dto;


import javax.validation.constraints.NotBlank;
import java.util.List;

public class CompanyResponseDTO {
    @NotBlank
    private String name;
    private List<String> employeeNameList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEmployeeNameList() {
        return employeeNameList;
    }

    public CompanyResponseDTO(String name, List<String> employeeNameList) {
        this.name = name;
        this.employeeNameList = employeeNameList;
    }

}
