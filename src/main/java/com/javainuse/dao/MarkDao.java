package com.javainuse.dao;

import java.util.List;

import com.javainuse.model.AttributeValue;
import com.javainuse.model.Marks;

public interface MarkDao {
	String insertMark(Marks cus);
	Marks getMarks(Marks cus);
	void delete(String i);
	void edit(Marks cus);
	Marks search(String id);
}
