package com.Interface;

import com.Bean.UserBean;

public interface IUserDao {
	
	public UserBean register(UserBean u);

	public UserBean updateUserData(UserBean u);

	public UserBean userLogin(UserBean u);
	
	public UserBean userQuery(String account);
	
	public boolean accountExists(UserBean u);
	
	public boolean uidExists(UserBean u);
	
	public boolean pwdMatch(UserBean u);

}
