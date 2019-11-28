package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.Bean.UserBean;


@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn;

    public UserRegister() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("txex/html;charset=UTF-8");
		
		String Name = request.getParameter("Name");
		String Account = request.getParameter("Account");
		String Pwd = request.getParameter("Pwd");
		String Birth = request.getParameter("Birth");
		String Gender = request.getParameter("Gender");
		String Mobile = request.getParameter("Mobile");
		String Tel = request.getParameter("Tel");
		String UID = request.getParameter("UID");
		String Mail = request.getParameter("Mail");
		String Address = request.getParameter("Address");
	
		UserBean ub = new UserBean();
	
		ub.setName(Name);
		ub.setAccount(Account);
		ub.setPwd(Pwd);
		ub.setBirth(Birth);
		ub.setGender(Gender);
		ub.setMobile(Mobile);
		ub.setTel(Tel);
		ub.setUid(UID);
		ub.setMail(Mail);
		ub.setAddress(Address);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	public void init() {
		
		Context context;
		try {
			context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			 try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}
	
}
