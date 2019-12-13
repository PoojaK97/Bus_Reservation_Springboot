package com.javainuse.dao;

import java.util.List;

import com.javainuse.model.AttributeValue;
import com.javainuse.model.Student;

public interface StudentDao {
	List<Student> getAllStudents(Student stud);
}