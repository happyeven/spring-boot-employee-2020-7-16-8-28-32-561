package com.thoughtworks.springbootemployee.dto;



import javax.validation.constraints.NotBlank;
import java.util.List;

public class CompanyRequestDTO {
    @NotBlank
    private String name;
//    private List<Integer> employeeIdList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Integer> getEmployeeIdList() {
//        return employeeIdList;
//    }
//
//    public void setEmployeeIdList(List<Integer> employeeIdList) {
//        this.employeeIdList = employeeIdList;
//    }


    public CompanyRequestDTO(@NotBlank String name) {
        this.name = name;
    }

    public CompanyRequestDTO() {
    }
}
