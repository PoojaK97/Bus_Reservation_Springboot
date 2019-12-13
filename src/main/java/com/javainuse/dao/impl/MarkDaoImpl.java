package com.javainuse.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.javainuse.dao.MarkDao;
import com.javainuse.model.AttributeValue;
import com.javainuse.model.Marks;
import com.javainuse.model.Student;

@Repository
public class MarkDaoImpl extends JdbcDaoSupport implements MarkDao {
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	//Insert into Boarding Details Table
	@Override
	public String insertMark(Marks cus) {
		Random r = new Random();
		int a = r.nextInt(100);
		String sql = "INSERT INTO boarding " +
				"(ID, Name, Contact, Email, BusID, Tickets) VALUES (?, ?, ?, ?, 1, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				Integer.toString(a), cus.getName(), cus.getContact(), cus.getEmail(), cus.getTickets()
		});
		return Integer.toString(a);
	}
	
	//To get the passenger boarding details
	@Override
	public Marks getMarks(Marks cus) {
		String sql = "SELECT  * FROM boarding where ID='"+cus.getId()+"'";
		Marks emp = new Marks();
	    List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		List<Marks> result = new ArrayList<Marks>();
		for(Map<String, Object> row:rows){
			emp.setId((String)row.get("ID"));
			emp.setName((String)row.get("Name"));
			emp.setContact((Integer)row.get("Contact"));
			emp.setEmail((String)row.get("Email"));
			emp.setBusId((String)row.get("BusID"));
			emp.setTickets((Integer)row.get("Tickets"));
		}
		return emp;
	}
	
	//To get the passenger boarding details
		@Override
		public Marks search(String id) {
			String sql = "SELECT  * FROM boarding where ID='"+id+"'";
			Marks emp = new Marks();
		    List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
			List<Marks> result = new ArrayList<Marks>();
			for(Map<String, Object> row:rows){
				emp.setId((String)row.get("ID"));
				emp.setName((String)row.get("Name"));
				emp.setContact((Integer)row.get("Contact"));
				emp.setEmail((String)row.get("Email"));
				emp.setBusId((String)row.get("BusID"));
				emp.setTickets((Integer)row.get("Tickets"));
			}
			return emp;
		}

	//Cancel Booking, delete from database
	@Override
	public void delete(String i) {
		String sql = "DELETE FROM boarding WHERE ID=" + "'" + i + "'";
		getJdbcTemplate().execute(sql);
	}
	
	//Update Details, Set Values
	@Override
	public void edit(Marks cus) {
		// TODO Auto-generated method stub
		String sql = "UPDATE boarding set ID=?, Name=? , Contact=?, Email=?, BusID=?, Tickets=?" ;
		getJdbcTemplate().update(sql, new Object[]{
				cus.getId(), cus.getName(), cus.getContact(), cus.getEmail(), cus.getBusId(), cus.getTickets()
		});
	}
	
	

}
