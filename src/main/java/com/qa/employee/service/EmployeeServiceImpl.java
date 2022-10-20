package com.qa.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.employee.model.Employee;
import com.qa.employee.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;
	/*
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository empRepository) {
		this.empRepository = empRepository;
	} */

	@Override
	public List<Employee> getAllEmployees() {
		
		return this.empRepository.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return this.empRepository.getEmployeeById(id);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return this.empRepository.addEmployee(employee);
	}

}
