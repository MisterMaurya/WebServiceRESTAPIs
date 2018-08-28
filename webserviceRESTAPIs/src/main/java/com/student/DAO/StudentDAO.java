package com.student.DAO;

import java.util.List;

import com.student.entity.Student;

public interface StudentDAO {
	
	public boolean saveStudent(Student student);

	public boolean updateStudent(Student student);

	List<Student> getStudentList();

}
