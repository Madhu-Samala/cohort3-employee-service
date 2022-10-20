package com.qa.employee.service;

import java.util.List;

import com.qa.employee.exception.EmployeeAlreadyExistsException;
import com.qa.employee.exception.EmployeeNotFoundException;
import com.qa.employee.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException;
	public Employee addEmployee(Employee employee) throws EmployeeAlreadyExistsException;

}
