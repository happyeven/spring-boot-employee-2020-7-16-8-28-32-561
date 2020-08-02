package com.thoughtworks.springbootemployee.mapper;

import com.thoughtworks.springbootemployee.Repository.CompanyRepository;
import com.thoughtworks.springbootemployee.dto.EmployeeRequestDTO;
import com.thoughtworks.springbootemployee.dto.EmployeeResponseDTO;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {

    public static Employee employeeRequestDtoToEmployee(EmployeeRequestDTO employeeRequestDTO, Company company) {

        return new Employee(employeeRequestDTO.getAge(),
                employeeRequestDTO.getName(),
                employeeRequestDTO.getGender(),
                company);
    }

    public static EmployeeResponseDTO employeeToEmployeeResponse(Employee employee) {
        Company company = employee.getCompany();
        String companyName = company == null ? "" : company.getName();
        return new EmployeeResponseDTO(employee.getName(), employee.getAge(), companyName,employee.getGender());
    }

    public static List<EmployeeResponseDTO> employeesToEmployeeResponseDtos(List<Employee> employees) {
        List<EmployeeResponseDTO> employeeArrayList=new ArrayList<>();
        for (Employee employee : employees) {
            employeeArrayList.add(employeeToEmployeeResponse(employee));
        }
        return employeeArrayList;
    }
}
