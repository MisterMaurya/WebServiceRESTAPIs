package com.student.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.student.DAO.Impl.StudentDAOImpl;
import com.student.entity.Student;

@Controller
public class HomeController {

	@InitBinder
	public void initBuilder(WebDataBinder binder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(simpleDateFormat, false));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getIndexPage() {
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute("student") Student student, BindingResult result) {

		if (!result.hasErrors()) {

			Student student_info = new Student();
			student_info.setFirstName(student.getFirstName());
			student_info.setLastName(student.getLastName());
			student_info.setEmail(student.getEmail());
			student_info.setPassword(student.getPassword());
			student_info.setConfirmPassword(student.getConfirmPassword());
			student_info.setGender(student.getGender());
			System.out.println(student.getDob());
			student_info.setDob(student.getDob());
			System.out.println(student.getDob());
			student_info.setMobile(student.getMobile());
			/* student_info.setAddress(student.getAddress()); */

			StudentDAOImpl add = new StudentDAOImpl();
			boolean b = add.saveStudent(student_info);

			if (b) {
				ModelAndView mv = new ModelAndView("register");
				mv.addObject("success", "Successfully Registered!");
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("register");
				System.out.println("Error");
				return mv;
			}
		} else

		{
			ModelAndView mv = new ModelAndView("register");
			System.out.println("Error Occur");
			return mv;
		}
	}
}
