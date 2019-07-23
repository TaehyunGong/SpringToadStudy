package com.Spring.User.dao;

public class DaoFactory {
	
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
	
	public UserDao userDao(){
		ConnectionMaker a = connectionMaker();
		return new UserDao(a);
	}
}
