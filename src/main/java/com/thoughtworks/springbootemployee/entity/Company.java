package com.thoughtworks.springbootemployee.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyId;
    private String name;
    @OneToMany(mappedBy = "company")
    private List<Employee> employeeList;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Company(int id, String name) {
        this.companyId = id;
        this.name = name;
    }

    public Company(int companyId, String name, List<Employee> employeeList) {
        this.companyId = companyId;
        this.name = name;
        this.employeeList = employeeList;
    }

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }
}
