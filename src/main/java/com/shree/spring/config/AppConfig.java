package com.shree.spring.config;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.shree.spring.dao.UserDAO;
import com.shree.spring.dao.UserDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan("com.shree.spring")
public class AppConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/");
//		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/kishore");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean
	public UserDAO userDAO()
	{
		return new UserDAOImpl(getDataSource());
	}

}
