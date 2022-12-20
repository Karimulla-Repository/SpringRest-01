package com.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="EMP")
@Data
public class EmployeeEntity {
	@Id
	private Integer empid;
	
	private String empname;
	
	private Double sal;
	
	private Integer deptno;
	

}
