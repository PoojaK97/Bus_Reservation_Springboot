package com.javainuse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javainuse.model.AttributeValue;
import com.javainuse.model.Marks;
import com.javainuse.model.Student;
import com.javainuse.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	//Landing Page
	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}
	
	//Go to Book Tickets Tab
	@RequestMapping(value = "/bookticket", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("stop", "stud", new Student());
	}
	
	//To get a list of buses for booking
		@RequestMapping(value = "/findbus", method = RequestMethod.POST)
		public ModelAndView processRequest3(@ModelAttribute("stud") Student stud) {
			List<Student> students = studentService.getAllEmployees(stud);
			if (students.size() > 0) {
				ModelAndView model = new ModelAndView("getBus");
				model.addObject("students", students);
				model.addObject("stud", stud);
				return model;
			}
			else {
				ModelAndView model = new ModelAndView("noBus");
				return model;
			}
		}

}
