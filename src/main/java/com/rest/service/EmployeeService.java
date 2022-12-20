package com.rest.service;

import java.util.List;

import com.rest.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	
	Employee fetchEmployeeById(Integer empid);
	
	List<Employee> fetchAllEmployee();
	
	Employee deleteEmployee(Integer empid);
	

}
