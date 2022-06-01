package com.jbk.dao;

import com.jbk.entity.Department;

public interface DepartmentDao {
	
	public Department saveDepartment(Department department);
	public Department getDepartmentById(String departmentId);

}
