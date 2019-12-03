package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			int status = rs.executeUpdate();
			
			return u;
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


	@Override
	public boolean accountExists(UserBean u) {
		boolean exist = false;
		String sqlstmt1 = "select * from Members where Account=?";
	 	try {
			PreparedStatement stmt = conn.prepareStatement(sqlstmt1);
			stmt.setString(1, u.getAccount());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				exist = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		
		return exist;
	}


	@Override
	public boolean uidExists(UserBean u) {
		boolean exist = false;
		String sqlstmt1 = "select * from Members where UID=?";
	 	try {
			PreparedStatement stmt = conn.prepareStatement(sqlstmt1);
			stmt.setString(1, u.getUid());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				exist = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		
		return exist;
	}

}


