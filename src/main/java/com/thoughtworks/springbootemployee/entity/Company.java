package com.thoughtworks.springbootemployee.entity;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private int ID;
    private List<Employee> employeeList;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public Company(int ID) {
        this.ID = ID;
        employeeList = new ArrayList<>();
    }
}
