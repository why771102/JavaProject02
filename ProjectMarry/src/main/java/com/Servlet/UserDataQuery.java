package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
import javax.sql.DataSource;

import com.Bean.UserBean;
import com.Dao.UserDaoImpl;

@WebServlet("/UserDataQuery")
public class UserDataQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
       
    public UserDataQuery() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		init();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("txex/html;charset=UTF-8");
		UserDaoImpl udi = new UserDaoImpl(conn);
		Cookie[] cookies = request.getCookies();
		int i=0;
		String act = "";
		if(cookies != null) {
			for (i = 0; i < cookies.length; i++) {
                //依次取出
                Cookie temp = cookies[i];
                //判断一下
                if (temp.getName().equals("account")) {
                    act = temp.getValue();
                }
			}
		}
		UserBean u = udi.userQuery(act);
		request.setAttribute("User", u);

		RequestDispatcher rd = request.getRequestDispatcher("HTML/UserDataUpdate.jsp");   //JSP
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	public void init() {

		Context context;
		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
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
