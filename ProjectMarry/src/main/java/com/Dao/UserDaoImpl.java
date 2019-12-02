package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Bean.UserBean;
import com.Interface.IUserDao;

public class UserDaoImpl implements IUserDao {
	
	Connection conn;

	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public UserBean register(UserBean u) {
		String sqlstmt = "insert into Members (Name, Account,Pwd,Birth,Gender,Mobile,Tel,UID,Mail,Address) values (?,?,?,?,?,?,?,?,?,?)";
		
		
		
		
		
		try {
			
			PreparedStatement rs = conn.prepareStatement(sqlstmt);
			rs.setString(1, u.getName());
			rs.setString(2, u.getAccount());
			rs.setString(3, u.getPwd());
			rs.setString(4, u.getBirth());
			rs.setString(5, u.getGender());
			rs.setString(6, u.getMobile());
			rs.setString(7, u.getTel());
			rs.setString(8, u.getUid());
			rs.setString(9, u.getMail());
			rs.setString(10, u.getAddress());
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public UserBean updateUserData(UserBean u) {

		return null;
	}

	@Override
	public UserBean userLogin(String account, String pwd) {

		return null;
	}

}


