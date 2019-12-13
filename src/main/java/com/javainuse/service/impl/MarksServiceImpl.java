package com.javainuse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javainuse.dao.MarkDao;
import com.javainuse.model.AttributeValue;
import com.javainuse.model.Marks;
import com.javainuse.service.MarksService;

@Service
public class MarksServiceImpl implements MarksService {
	@Autowired
	MarkDao marksdao; 
	@Override
	public String insertMark(Marks emp) {
		// TODO Auto-generated method stub
		return marksdao.insertMark(emp);
	}
	@Override
	public Marks getMarks(Marks passenger) {
		return marksdao.getMarks(passenger);
	}
	@Override
	public void delete(String string) {
		marksdao.delete(string);
		
	}
	@Override
	public void edit(Marks stud) {
		marksdao.edit(stud);
		
	}
	@Override
	public Marks search(String id) {
		return marksdao.search(id);
	}


}
