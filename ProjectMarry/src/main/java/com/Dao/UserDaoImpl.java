package com.Dao;

import com.Bean.UserBean;
import com.Interface.IUserDao;

public class UserDaoImpl implements IUserDao {

	@Override
<<<<<<< HEAD
	public UserBean register() {

=======
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
			
			boolean result = rs.execute();
			
			
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
>>>>>>> 635c5f0e43733cbcd01634b7047e20316e761593
		return null;
	}

	@Override
	public UserBean updateUserData() {

		return null;
	}

	@Override
	public UserBean userLogin() {

		return null;
	}

}
