package com.student.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.student.DAO.Impl.StudentDAOImpl;
import com.student.entity.Student;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@RequestMapping(value = "/students", method = RequestMethod.GET)

	public ArrayList<Student> getStudentList() {
		StudentDAOImpl getList = new StudentDAOImpl();
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList = (ArrayList<Student>) getList.getStudentList();
		return studentList;
	}

	@RequestMapping(value = "/getstudent/{name}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("name") String firstName) {
		StudentDAOImpl getInfo = new StudentDAOImpl();
		Student student_info = getInfo.getStudent(firstName);
		return student_info;
	}

	
	//In progress
	/*@RequestMapping(value = "/updatestudent/{name}",method=RequestMethod.PUT)
	public boolean updateStudent(@PathVariable("name") String firstName,@RequestBody Student student) {
		
		
		return false;
	}*/

}
