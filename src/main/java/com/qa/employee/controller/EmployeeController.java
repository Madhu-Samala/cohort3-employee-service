package com.qa.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
