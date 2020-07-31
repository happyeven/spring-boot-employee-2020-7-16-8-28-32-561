package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dto.EmployeeRequestDTO;
import com.thoughtworks.springbootemployee.dto.EmployeeResponseDTO;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;

public class EmployeeMapper {
    public static Employee employeeRequestDtoToEmployee(EmployeeRequestDTO employeeRequestDTO , Company company){
        return new Employee(employeeRequestDTO.getAge(),
                employeeRequestDTO.getName(),
                employeeRequestDTO.getGender(),
                company);
    }
    public static EmployeeResponseDTO employeeToEmployeeResponse(Employee employee){
        return new EmployeeResponseDTO(employee.getName(),employee.getAge(),employee.getCompany().getName());
    }
}
