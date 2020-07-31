package com.thoughtworks.springbootemployee.dto;

import com.thoughtworks.springbootemployee.entity.Employee;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmployeeRequestDTO {
    private int age;
    private String name;
    private String gender;
    private int companyId;



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

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public EmployeeRequestDTO(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public EmployeeRequestDTO() {
    }
    public Employee toEntity() {
        return new Employee(age, name, gender);
    }
}
