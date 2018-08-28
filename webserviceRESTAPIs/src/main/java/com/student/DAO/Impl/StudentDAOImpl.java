package com.student.DAO.Impl;

import java.util.List;

import org.hibernate.Session;

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

		return false;
	}

	public List<Student> getStudentList() {

		return null;
	}

}
