package com.Spring.User.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DaoFactory {
	
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://45.119.144.118:3306/toad");
		dataSource.setUsername("root");
		dataSource.setPassword("tony950620!!");
		
		return dataSource;
	}
	
	@Bean
	public UserDao userDao(){
		UserDao userDao = new UserDao();
		userDao.setDataSource(dataSource());
		return userDao;
	}
}
