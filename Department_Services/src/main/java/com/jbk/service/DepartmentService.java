package com.jbk.service;

import com.jbk.entity.Department;

public interface DepartmentService {
	
	public Department saveDepartment(Department department);
	public Department getDepartmentById(String departmentId);

}
