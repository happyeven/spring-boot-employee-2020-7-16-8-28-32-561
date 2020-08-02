package com.thoughtworks.springbootemployee.dto;

import com.thoughtworks.springbootemployee.entity.Employee;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmployeeRequestDTO {
    private int age;
    @NotBlank
    private String name;
    @Size(min = 1, max = 10)
    private String gender;
    private Integer companyId;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public EmployeeRequestDTO(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public EmployeeRequestDTO() {
    }
}
