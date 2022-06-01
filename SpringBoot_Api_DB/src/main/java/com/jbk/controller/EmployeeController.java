package com.jbk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Employee;
import com.jbk.model.Department;
import com.jbk.model.Employee_Department;
import com.jbk.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	List<Employee> list = new ArrayList<>();

	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

		Employee emp = service.saveEmployee(employee);

		if (emp != null) {

			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		}

		else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/getEmployee/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String employeeId) {
		Employee emp = service.getEmployeeById(employeeId);

		if (emp != null) {
			return new ResponseEntity<>(emp, HttpStatus.OK);

		} else {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/getAllEmoployee")
	public ResponseEntity<List<Employee>> getAllEmoployee() {

		List<Employee> list = service.getAllEmoployee();

		if (list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {

			return new ResponseEntity<>(list, HttpStatus.OK);

		}

	}

	@PutMapping("/updateEmployee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		Employee emp = service.updateEmployee(employee);

		if (emp != null) {

			return new ResponseEntity<String>("Employee Updated Successfully", HttpStatus.OK);
		} else {

			return new ResponseEntity<String>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@DeleteMapping(value = "/deleteEmployee/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable String employeeId) {

		boolean b = service.deleteEmployeeById(employeeId);
		if (b == true) {

			return new ResponseEntity<>("deleted" + employeeId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Id not found" + employeeId, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping("/getDepartment/{departmentId}")
	public ResponseEntity<Department> getDepartment(@PathVariable String departmentId) {

		Department dept = service.getDepartmentById(departmentId);
		if (dept != null) {
			return new ResponseEntity<Department>(dept, HttpStatus.OK);

		} else {
			return new ResponseEntity<Department>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getEmployeeWithDepartment/{employeeId}")
	public ResponseEntity<Employee_Department> getEmployeeWithDepartment(@PathVariable String employeeId) {

		Employee_Department emp_dept = service.getEmployeeWithDepartment(employeeId);
		if (emp_dept != null) {

			return new ResponseEntity<>(emp_dept, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}

	}

	@GetMapping("/getAllEmployeeWithDepartment")
	public ResponseEntity<List<Employee_Department>> getAllEmployeeWithDepartment() {

		List<Employee_Department> list = service.getAllEmployeeWithDepartment();
		if (list.isEmpty()) {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(list, HttpStatus.OK);

		}

	}

}
