package com.jbk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Department;

@Repository
public class DepartmentDao_impl implements DepartmentDao {

	@Autowired
	SessionFactory sf;

	@Override
	public Department saveDepartment(Department department) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.save(department);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();

		}

		return department;
	}

	@Override
	public Department getDepartmentById(String departmentId) {
		Session session = sf.openSession();
		Department dept = null;
		try {
			dept = session.get(Department.class, departmentId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

		}

		return dept;
	}

}
