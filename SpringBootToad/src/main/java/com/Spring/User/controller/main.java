package com.Spring.User.controller;

import java.sql.SQLException;
import java.util.Random;

import com.Spring.User.dao.DaoFactory;
import com.Spring.User.dao.UserDao;
import com.Spring.User.vo.User;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao userdao = new DaoFactory().userDao();

		User user = new User();
		user.setId("" + new Random().nextInt(10000));
		user.setName("태현공");
		user.setPassword("123");
		
		userdao.add(user);
		
		System.out.println("결과2 : " + userdao.get(user.getId()));
		
	}

}
