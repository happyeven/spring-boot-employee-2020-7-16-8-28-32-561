package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.dto.EmployeeRequestDTO;
import com.thoughtworks.springbootemployee.dto.EmployeeResponseDTO;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.mapper.EmployeeMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapperTest {


    @Test
    void should_return_age_1_when_map_dto_to_entity_given_dto_with_age_1() {
        //given
        EmployeeRequestDTO employeeRequestDTO =new EmployeeRequestDTO();
        employeeRequestDTO.setAge(1);
        Company company = new Company("oocl");

        //when
        Employee employee = EmployeeMapper.employeeRequestDtoToEmployee(employeeRequestDTO,company);
        //then
        assertEquals(1,employee.getAge());
    }

}
