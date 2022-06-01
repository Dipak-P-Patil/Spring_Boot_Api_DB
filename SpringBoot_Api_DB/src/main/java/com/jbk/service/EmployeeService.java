package com.jbk.service;

import java.util.List;

import com.jbk.entity.Employee;

import com.jbk.model.Department;
import com.jbk.model.Employee_Department;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public Employee getEmployeeById(String employeeId);

	public List<Employee> getAllEmoployee();

	public Employee updateEmployee(Employee employee);

	public boolean deleteEmployeeById(String employeeId);
	
	
	//MicroServices Api

	public Department getDepartmentById(String departmentId);

	public Employee_Department getEmployeeWithDepartment(String employeeId);

	public List<Employee_Department> getAllEmployeeWithDepartment();

}
