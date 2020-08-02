package com.thoughtworks.springbootemployee.mapper;


import com.thoughtworks.springbootemployee.dto.CompanyRequestDTO;
import com.thoughtworks.springbootemployee.dto.CompanyResponseDTO;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;


import java.util.ArrayList;
import java.util.List;


public class CompanyMapper {
    public static CompanyResponseDTO companyToCompanyResponseDTO(Company company) {
        return new CompanyResponseDTO(company.getName(), company.getEmployeeList());
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
