package com.thoughtworks.springbootemployee.dto;

import com.thoughtworks.springbootemployee.entity.Employee;


import javax.validation.constraints.NotBlank;
import java.util.List;

public class CompanyResponseDTO {
    @NotBlank
    private String name;
    private List<String> employeeIdList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEmployeeIdList() {
        return employeeIdList;
    }

    public void setEmployeeIdList(List<String> employeeIdList) {
        this.employeeIdList = employeeIdList;
    }

    public CompanyResponseDTO(String name, List<String> employeeIdList) {
        this.name = name;
        this.employeeIdList = employeeIdList;
    }

    public CompanyResponseDTO() {
    }
}
