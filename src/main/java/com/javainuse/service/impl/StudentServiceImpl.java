package com.javainuse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javainuse.dao.StudentDao;
import com.javainuse.model.AttributeValue;
import com.javainuse.model.Student;
import com.javainuse.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao employeeDao;

	public List<Student> getAllEmployees(Student stud) {
		return employeeDao.getAllStudents(stud);
	}
	

}