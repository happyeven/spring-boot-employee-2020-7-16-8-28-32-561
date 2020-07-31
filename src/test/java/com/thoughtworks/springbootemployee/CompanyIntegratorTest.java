package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.Repository.CompanyRepository;
import com.thoughtworks.springbootemployee.entity.Company;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CompanyIntegratorTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private CompanyRepository companyRepository;

    @AfterEach
    void tearDown() {
        companyRepository.deleteAll();
    }

    @Test
    void should_return_ok_when_finAll_company() throws Exception {
        mockMvc.perform(get("/companies")).andExpect(status().isOk());
    }

    @Test
    void should_return_ok_when_find_employee() throws Exception {
        String companyJson = "{\n" +
                "    \"name\": \"tw\"\n" +
                "}";
        mockMvc.perform(post("/companies").contentType(MediaType.APPLICATION_JSON).content(companyJson)).andExpect(status().isOk());
        Company tw = companyRepository.findByName("tw");
        mockMvc.perform(post("/companies").contentType(MediaType.APPLICATION_JSON).content(companyJson)).andExpect(status().isOk());
        mockMvc.perform(get("/companies/+ " +tw.getCompanyId()+"/employees")).andExpect(status().isOk());
    }

    @Test
    void should_add_1_company_when_add_company_given_1_company() throws Exception {
        String companyJson = "{\n" +
                "    \"name\": \"tw\"\n" +
                "}";
        mockMvc.perform(post("/companies").contentType(MediaType.APPLICATION_JSON).content(companyJson)).andExpect(status().isOk());
        List<Company> companies = companyRepository.findAll();
        System.out.println(companies.size());
        String resultActions = mockMvc.perform(get("/companies")).andReturn().getResponse().getContentAsString();
        System.out.println(resultActions);
        String s = "tw";

        Assertions.assertTrue(resultActions.contains(s));
    }

    @Test
    void should_get_1_company_when_get_all_company_given_1_company_db() throws Exception {
        String companyJson = "{\n" +
                "    \"name\": \"tw\"\n" +
                "}";
        mockMvc.perform(post("/companies").contentType(MediaType.APPLICATION_JSON).content(companyJson)).andExpect(status().isOk());
        mockMvc.perform(get("/companies").contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("content[0].name").value("tw"));

    }

    @Test
    void should_return_ok_when_update_company_given_new_company_name_tw() throws Exception {
        String saveCompanyJson = "{\n" +
                "    \"name\": \"tw\"\n" +
                "}";
        mockMvc.perform(post("/companies").contentType(MediaType.APPLICATION_JSON).content(saveCompanyJson)).andExpect(status().isOk());
        String companyJson = "{\n" +
                "    \"name\": \"tw\"\n" +
                "}";
        mockMvc.perform(put("/companies/1").contentType(MediaType.APPLICATION_JSON).content(companyJson)).andExpect(status().isOk());
        List<Company> companies = companyRepository.findAll();
        String name = companies.get(0).getName();
        Assertions.assertEquals("tw", name);
    }

    @Test
    void should_return_ok_when_delete_company_given_company_id_1() throws Exception { //todo get id
        Company company = new Company("oocl");
        companyRepository.save(company);
        mockMvc.perform(delete("/companies/1")).andExpect(status().isOk());
        List<Company> companies = companyRepository.findAll();
        Assertions.assertEquals(0,companies.size());
    }

}
