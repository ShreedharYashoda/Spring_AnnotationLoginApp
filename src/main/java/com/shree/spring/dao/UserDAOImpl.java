package com.shree.spring.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.shree.spring.model.Users;

@Repository
public class UserDAOImpl implements UserDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public UserDAOImpl(DriverManagerDataSource driverManagerDataSource) {
		jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
	}

	@Override
	public String login(Users user) {
		// TODO Auto-generated method stub
		return (String)jdbcTemplate.queryForObject("select type from userdetails where username=? and password=?", 
				   new Object[] {user.getUserName(),user.getUserPass()},String.class);
	}

	@Override
	public String forgot(String userName, String type) {
		// TODO Auto-generated method stub
		return (String)jdbcTemplate.queryForObject("select userpass from userdetails where username=? and type=?",
				new Object[] {userName,type},String.class);
	}
	

}
