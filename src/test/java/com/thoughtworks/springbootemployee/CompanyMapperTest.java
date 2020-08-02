package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.dto.CompanyRequestDTO;
import com.thoughtworks.springbootemployee.dto.CompanyResponseDTO;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.mapper.CompanyMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void should_return_2_when_entities_to_dtos_given_2_entity() {
        Company oocl = new Company("oocl");
        Company tw = new Company("tw");
        ArrayList<Company> companies = new ArrayList<>();
        companies.add(oocl);
        companies.add(tw);
        List<CompanyResponseDTO> companyResponseDTOS = CompanyMapper.companyToCompanyResponseDTOList(companies);
        Assertions.assertEquals(2,companyResponseDTOS.size());
    }

    @Test
    void should_return_oocl_when_dto_to_entity_given_dto_with_name_oocl() {
        CompanyRequestDTO  companyRequestDTO= new CompanyRequestDTO("oocl");
        Company company = CompanyMapper.companyRequestDTOtoCompany(companyRequestDTO);
        Assertions.assertEquals("oocl",company.getName());
    }


}
