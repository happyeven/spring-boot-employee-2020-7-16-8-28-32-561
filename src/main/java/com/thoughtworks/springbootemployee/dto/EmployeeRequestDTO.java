package com.thoughtworks.springbootemployee.dto;

import com.thoughtworks.springbootemployee.entity.Employee;

public class EmployeeRequestDTO {
    private int id;
    private int age;
    private String name;
    private String gender;
    private int companyId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public EmployeeRequestDTO(int id, int age, String name, String gender, int companyId) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.companyId = companyId;
    }

    public EmployeeRequestDTO() {
    }
    public Employee toEntity() {
        return new Employee(gender, id, age, name);
    }
}
