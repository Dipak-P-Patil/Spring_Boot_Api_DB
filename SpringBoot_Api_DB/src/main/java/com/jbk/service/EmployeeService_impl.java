package com.jbk.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jbk.dao.EmployeeDao;
import com.jbk.entity.Employee;
import com.jbk.model.Department;
import com.jbk.model.Employee_Department;

@Service
public class EmployeeService_impl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Employee saveEmployee(Employee employee) {
		String employeeId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		employee.setEmployeeId(employeeId);

		return dao.saveEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(String employeeId) {

		return dao.getEmployeeById(employeeId);
	}

	@Override
	public List<Employee> getAllEmoployee() {

		return dao.getAllEmoployee();
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		Employee emp = dao.updateEmployee(employee);
		return emp;
	}

	@Override
	public boolean deleteEmployeeById(String employeeId) {
		boolean b = dao.deleteEmployeeById(employeeId);

		return b;
	}

	@Override
	public Department getDepartmentById(String departmentId) {

		Department dept = restTemplate.getForObject("http://localhost:8081/department/getDepartment/" + departmentId,
				Department.class);

		return dept;
	}

	@Override
	public Employee_Department getEmployeeWithDepartment(String employeeId) {

		Employee_Department emp_dept = new Employee_Department();

		Employee emp = getEmployeeById(employeeId);
		if (emp != null) {
			Department dept = getDepartmentById(emp.getDepartmentId());

			emp_dept.setEmployee(emp);
			emp_dept.setDepartment(dept);
			return emp_dept;

		} else {

			return null;
		}
	}

	@Override
	public List<Employee_Department> getAllEmployeeWithDepartment() {

		List<Employee_Department> Emp_Dept_list = new ArrayList<>();

		List<Employee> emplist = getAllEmoployee();

		for (Employee employee : emplist) {

			Employee_Department emp_dept = new Employee_Department();

			Department dept = getDepartmentById(employee.getDepartmentId());

			emp_dept.setEmployee(employee);
			emp_dept.setDepartment(dept);
			Emp_Dept_list.add(emp_dept);
		}

		return Emp_Dept_list ;
	}

}
