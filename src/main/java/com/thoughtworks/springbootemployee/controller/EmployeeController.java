package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(path = "/employees")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @GetMapping(path = "/employees")
    public List<Employee> getEmployee(@RequestParam(required = false) String gender
                                    , @RequestParam(required = false) Integer page
                                    , @RequestParam(required = false)Integer pageSize) {
        if (page == null && pageSize == null) {
            return employeeService.getEmployeeByGender(gender);
        }
        if (!StringUtils.isEmpty(gender)) {
            return employeeService.getAllEmployee();
        }
        return employeeService.getEmployeeInPage(page, pageSize);
    }

    @DeleteMapping(path = "/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "/employees")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }
}
