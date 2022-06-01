package com.jbk.dao;

import java.util.List;

import com.jbk.entity.Employee;

public interface EmployeeDao {
	
	public Employee saveEmployee(Employee employee);
	public Employee  getEmployeeById(String employeeId);
	public List<Employee>   getAllEmoployee();
	public Employee updateEmployee(Employee employee);
	public boolean  deleteEmployeeById(String employeeId);

}
