package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.Repository.CompanyRepository;
import com.thoughtworks.springbootemployee.Repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.entity.Company;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class SpringBootEmployeeApplicationTests {
	@Mock
	private EmployeeRepository employeeRepository;

	@Mock
	private CompanyRepository companyRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@InjectMocks
	private CompanyServiceImpl companyService;

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
	void should_return_employee_when_find_by_id_given_employee_id() {
		//given
		int employeeId = 1;
		List<Employee> list = new ArrayList<>();
		Employee employee = new Employee("Female", 1, 4, "111");
		list.add(employee);
		Mockito.when(employeeRepository.findById(employeeId)).thenReturn(java.util.Optional.of(employee));
		//when
		Employee result = employeeService.findEmployeeById(employeeId);
		//then
		assertEquals(employeeId, result.getId());
	}


	@Test
	void should_return_oocl_company_when_getCompanyById_given_1() {

		//given
		Company company = new Company(1, "oocl");
		Mockito.when(companyRepository.findById(1)).thenReturn(java.util.Optional.of(company));

		//when
		Company result = companyService.getCompanyById(1);

		//then
		assertEquals("oocl", result.getName());
	}

	@Test
	void should_return_1_when_find_by_gender_given_one_male_one_female() {
		//given
		int employeeId = 1;
		List<Employee> list = new ArrayList<>();
		Employee employee = new Employee("Female", 1, 4, "111");
		Employee employee1 = new Employee("Male", 2, 4, "111");
		list.add(employee);
		list.add(employee1);
		Mockito.when(employeeRepository.findAll()).thenReturn(list);
		//when
		List<Employee> result = employeeService.findEmployeeByGender("Male");
		//then
		assertEquals(1, result.size());
	}

}
