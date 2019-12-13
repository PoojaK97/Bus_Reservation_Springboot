package com.javainuse.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.javainuse.dao.StudentDao;
import com.javainuse.model.AttributeValue;
import com.javainuse.model.Student;

@Repository
public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	//Fetch the buses from database
		@Override
		public List<Student> getAllStudents(Student s){
			String sql = "SELECT * FROM bus where Destination="+"'"+s.getDestination()+"' and Source='"+s.getSource()+"' and Date='"+s.getDate()+"'";
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
			List<Student> result = new ArrayList<Student>();
			for(Map<String, Object> row:rows){
				Student emp = new Student();
				emp.setBusId((String)row.get("BusID"));
				emp.setName((String)row.get("Name"));
				emp.setSource((String)row.get("Source"));
				emp.setDestination((String)row.get("Destination"));
				emp.setDate((String)row.get("Date"));
				emp.setDeparture((String)row.get("Departure"));
				emp.setArrival((String)row.get("Arrival"));
				emp.setRating((Integer)row.get("Rating"));
				emp.setPrice((String)row.get("Price"));
				result.add(emp);
			}
			return result;
		}
}