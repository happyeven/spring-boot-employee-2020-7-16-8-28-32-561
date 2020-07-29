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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
		assertEquals(employeeId, employee.getId());
	}

	@Test
	void should_return_0_when_delete_employee_given_one_employee() {
		//given
		int employeeId = 1;
		List<Employee> list = new ArrayList<>();
		Employee employee = new Employee("Female", employeeId, 4, "111");
		list.add(employee);
		Mockito.when(employeeRepository.findAll()).thenReturn(list);
		//when
		employeeService.deleteEmployee(employeeId);
		//then
		assertEquals(0, employeeService.getAllEmployee().size());
	}


}
