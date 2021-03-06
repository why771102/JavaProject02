package com.Service;

import javax.servlet.http.HttpServletRequest;

import com.Bean.UserBean;

public interface UserService {

	public UserBean register(UserBean ub);
	
	public UserBean updateUserData(UserBean u);

	public UserBean userLogin(UserBean u);
	
	public UserBean userQuery(String account);
	
	public boolean accountExists(UserBean u);
	
	public boolean uidExists(UserBean u);
	
	public boolean pwdMatch(UserBean u);
	
	public int getIdFromCookie(HttpServletRequest request);
	
	
}
