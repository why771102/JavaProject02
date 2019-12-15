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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.Bean.UserBean;
import com.Dao.UserDaoImpl;
import com.Service.UserServiceImpl;


@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn;

    public UserUpdate() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 init();
		 request.setCharacterEncoding("UTF-8");
		  response.setContentType("txex/html;charset=UTF-8");
		  
		  String Name = request.getParameter("Name");
		  String Birth = request.getParameter("Birth");
		  String Mobile = request.getParameter("Mobile");
		  String Tel = request.getParameter("Tel");
		  String Mail = request.getParameter("Mail");
		  String Address = request.getParameter("Address");
		  String Account = request.getParameter("Account");
		 
		  UserBean ub = new UserBean();
		 
		  ub.setName(Name);
		  ub.setBirth(Birth);
		  ub.setMobile(Mobile);
		  ub.setTel(Tel);
		  ub.setMail(Mail);
		  ub.setAddress(Address);
		  ub.setAccount(Account);
		  
		  UserServiceImpl udi = new UserServiceImpl(conn);
		  UserBean rub = udi.updateUserData(ub);
		  
		  if(rub == null) {
		   
		   request.setAttribute("user", rub);
		   RequestDispatcher rd = request.getRequestDispatcher("JSP");   //JSP
		   rd.forward(request, response);
		   
		   
		  }else {
		//   request.setAttribute("User", rub);
		//   HttpSession session = request.getSession();
		//   response.sendRedirect(request.getContextPath() + "/HTML/UserDataUpdate.jsp");
		//   return;
		   request.setAttribute("User", rub);
		   RequestDispatcher rd = request.getRequestDispatcher("/HTML/UserDataUpdate.jsp");   //JSP
		   rd.forward(request, response);
		   
		  }
		
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
