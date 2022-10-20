package com.qa.employee.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.qa.employee.model.Employee;

@Repository
public class EmployeeRepository {
	
	List<Employee> empList;
	
	public EmployeeRepository() {
		this.empList = Arrays.asList(
				new Employee(111,"emp1",232342.23),
				new Employee(222,"emp2",332342.23),
				new Employee(333,"emp3",432342.23)
				);
				
	}
	
	public List<Employee> getAllEmployees(){
		return this.empList;
	}
	
	public Employee addEmployee(Employee employee) {
		this.empList.add(employee);
		return employee;
	}
	
	public Employee getEmployeeById(int id) {
		return this.empList.stream().filter(emp -> emp.getId() == id).findFirst().get();
	}
	
	

}
