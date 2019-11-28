package com.Interface;

import com.Bean.UserBean;

public interface IUserDao {
	
	public UserBean register(UserBean u);

	public UserBean updateUserData(UserBean u);


	public UserBean userLogin(String account, String pwd);

}