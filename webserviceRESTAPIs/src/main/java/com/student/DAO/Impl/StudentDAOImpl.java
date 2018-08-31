package com.student.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.student.DAO.StudentDAO;
import com.student.entity.Student;
import com.student.services.DBConnect;

public class StudentDAOImpl implements StudentDAO {

	Session session = null;
	DBConnect connect = null;

	public boolean saveStudent(Student student) {
		connect = new DBConnect();
		try {
			session = connect.getSession();
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean updateStudent(Student student) {
		connect = new DBConnect();
		try {
			session = connect.getSession();
			session.beginTransaction();
			session.update(student);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public List<Student> getStudentList() {
		List<Student> list = null;
		connect = new DBConnect();
		try {
			session = connect.getSession();
			session.beginTransaction();
			list = new ArrayList<Student>();
			list = session.createQuery("From Student").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		System.out.println(list);
		return list;
	}

	public Student getStudent(String firstName) {
		Student student_info = null;
		connect = new DBConnect();
		try {
			session = connect.getSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("firstName", firstName));
			student_info = (Student) criteria.uniqueResult();
			if (student_info == null)
				System.out.println(firstName);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return student_info;
	}
}
