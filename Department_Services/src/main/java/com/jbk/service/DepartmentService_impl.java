package com.jbk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.DepartmentDao;
import com.jbk.entity.Department;

@Service
public class DepartmentService_impl implements DepartmentService {
	
	
	
	@Autowired
	private DepartmentDao dao;

	@Override
	public Department saveDepartment(Department department) {
		
		return dao.saveDepartment(department) ;
	}

	@Override
	public Department getDepartmentById(String departmentId) {
		
		
		return dao.getDepartmentById(departmentId);
	}

}
