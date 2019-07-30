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
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao userdao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("" + new Random().nextInt(10000));
		user.setName("name");
		user.setPassword("123");
		
		userdao.add(user);
		
		User user2 = new User();
		user2 = userdao.get(user.getId());

		if(!user.getName().equals(user2.getName())) {
			System.out.println("테스트 실패 (name)"); 
		}else if(!user.getPassword().equals(user2.getPassword())) {
			System.out.println("테스트 실패 (password)"); 
		}else {
			System.out.println("조회 테스트 성공");
		}
		
	}
	
}
