package com.Interface;

import com.Bean.UserBean;

public interface IUserDao {
	
	public UserBean register();

	public UserBean updateUserData();

	public UserBean userLogin();

}
