package com.Spring.User.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Spring.User.vo.User;

public class UserDao {
	
	ConnectionMaker connectionMaker;
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	
	public void add(User user) throws ClassNotFoundException, SQLException{
		Connection c = connectionMaker.getConnection();
		
		PreparedStatement ps = c.prepareStatement("insert into USERS(id, name, password) values(?,?,?)");
		
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
				
		System.out.println("실행 결과 : " + ps.executeUpdate());
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException{
		Connection c = connectionMaker.getConnection();
		
		PreparedStatement ps = c.prepareStatement("select * from USERS where id = ?");
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		User user = new User();
		user.setId(rs.getString(1));
		user.setName(rs.getString(2));
		user.setPassword(rs.getString(3));
				
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}

}
