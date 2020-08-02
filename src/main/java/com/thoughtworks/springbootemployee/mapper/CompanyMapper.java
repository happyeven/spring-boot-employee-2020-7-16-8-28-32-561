package com.thoughtworks.springbootemployee.mapper;


import com.thoughtworks.springbootemployee.dto.CompanyRequestDTO;
import com.thoughtworks.springbootemployee.dto.CompanyResponseDTO;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;


import java.util.ArrayList;
import java.util.List;


public class CompanyMapper {
    public static CompanyResponseDTO companyToCompanyResponseDTO(Company company) {
        List<Employee> employeeList = company.getEmployeeList();
        List<String> stringList = new ArrayList<>();
        if (employeeList != null) {
            for (Employee employee : employeeList) {
                stringList.add(employee.getName());
            }
        }
        return new CompanyResponseDTO(company.getName(), stringList);
    }

    public static Company companyCompanyRequestDTOtoCompany(CompanyRequestDTO companyRequestDTO) {
        return new Company(companyRequestDTO.getName());
    }

    public static List<CompanyResponseDTO> companyToCompanyResponseDTOList(List<Company> companies){
        List<CompanyResponseDTO> companyResponseDTOList =new ArrayList<>();
        for (Company company : companies) {
            companyResponseDTOList.add(companyToCompanyResponseDTO(company));
        }
        return companyResponseDTOList;
    }
}
