package com.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Employee;

import com.rest.service.EmployeeService;
@RestController
@RequestMapping("/v1/api")
public class RestControllerApi {
	@Autowired
	EmployeeService service;
	//ErrorResponse errorResponse =new ErrorResponse();
	
	Employee employee = new Employee();
	@PostMapping("/employee")
	public ResponseEntity<Employee> creteEmployee(@RequestBody Employee employee){
			service.saveEmployee(employee);
	return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
	}
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Employee> fetchById(@PathVariable("id") Integer empid){
		Employee employee=service.fetchEmployeeById(empid);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		
	}
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> fetchAll(){
		List<Employee> myList =service.fetchAllEmployee();
		return new ResponseEntity<List<Employee>>(myList,HttpStatus.OK);
	}
	@PostMapping("/delete/{id}")
	public ResponseEntity<Employee> deleteById(@PathVariable("id") Integer empid){
		Employee employee = service.deleteEmployee(empid);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		
	}
}
