package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.dto.EmployeeRequestDTO;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping(params = "id")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Employee findEmployee(@RequestParam int id) {
        return employeeService.findEmployeeById(id);
    }

    @GetMapping(params = {"size","page"})
    public Page<Employee> getAllEmployees(@PageableDefault(size = 1) Pageable pageable) {
        return employeeService.getAllEmployee(pageable);
    }

    @DeleteMapping(params = "id")
    public void deleteEmployee(@RequestParam int id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        employeeService.updateEmployee(employeeRequestDTO);
    }

    @GetMapping(params = "gender")
    public List<Employee> getEmployeeByGender(@RequestParam String gender) {
        return employeeService.findEmployeeByGender(gender);
    }

}
