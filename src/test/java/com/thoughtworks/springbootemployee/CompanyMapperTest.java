package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.dto.CompanyRequestDTO;
import com.thoughtworks.springbootemployee.dto.CompanyResponseDTO;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.mapper.CompanyMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CompanyMapperTest {
    @Test
    void should_return_dto_with_employee_names_when_entity_to_dto_given_company_with_employees() {
        Company oocl = new Company("oocl");
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "david", "male"));
        employees.add(new Employee(1, "dong", "male"));
        oocl.setEmployeeList(employees);
        CompanyResponseDTO companyResponseDTO = CompanyMapper.companyToCompanyResponseDTO(oocl);
        Assertions.assertEquals("oocl",companyResponseDTO.getName());
        Assertions.assertEquals("david",companyResponseDTO.getEmployeeNameList().get(0));
        Assertions.assertEquals("dong",companyResponseDTO.getEmployeeNameList().get(1));
    }

}
