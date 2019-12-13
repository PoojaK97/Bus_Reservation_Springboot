package com.javainuse.service;

import java.util.List;

import com.javainuse.model.AttributeValue;
import com.javainuse.model.Marks;


public interface MarksService {
	String insertMark(Marks emp);
	Marks getMarks(Marks passenger);
	void delete(String string);
	void edit(Marks stud);
	Marks search(String id);
}
