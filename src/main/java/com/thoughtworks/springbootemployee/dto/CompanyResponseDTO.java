package com.thoughtworks.springbootemployee.dto;

import com.thoughtworks.springbootemployee.entity.Employee;


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

    public void setEmployeeNameList(List<String> employeeIdList) {
        this.employeeNameList = employeeIdList;
    }

    public CompanyResponseDTO(String name, List<String> employeeNameList) {
        this.name = name;
        this.employeeNameList = employeeNameList;
    }

    public CompanyResponseDTO() {
    }
}
