package com.shree.spring.dao;

import com.shree.spring.model.Users;

public interface UserDAO {
	
	public String login(Users user);
	public String forgot(String userName, String type);

}
