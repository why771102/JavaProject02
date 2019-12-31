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
import com.Service.UserServiceImpl;


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
		response.setContentType("text/html;charset=UTF-8");
		
		
		String Account = request.getParameter("Account");
		String Pwd = request.getParameter("Pwd");
	
		UserBean ub = new UserBean();
	
		ub.setAccount(Account);
		ub.setPwd(Pwd);

		
		UserServiceImpl udi = new UserServiceImpl(conn);
		
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		
		boolean existed = udi.accountExists(ub);
		
		if(existed == false) {
			errorMsgMap.put("noAccount", "帳號不存在！");
		}else if(udi.pwdMatch(ub) == false) {
			errorMsgMap.put("PwdNoMatch", "密碼錯誤！");
		}
		
		if(!errorMsgMap.isEmpty()) {
			request.setAttribute("errorMsgMap", errorMsgMap);
			RequestDispatcher rd = request.getRequestDispatcher("/HTML/LogIn.jsp");   //JSP
			rd.forward(request, response);
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		UserBean rub = udi.userLogin(ub);
		
		if(rub == null) {
			//基本上不會抵達的錯誤區
			session = request.getSession();
			session.setAttribute("user", rub);
			response.sendRedirect(request.getContextPath() + "/HTML/UserLogin.jsp");
//			return;   試試看不return，最後加close
		}else {
			//成功登入，導向登入後頁面
			Cookie cookie = new Cookie("account",ub.getAccount());
		    cookie.setMaxAge(7 * 24 * 60 * 60);
		    response.addCookie(cookie);
		    
		    cookie = new Cookie("name",ub.getName());
		    cookie.setMaxAge(7 * 24 * 60 * 60);
		    response.addCookie(cookie);
		    
		    cookie = new Cookie("memberId",ub.getId().toString());
		    cookie.setMaxAge(7 * 24 * 60 * 60);
		    response.addCookie(cookie);
		    
			request.setAttribute("user", rub);
			RequestDispatcher rd = request.getRequestDispatcher("/HTML/UserLoginSucess.jsp");   //JSP
			rd.forward(request, response);
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
