package com.thoughtworks.springbootemployee.dto;



import javax.validation.constraints.NotBlank;

public class CompanyRequestDTO {
    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyRequestDTO() {
    }
}
