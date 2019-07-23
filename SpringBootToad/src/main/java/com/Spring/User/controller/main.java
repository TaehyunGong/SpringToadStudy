package com.Spring.User.controller;

import java.sql.SQLException;

import com.Spring.User.dao.DaoFactory;
import com.Spring.User.dao.UserDao;
import com.Spring.User.vo.User;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao userdao = new DaoFactory().userDao();

		User user = new User();
		user.setId("1");
		user.setName("ลยว๖");
		user.setPassword("123");
		
		userdao.add(user);
		
	}

}
