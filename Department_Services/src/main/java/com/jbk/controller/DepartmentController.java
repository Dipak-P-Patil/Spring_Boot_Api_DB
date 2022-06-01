package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Department;
import com.jbk.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService service;

	@PostMapping("/saveDepartment")
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {

		Department dept = service.saveDepartment(department);

		if (dept != null) {
			return new ResponseEntity<>(dept, HttpStatus.CREATED);

		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/getDepartment/{departmentId}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable String departmentId) {
		Department dept = service.getDepartmentById(departmentId);

		if (dept != null) {
			return new ResponseEntity<>(dept, HttpStatus.OK);

		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
