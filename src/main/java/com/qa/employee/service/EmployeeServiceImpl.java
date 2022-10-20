package com.qa.employee.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.employee.exception.EmployeeAlreadyExistsException;
import com.qa.employee.exception.EmployeeNotFoundException;
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
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
		Employee employee = null;
		try {
		employee = this.empRepository.getEmployeeById(id);
		} catch(NoSuchElementException e) {
			throw new EmployeeNotFoundException();
		}
		
		return employee;
	}

	@Override
	public Employee addEmployee(Employee employee) throws EmployeeAlreadyExistsException {
		/*
		 * Check if employee is already present in the list  if yes
		 * throw EmployeeAlreadyExistsException
		 * 
		 */
		Employee createdEmployee = null;
		try {
			Employee empExits = getEmployeeById(employee.getId());
			if(empExits != null) {
				throw new EmployeeAlreadyExistsException();
			}
		} catch (EmployeeNotFoundException e) {
			
			createdEmployee = this.empRepository.addEmployee(employee);
		}
		return createdEmployee;
	}

}
