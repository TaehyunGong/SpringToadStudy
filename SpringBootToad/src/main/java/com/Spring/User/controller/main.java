package com.Spring.User.controller;

import java.sql.SQLException;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Spring.User.dao.CountingConnectionMaker;
import com.Spring.User.dao.CountingDaoFactory;
import com.Spring.User.dao.UserDao;
import com.Spring.User.vo.User;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//UserDao userdao = new DaoFactory().userDao();
		ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		UserDao userdao = context.getBean("userDao", UserDao.class);
		
		CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
		
		User user = new User();
		user.setId("" + new Random().nextInt(10000));
		user.setName("name");
		user.setPassword("123");
		
		userdao.add(user);
		System.out.println("결과1 : " + userdao.get(user.getId()));
		
		System.out.println("Dao 호출 횟수 : " + ccm.getCounter());
	}

}
