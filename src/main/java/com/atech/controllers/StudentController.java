package com.atech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atech.entity.Student;
import com.atech.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	private final StudentService studentService;
	
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("/list")
	public String getStudents(Model theModel) {
		
		List<Student> theStudents = studentService.getStudents();
		
		theStudents.forEach(std -> System.out.println(std));
		
		theModel.addAttribute("students", theStudents);
		
		return "students";
	}
	
}
