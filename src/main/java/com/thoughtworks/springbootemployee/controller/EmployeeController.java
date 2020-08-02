package com.thoughtworks.springbootemployee.controller;


import com.thoughtworks.springbootemployee.dto.EmployeeRequestDTO;
import com.thoughtworks.springbootemployee.dto.EmployeeResponseDTO;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.mapper.EmployeeMapper;
import com.thoughtworks.springbootemployee.service.CompanyService;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CompanyService companyService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }


    @GetMapping(params = {"size","page"})
    public List<EmployeeResponseDTO> getAllEmployees(@PageableDefault(size = 1) Pageable pageable) {
        List<EmployeeResponseDTO> employeeResponseDTOS = employeeService.getAllEmployee(pageable)
                .stream().map(employee -> EmployeeMapper.employeeToEmployeeResponse(employee))
                .collect(Collectors.toList());
        return employeeResponseDTOS;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody  @Valid EmployeeRequestDTO employeeRequestDTO) {
        Company saveCompany = companyService.queryCompany(id);
        Employee employee = EmployeeMapper.employeeRequestDtoToEmployee(employeeRequestDTO, saveCompany);
        employeeService.updateEmployee(employee, id);
    }

    @GetMapping(params = "gender")
    public List<EmployeeResponseDTO> getEmployeeByGender(@RequestParam String gender) {
        return EmployeeMapper.employeesToEmployeeResponseDtos(employeeService.findEmployeeByGender(gender));
    }

    @PostMapping
    public void addEmployee(@RequestBody @Valid EmployeeRequestDTO employeeRequestDTO) {
        Company saveCompany = companyService.queryCompany(employeeRequestDTO.getCompanyId());
        employeeService.addEmployee(EmployeeMapper.employeeRequestDtoToEmployee(employeeRequestDTO,saveCompany));
    }

    @GetMapping("/{employeeId}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable Integer employeeId) {
        return EmployeeMapper.employeeToEmployeeResponse(employeeService.findEmployeeById(employeeId));
    }
}
