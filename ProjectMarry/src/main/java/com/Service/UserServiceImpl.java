package com.Service;

import java.sql.Connection;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.Bean.UserBean;
import com.Interface.IUserDao;

public class UserServiceImpl implements UserService {

	private IUserDao uo;
	Connection conn;
	
	public UserServiceImpl(Connection conn) {
		this.conn = conn;
	}
	
	public IUserDao getUo() {
		return uo;
	}
	public void setUo(IUserDao uo) {
		this.uo = uo;
	}
	
	@Override
	public UserBean register(UserBean ub) {
		return uo.register(ub);
	}

	@Override
	public UserBean updateUserData(UserBean u) {
		
		return uo.updateUserData(u);
	}

	@Override
	public UserBean userLogin(UserBean u) {
		
		return uo.userLogin(u);
	}

	@Override
	public UserBean userQuery(String account) {
		
		return uo.userQuery(account);
	}

	@Override
	public boolean accountExists(UserBean u) {

		return uo.accountExists(u);
	}

	@Override
	public boolean uidExists(UserBean u) {

		return uo.uidExists(u);
	}

	@Override
	public boolean pwdMatch(UserBean u) {
		
		return uo.pwdMatch(u);
	}

	@Override
	public int getIdFromCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		int act = 0;
		if(cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
                //依次取出
                Cookie temp = cookies[i];
                //判断一下
                if (temp.getName().equals("memberId")) {
                    act = Integer.valueOf(temp.getValue());
                }
			}
		}
		return act;
	}
	
	
}
