package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.Repository.CompanyRepository;
import com.thoughtworks.springbootemployee.Repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import com.thoughtworks.springbootemployee.service.impl.CompanyServiceImpl;
import com.thoughtworks.springbootemployee.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class SpringBootEmployeeApplicationTests {
	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Test
	void should_return_2_when_findAll_given_company_id_2_employee() {
		//given
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Female", 1, 4, "111"));
		list.add(new Employee("Female", 2, 4, "222"));
		Mockito.when(employeeRepository.findAll()).thenReturn(list);
		int companyId = 1;
		//when
		List<Employee> result = employeeService.getAllEmployee();
		//then
		assertEquals(2,result.size());
	}

	@Test
	void should_return_1_when_findAllInpange_given_3_employee_page2_pageSize_2() {
		//given
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Female", 1, 4, "111"));
		list.add(new Employee("Female", 2, 4, "222"));
		list.add(new Employee("Female", 3, 4, "333"));
		Mockito.when(employeeRepository.findAll()).thenReturn(list);
		//when
		List<Employee> result = employeeService.getEmployeeInPage(2, 2);
		//then
		assertEquals(1,result.size());
	}

	@Test
	void should_return_2_female_when_findByGender_given_2_female_and_1_male() {
		//given
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Female", 1, 4, "111"));
		list.add(new Employee("Female", 2, 4, "222"));
		list.add(new Employee("Male", 3, 4, "333"));
		Mockito.when(employeeRepository.findAll()).thenReturn(list);
		//when
		List<Employee> result = employeeService.getEmployeeByGender("Female");
		//then
		assertEquals(2,result.size());
	}

	@Test
	void should_return_111_when_findById_given_3_employee() {
		//given
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Female", 1, 4, "111"));
		list.add(new Employee("Female", 2, 4, "222"));
		list.add(new Employee("Male", 3, 4, "333"));
		Mockito.when(employeeRepository.findAll()).thenReturn(list);
		//when
		String result = employeeService.queryEmployee(1).getName();
		//then
		assertEquals("111", result);
	}


}
