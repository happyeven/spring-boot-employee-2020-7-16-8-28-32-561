package com.thoughtworks.springbootemployee.mapper;

import com.thoughtworks.springbootemployee.Repository.CompanyRepository;
import com.thoughtworks.springbootemployee.dto.EmployeeRequestDTO;
import com.thoughtworks.springbootemployee.dto.EmployeeResponseDTO;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeMapper {
    @Autowired
    CompanyRepository companyRepository;
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
