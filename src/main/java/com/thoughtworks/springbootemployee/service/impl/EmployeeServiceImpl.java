package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employeeList = new ArrayList<>();

    @Override
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void deleteEmployee(int employeeID) {
        employeeList.remove(employeeList.stream().filter(e -> e.getId() == employeeID).findFirst().get());
    }

    @Override
    public void updateEmployee(Employee employeeDTO) {
        for (Employee employee : this.employeeList) {
            if (employee.getId() == employeeDTO.getId()) {
                employee.setAge(employeeDTO.getAge());
                employee.setGender(employeeDTO.getGender());
                employee.setName(employeeDTO.getName());
            }
        }
    }

    @Override
    public Employee queryEmployee(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeeByGender(String gender) {
        return employeeList.stream().filter(e -> gender.equals(e.getGender())).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeeInPage(Integer page, Integer pageSize) {
        int startIndex = page * pageSize - pageSize;
        if (employeeList.size() <= startIndex) {
            return null;
        }
        int endIndex = page * pageSize - 1;
        if (employeeList.size() > startIndex && employeeList.size() <= endIndex) {
            return employeeList.subList(startIndex, employeeList.size());
        }
        return employeeList.subList(startIndex, endIndex + 1);
    }
}
