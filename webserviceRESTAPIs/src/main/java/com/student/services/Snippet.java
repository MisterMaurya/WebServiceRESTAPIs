package com.student.services;

import com.student.DAO.Impl.StudentDAOImpl;
import com.student.entity.Student;

public class Snippet {
	public static void main(String[] args) {
		StudentDAOImpl impl = new StudentDAOImpl();
		/*List<Student> list = impl.getStudentList();
		for(Student i:list) {
		System.out.println(i.getFirstName()+" "+i.getDob());
		}*/
		
		Student student = impl.getStudent("Pawan");
		System.out.println(student.getFirstName()+" "+student.getLastName());
	}
}

