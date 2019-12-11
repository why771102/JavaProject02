package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.Bean.UserBean;
import com.Dao.UserDaoImpl;


@WebServlet("/UserLogOut")
public class UserLogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn;

    public UserLogOut() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		init();
		HttpSession session;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("txex/html;charset=UTF-8");
		
		
			Cookie[] cookies =  request.getCookies();
			
			for(int i = 0; i > cookies.length; i++) {
				System.out.println(cookies[i]);
			}
			
			
			Cookie cookie = new Cookie("account","");
		    cookie.setMaxAge(0);
		    response.addCookie(cookie);
		    
		    cookie = new Cookie("name","");
		    cookie.setMaxAge(0);
		    response.addCookie(cookie);
		    
		    cookie = new Cookie("loginStatus","0");
		    cookie.setMaxAge(0);
		    response.addCookie(cookie);
		    
			RequestDispatcher rd = request.getRequestDispatcher("/HTML/UserLoginSucess.jsp");   //JSP
			rd.forward(request, response);
			
		

			
		

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
