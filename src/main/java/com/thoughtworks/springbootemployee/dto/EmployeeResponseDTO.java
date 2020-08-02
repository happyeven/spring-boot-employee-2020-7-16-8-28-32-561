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

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

}
