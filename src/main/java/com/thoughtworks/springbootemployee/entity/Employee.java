package com.thoughtworks.springbootemployee.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private String name;
    private String gender;

    @JoinColumn(name = "company_id")
    @ManyToOne
    private Company company;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

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



    public Employee(String gender, int id, int age, String name, int companyId) {
        this.gender = gender;
        this.id = id;
        this.age = age;
        this.name = name;
        this.company.setCompanyId(companyId);
    }

    public Employee() {
    }
}
