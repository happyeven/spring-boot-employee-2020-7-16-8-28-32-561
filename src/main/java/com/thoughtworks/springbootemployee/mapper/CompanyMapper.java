package com.thoughtworks.springbootemployee.mapper;


import com.thoughtworks.springbootemployee.dto.CompanyRequestDTO;
import com.thoughtworks.springbootemployee.dto.CompanyResponseDTO;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CompanyMapper {
    public static CompanyResponseDTO companyToCompanyResponseDTO(Company company) {
        List<Employee> employeeList = company.getEmployeeList();
        List<String> employeeNameList = new ArrayList<>();
        if (employeeList != null) {
            employeeNameList = employeeList.stream()
                    .map(employee -> employee.getName())
                    .collect(Collectors.toList());
        }
        return new CompanyResponseDTO(company.getName(), employeeNameList);
    }

    public static Company companyRequestDTOtoCompany(CompanyRequestDTO companyRequestDTO) {
        return new Company(companyRequestDTO.getName());
    }

    public static List<CompanyResponseDTO> companyToCompanyResponseDTOList(List<Company> companies) {
        List<CompanyResponseDTO> companyResponseDTOList = new ArrayList<>();
        for (Company company : companies) {
            companyResponseDTOList.add(companyToCompanyResponseDTO(company));
        }
        return companyResponseDTOList;
    }
}
