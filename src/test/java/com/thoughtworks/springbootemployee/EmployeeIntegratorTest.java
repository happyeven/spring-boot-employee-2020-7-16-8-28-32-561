package com.thoughtworks.springbootemployee;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.springbootemployee.Repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.impl.EmployeeServiceImpl;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeIntegratorTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @AfterEach
    void tearDown() {
        employeeRepository.deleteAll();
    }

    @Test
    void should_return_ok_when_find_all_employees() throws Exception {
        mockMvc.perform(get("/employees").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        List<Employee> employees = employeeRepository.findAll();
        Assertions.assertEquals(0, employees.size());
    }

    @Test
    void should_return_1_employees_when_find_employees_by_id_given_id_1() throws Exception {
        Employee employee = new Employee(1, "dong", "male");
        employeeRepository.save(employee);
        int dongId = employeeRepository.findByName("dong").getId();
        mockMvc.perform(get("/employees/" + dongId).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    @Test
    void should_return_2_employees_when_find_employees_by_page_given_page_0_size_2() throws Exception { //todo
        Employee employeeOne = new Employee(1, "dong", "male");
        Employee employeeTwo = new Employee(1, "david", "male");
        Employee employeeThree = new Employee(1, "asd", "male");
        employeeRepository.save(employeeOne);
        employeeRepository.save(employeeTwo);
        employeeRepository.save(employeeThree);
        String contentAsString = mockMvc.perform(get("/employees").param("page", "0").param("size", "2"))
                .andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = JSONArray.parseObject(contentAsString);
        List<Employee> employees = JSONArray.parseArray(jsonObject.get("content").toString(), Employee.class);
        Assertions.assertEquals(2, employees.size());
    }

    @Test
    void should_return_0_employees_when_find_employees_by_page_given_page_4_size_2() throws Exception { //todo
        Employee employeeOne = new Employee(1, "dong", "male");
        Employee employeeTwo = new Employee(1, "david", "male");
        Employee employeeThree = new Employee(1, "asd", "male");
        employeeRepository.save(employeeOne);
        employeeRepository.save(employeeTwo);
        employeeRepository.save(employeeThree);
        String contentAsString = mockMvc.perform(get("/employees").param("page", "4").param("size", "2"))
                .andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = JSONArray.parseObject(contentAsString);
        List<Employee> employees = JSONArray.parseArray(jsonObject.get("content").toString(), Employee.class);
        Assertions.assertEquals(0, employees.size());
    }

    @Test
    void should_return_male_when_find_employees_by_gender_given_male() throws Exception {
        Employee employeeOne = new Employee(1, "dong", "male");
        employeeRepository.save(employeeOne);
        String contentAsString = mockMvc.perform(get("/employees").param("gender", "male")).andReturn().getResponse().getContentAsString();
        boolean isHasFemale = contentAsString.contains("female");
        Assertions.assertEquals(false, isHasFemale);
    }

    @Test
    void should_return_ok_when_add_employee_given_1_employee() throws Exception {
        String employee = "{\n" +
                "                    \"companyId\": 3,\n" +
                "                    \"age\": 18,\n" +
                "                    \"name\": \"dong\",\n" +
                "                    \"gender\": \"male\"\n" +
                "}";
        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(employee)).andExpect(status().isOk());

    }

    @Test
    void should_return_true_when_update_employee_given_employee() throws Exception {
        String employee = "{\n" +
                "                    \"companyId\": 3,\n" +
                "                    \"age\": 18,\n" +
                "                    \"name\": \"david\",\n" +
                "                    \"gender\": \"male\"\n" +
                "}";
        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(employee));
        boolean isHasDong = mockMvc.perform(get("/employees")).andReturn().getResponse().getContentAsString().contains("dong");
        Assertions.assertEquals(false,isHasDong);
        String putEmployee = "{\n" +
                "                    \"companyId\": 3,\n" +
                "                    \"age\": 18,\n" +
                "                    \"name\": \"dong\",\n" +
                "                    \"gender\": \"male\"\n" +
                "}";
        int davidId = employeeRepository.findByName("david").getId();
        mockMvc.perform(put("/employees/" + davidId).contentType(MediaType.APPLICATION_JSON).content(putEmployee));
        isHasDong = mockMvc.perform(get("/employees" )).andReturn().getResponse().getContentAsString().contains("dong");
        Assertions.assertEquals(true,isHasDong);
    }

    @Test
    void should_return_false_when_delete_employee_given_employee() throws Exception {
        String employee = "{\n" +
                "                    \"companyId\": 3,\n" +
                "                    \"age\": 18,\n" +
                "                    \"name\": \"david\",\n" +
                "                    \"gender\": \"male\"\n" +
                "}";
        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(employee));
        int davidId = employeeRepository.findByName("david").getId();
        mockMvc.perform(delete("/employees/"+davidId)).andExpect(status().isOk());
        boolean isHasDavid = mockMvc.perform(get("/employees")).andReturn().getResponse().getContentAsString().contains("david");
        Assertions.assertEquals(false,isHasDavid);

    }
}
