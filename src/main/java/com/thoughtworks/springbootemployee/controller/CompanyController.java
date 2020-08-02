package com.thoughtworks.springbootemployee.controller;


import com.thoughtworks.springbootemployee.Repository.CompanyRepository;
import com.thoughtworks.springbootemployee.dto.CompanyRequestDTO;
import com.thoughtworks.springbootemployee.dto.CompanyResponseDTO;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.mapper.CompanyMapper;
import com.thoughtworks.springbootemployee.service.CompanyService;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    EmployeeService employeeService;


    @DeleteMapping(path = "/{id}")
    public void deleteCompany(@PathVariable Integer id) {
        companyService.deleteCompany(id);
    }

    @PutMapping(path = "/{id}")
    public void updateCompany(@PathVariable Integer id, @RequestBody @Valid CompanyRequestDTO companyRequestDTO) {
        Company saveCompany = CompanyMapper.companyCompanyRequestDTOtoCompany(companyRequestDTO);
        companyService.updateCompany(saveCompany, id);
    }

    @PostMapping
    public void addCompany(@RequestBody @Valid CompanyRequestDTO companyRequestDTO) {
        Company saveCompany = CompanyMapper.companyCompanyRequestDTOtoCompany(companyRequestDTO);
        companyService.addCompany(saveCompany);
    }


    @GetMapping("/{companyId}/employees")
    public List<String> getEmployeeFromCompany(@PathVariable int companyId) { //todo
        Company companyById = companyService.getCompanyById(companyId);
        return CompanyMapper.companyToCompanyResponseDTO(companyById).getEmployeeNameList();
    }

    @GetMapping
    public List<CompanyResponseDTO> getAllCompanyByPaged(@PageableDefault Pageable pageable, @RequestParam(defaultValue = "false") boolean unpaged) {
        Page<Company> allCompany;
        if (unpaged) {
            allCompany = companyService.getAllCompany(Pageable.unpaged());
        }else {
             allCompany = companyService.getAllCompany(pageable);
        }
        return CompanyMapper.companyToCompanyResponseDTOList(allCompany.toList());
    }

}