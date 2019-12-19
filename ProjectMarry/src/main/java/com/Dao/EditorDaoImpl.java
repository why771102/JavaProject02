package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Interface.IEditorDao;
import com.editor.EditorBean;

public class EditorDaoImpl implements IEditorDao {
	
	Connection conn;

	public EditorDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public EditorBean register(EditorBean u) {
		String sqlstmt = "insert into Editor (EAccount,EPwd) values (?,?)";
		
		try {            
			PreparedStatement rs = conn.prepareStatement(sqlstmt);
            rs.setString(1, u.getAccount());
            rs.setString(2, u.getPwd());
			int status = rs.executeUpdate();
			rs.close();
			return u;
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public EditorBean updateUserData(EditorBean u) {
		
		String salstmt3 = "Update Editor set EPwd=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(salstmt3);
			stmt.setString(1, u.getPwd());
			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EditorBean userLogin(EditorBean u) {

		String sqlstmt1 = "select * from Editor where EAccount=?";
	 	try {
			PreparedStatement stmt = conn.prepareStatement(sqlstmt1);
			stmt.setString(1, u.getAccount());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				u.setId(rs.getInt("EditorID"));
				rs.close();
				stmt.close();
				return u;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean accountExists(EditorBean u) {
		boolean exist = false;
		String sqlstmt1 = "select * from Editor where EAccount=?";
	 	try {
			PreparedStatement stmt = conn.prepareStatement(sqlstmt1);
			stmt.setString(1, u.getAccount());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				exist = true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();		
		}
	 	
		return exist;
	}

	@Override
	public boolean pwdMatch(EditorBean u) {
		
		boolean match = false;
		String sqlstmt1 = "select * from Editor where EAccount=? and EPwd=?";
	 	try {
			PreparedStatement stmt = conn.prepareStatement(sqlstmt1);
			stmt.setString(1, u.getAccount());
			stmt.setString(2, u.getPwd());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				match = true;
				rs.close();
				stmt.close();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return match;
	}

	@Override
	public EditorBean userQuery(String account) {
		String sqlstmt = "select * from Editor where EAccount=?";
		EditorBean u = new EditorBean();
		try {
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			stmt.setString(1, account);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				u.setId(rs.getInt("EditorID"));
				u.setAccount(rs.getString("EAccount"));
			}
			rs.close();
			stmt.close();
			return u;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
}


