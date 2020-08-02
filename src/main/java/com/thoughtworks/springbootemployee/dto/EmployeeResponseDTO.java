package com.thoughtworks.springbootemployee.dto;

public class EmployeeResponseDTO {
    private String name;
    private Integer age;
    private String companyName;
    private String gender;

    public EmployeeResponseDTO(String name, Integer age, String companyName, String gender) {
        this.name = name;
        this.age = age;
        this.companyName = companyName;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public EmployeeResponseDTO(String name, int age, String companyName) {
        this.name = name;
        this.age = age;
        this.companyName = companyName;
    }

    public EmployeeResponseDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public EmployeeResponseDTO() {
    }
}
