package com.Dao;

import com.Bean.UserBean;
import com.Interface.IUserDao;

public class UserDaoImpl implements IUserDao {

	@Override
	public UserBean register(UserBean u) {
		String sqlstmt = "insert into Members (Name, Account,Pwd,Birth,Gender,Mobile,Tel,UID,Mail,Address) values (?,?,?,?,?,?,?,?,?,?)";
		
		
		
		
		
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


