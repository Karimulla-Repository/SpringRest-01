package com.rest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entity.EmployeeEntity;
import com.rest.exception.EmployeeNotFoundException;
import com.rest.model.Employee;
import com.rest.repository.EmployeeRepository;
import com.rest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository repository;

	@Override
	public Employee saveEmployee(Employee employee) {
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, entity);
		repository.save(entity);
		return employee;
	}

	@Override
	public Employee fetchEmployeeById(Integer empid) {
	if(repository.existsById(empid)) {
	Optional<EmployeeEntity> opt = repository.findById(empid);
		EmployeeEntity emp=opt.get();
		Employee employee = new Employee();
		BeanUtils.copyProperties(emp, employee);
		
		return employee;
	}else {
		throw new EmployeeNotFoundException("Employee Does Not Exist With empno:"+empid);
	}	
	
	}

	@Override
	public List<Employee> fetchAllEmployee() {
		
	List<EmployeeEntity> listOfEntity = repository.findAll();
	List<Employee> listOfModels = new ArrayList<Employee>();
	listOfEntity.forEach(entity ->{
		Employee employee = new Employee();
		BeanUtils.copyProperties(entity, employee);
		listOfModels.add(employee);
	});
	return listOfModels;
	
	}

	@Override
	public Employee deleteEmployee(Integer empid) {
		if(repository.existsById(empid)) {
		Optional<EmployeeEntity> opt = repository.findById(empid);
		EmployeeEntity employee = opt.get();
		Employee emp = new Employee();
		BeanUtils.copyProperties(employee, emp);
			repository.delete(employee);
			return emp;
		}else {
			throw new EmployeeNotFoundException("Employee Does Not Exist With empno:"+empid);
			
		}
		
	}

}
