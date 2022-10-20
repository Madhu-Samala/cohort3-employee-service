package com.qa.employee.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.qa.employee.model.Employee;

@Repository
public class EmployeeRepository {
	
	List<Employee> empList;
	
	
	public EmployeeRepository() {
		this.empList = new ArrayList<>();
	}
	
	public List<Employee> getAllEmployees(){
		return this.empList;
	}
	
	public Employee addEmployee(Employee employee) {
		this.empList.add(employee);
		return employee;
	}
	
	public Employee getEmployeeById(int id)  {
		Employee employee = null;
		employee = this.empList.stream().filter(emp -> emp.getId() == id).findFirst().get();
		return employee;
	}
	
	

}
