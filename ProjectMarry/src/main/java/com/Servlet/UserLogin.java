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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.Bean.UserBean;
import com.Dao.UserDaoImpl;


@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn;

    public UserLogin() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		init();
		HttpSession session;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("txex/html;charset=UTF-8");
		
		
		String Account = request.getParameter("Account");
		String Pwd = request.getParameter("Pwd");
	
		UserBean ub = new UserBean();
	
		ub.setAccount(Account);
		ub.setPwd(Pwd);

		
		UserDaoImpl udi = new UserDaoImpl(conn);
		
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		
		boolean existed = udi.accountExists(ub);
		
		if(existed == false) {
			errorMsgMap.put("noAccount", "帳號不存在！");
		}else if(udi.pwdMatch(ub) == false) {
			errorMsgMap.put("PwdNoMatch", "密碼錯誤！");
		}
		
		if(!errorMsgMap.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("login jsp");   //JSP
			rd.forward(request, response);
			return;
		}
		
		UserBean rub = udi.userLogin(ub);
		
		if(rub != null) {
			session = request.getSession();
			session.setAttribute("user", rub);
			response.sendRedirect(request.getContextPath() + "/HTML/UserLoginSucess.jsp");
			return;
		}else {
			request.setAttribute("user", rub);
			RequestDispatcher rd = request.getRequestDispatcher("/HTML/UserLogin.jsp");   //JSP
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
