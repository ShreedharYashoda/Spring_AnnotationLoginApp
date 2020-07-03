package com.shree.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shree.spring.dao.UserDAO;
import com.shree.spring.model.Users;

@Controller
public class LoginController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("uname") String name, @RequestParam("pwd") String pwd, ModelAndView mv) {
		Users user = new Users();
		user.setUserName(name);
		user.setUserPass(pwd);
		String type = userDAO.login(user);
		if (type.equals("admin")) {
			mv.addObject("msg", "Welcome to AdminHome Page");
		} else {
			mv.addObject("msg", "Welcome to UserHome Page");
		}
		mv.setViewName("result.jsp");
		return mv;
	}
	
	

}
