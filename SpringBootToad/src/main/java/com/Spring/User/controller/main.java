package com.Spring.User.controller;

import java.sql.SQLException;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.Spring.User.dao.DaoFactory;
import com.Spring.User.dao.UserDao;
import com.Spring.User.vo.User;

public class main {

	public static void main(String[] args) throws SQLException {
		//UserDao userdao = new DaoFactory().userDao();
		//ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao userdao = context.getBean("userDao", UserDao.class);
		
		
		User user = new User();
		user.setId("" + new Random().nextInt(10000));
		user.setName("name");
		user.setPassword("123");
		
		userdao.add(user);
		System.out.println("결과 : " + userdao.get(user.getId()));
		
	}

}
