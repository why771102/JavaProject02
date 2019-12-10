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
		
		 String salstmt3 = "Update Members set  Name=?, Birth=?, Mobile=?, Tel=?, Mail=?, Address=? where Account=?";
		  try {
		   PreparedStatement stmt = conn.prepareStatement(salstmt3);
		   stmt.setString(1, u.getName());
		   stmt.setString(2, u.getBirth());
		   stmt.setString(3, u.getMobile());
		   stmt.setString(4, u.getTel());
		   stmt.setString(5, u.getMail());
		   stmt.setString(6, u.getAddress());
		   stmt.setString(7, u.getAccount());
		   stmt.executeUpdate();
		   return u;
		  } catch (SQLException e) {
		   
		   e.printStackTrace();
		  }

		  return null;
	}

	@Override
	public UserBean userLogin(UserBean u) {

		String sqlstmt1 = "select * from Members where Account=?";
	 	try {
			PreparedStatement stmt = conn.prepareStatement(sqlstmt1);
			stmt.setString(1, u.getAccount());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				u.setId(rs.getInt("ID"));
				u.setName(rs.getString("Name"));
				u.setBirth(rs.getString("Birth"));
				u.setMobile(rs.getString("Mobile"));
				u.setTel(rs.getString("Tel"));
				u.setUid(rs.getString("UID"));
				u.setMail(rs.getString("Mail"));
				u.setAddress(rs.getString("Address"));
				u.setGender(rs.getString("Gender"));
				return u;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
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


	@Override
	public boolean pwdMatch(UserBean u) {
		
		boolean match = false;
		String sqlstmt1 = "select * from Members where Account=? and Pwd=?";
	 	try {
			PreparedStatement stmt = conn.prepareStatement(sqlstmt1);
			stmt.setString(1, u.getAccount());
			stmt.setString(2, u.getPwd());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				match = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		
		return match;
		
		
	
	}


	@Override
	public UserBean userQuery(String account) {
		String sqlstmt = "select * from Members where account=?";
		UserBean u = new UserBean();
		try {
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			stmt.setString(1, account);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				u.setId(rs.getInt("ID"));
				u.setAccount(rs.getString("Account"));
				u.setName(rs.getString("Name"));
				u.setBirth(rs.getString("Birth"));
				u.setMobile(rs.getString("Mobile"));
				u.setTel(rs.getString("Tel"));
				u.setUid(rs.getString("UID"));
				u.setMail(rs.getString("Mail"));
				u.setAddress(rs.getString("Address"));
				u.setGender(rs.getString("Gender"));
				return u;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	

}


