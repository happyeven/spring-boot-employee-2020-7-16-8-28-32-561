package com.thoughtworks.springbootemployee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

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
    @JsonIgnore
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


    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee(String gender, int id, int age, String name) {
        this.gender = gender;
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Employee(int id, int age, String name, String gender, Company company) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.company = company;
    }

    public Employee() {

    }

    public Employee(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public Company getCompany() {
        return company;
    }

    public Employee(int age, String name, String gender, Company company) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name) &&
                Objects.equals(gender, employee.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, gender);
    }
}
