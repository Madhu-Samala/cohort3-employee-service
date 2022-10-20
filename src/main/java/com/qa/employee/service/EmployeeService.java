package com.qa.employee.service;

import java.util.List;

import com.qa.employee.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
	public Employee addEmployee(Employee employee);

}
