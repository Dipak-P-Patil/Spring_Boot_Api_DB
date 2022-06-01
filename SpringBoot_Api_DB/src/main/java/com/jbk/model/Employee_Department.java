package com.jbk.model;

import com.jbk.entity.Employee;

public class Employee_Department {

	private Employee employee;
	private Department department;

	public Employee_Department() {
		super();

	}

	public Employee_Department(Employee employee, Department department) {
		super();
		this.employee = employee;
		this.department = department;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee_Department [employee=" + employee + ", department=" + department + "]";
	}

}
