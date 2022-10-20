package com.qa.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qa.employee.exception.EmployeeAlreadyExistsException;
import com.qa.employee.exception.EmployeeNotFoundException;
import com.qa.employee.model.Employee;
import com.qa.employee.service.EmployeeServiceImpl;

@RestController
@RequestMapping("employee-service")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl empService;
	
	ResponseEntity<?> responseEntity;
	
	/*
	 * End Points          
	 *  getAllEmployees (GET)
	 */
	@GetMapping("/get-all-employees")
	public ResponseEntity<?> getAllEmployees(){
		try {
			List<Employee> empList = this.empService.getAllEmployees();
			responseEntity = new ResponseEntity<>(empList,HttpStatus.OK);
		} catch(Exception e) {
			responseEntity = new ResponseEntity<>("some internal error occured..Please try again",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	@GetMapping("/get-employee")
	public ResponseEntity<?> getEmployeeById(@RequestParam("id") int id) throws EmployeeNotFoundException{
		try {
			Employee employee = this.empService.getEmployeeById(id);
			responseEntity = new ResponseEntity<>(employee,HttpStatus.OK);
		} catch(EmployeeNotFoundException e) {
			throw e;
		} catch(Exception e) {
			responseEntity = new ResponseEntity<>("some internal error occured..Please try again",HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		return responseEntity;
	}
	
	
	@PostMapping("/add-employee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) throws EmployeeAlreadyExistsException{
		try {
			Employee addedEmployee = this.empService.addEmployee(employee);
			System.out.println("added employee" + addedEmployee);
			responseEntity = new ResponseEntity<>(employee,HttpStatus.CREATED);
		} catch(EmployeeAlreadyExistsException e) {
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>("some internal error occured..Please try again",HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}

}
