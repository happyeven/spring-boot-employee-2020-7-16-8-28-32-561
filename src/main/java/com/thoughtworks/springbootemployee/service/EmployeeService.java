package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dto.EmployeeRequestDTO;
import com.thoughtworks.springbootemployee.dto.EmployeeResponseDTO;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;


public interface EmployeeService {
    List<EmployeeResponseDTO> getAllEmployee();
    Employee findEmployeeById(int id);
    Page<Employee> getAllEmployee(Pageable pageable);
    void deleteEmployee(int id);
    void updateEmployee(EmployeeRequestDTO employeeRequest,int id);
    List<EmployeeResponseDTO> findEmployeeByGender(String gender);
    void addEmployee(EmployeeRequestDTO employeeRequest);
}
