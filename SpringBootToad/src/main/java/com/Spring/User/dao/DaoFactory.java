package com.Spring.User.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
	
	@Bean
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
	
	@Bean
	public UserDao userDao(){
		ConnectionMaker a = connectionMaker();
		return new UserDao(a);
	}
}
