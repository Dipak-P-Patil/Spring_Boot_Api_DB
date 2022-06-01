package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Employee;


@Repository
public class EmployeeDao_impl implements EmployeeDao {

	@Autowired
	SessionFactory sf;

	@Override
	public Employee saveEmployee(Employee employee) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {

			session.save(employee);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

		return employee;
	}

	@Override
	public Employee getEmployeeById(String employeeId) {
		Session session = sf.openSession();
		Employee emp = null;

		try {
			emp = session.get(Employee.class, employeeId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return emp;

	}

	@Override
	public List<Employee> getAllEmoployee() {

		Session session = sf.openSession();
		List<Employee> list = null;

		try {
			Criteria cr = session.createCriteria(Employee.class);
			list = cr.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//Employee emp = null;

		try {
		//	emp = session.get(Employee.class, employee.getEmployeeId());

			session.update(employee);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

		return employee;
	}

	@Override
	public boolean deleteEmployeeById(String employeeId) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		boolean b = false;
		try {

			Employee emp = session.load(Employee.class, employeeId);
			if (emp != null) {

				session.delete(emp);
				tx.commit();
				b = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return b;
	}

}

