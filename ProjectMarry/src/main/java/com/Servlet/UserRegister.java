package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

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
		
		HashMap<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("errorMsg", errorMsg);
		
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
		
		if(Name == null || Name.trim().length() == 0) {
			errorMsg.put("NameEmptyError", "姓名為必填欄位");
		}
		
		if(Account == null || Account.trim().length() == 0) {
			errorMsg.put("AccountEmptyError", "帳號為必填欄位");
		}
		
		if(Pwd == null || Pwd.trim().length() == 0) {
			errorMsg.put("PwdEmptyError", "密碼為必填欄位");
		}
		
		if(Birth == null || Birth.trim().length() == 0) {
			errorMsg.put("BirthEmptyError", "生日為必填欄位");
		}
		
		if(Gender == null || Gender.trim().length() == 0) {
			errorMsg.put("GenderEmptyError", "性別為必填欄位");
		}
		
		if(Mobile == null || Mobile.trim().length() == 0) {
			errorMsg.put("MobileEmptyError", "行動電話為必填欄位");
		}
		
		if(Tel == null || Tel.trim().length() == 0) {
			errorMsg.put("TelEmptyError", "市話為必填欄位");
		}
		
		if(UID == null || UID.trim().length() == 0) {
			errorMsg.put("UIDEmptyError", "身分證字號為必填欄位");
		}
		
		if(Mail == null || Mail.trim().length() == 0) {
			errorMsg.put("MailEmptyError", "電子郵件為必填欄位");
		}
		
		if(Address == null || Address.trim().length() == 0) {
			errorMsg.put("AddressEmptyError", "住址為必填欄位");
		}
		
		if(!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("JSP");
			rd.forward(request, response);
			return;
		}
	
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
		
		UserDaoImpl udi = new UserDaoImpl(conn);
		UserBean rub = udi.register(ub);
		
		if(rub == null) {
			
			request.setAttribute("user", rub);
			RequestDispatcher rd = request.getRequestDispatcher("JSP");   //JSP
			rd.forward(request, response);
			
			
		}else {
			HttpSession session = request.getSession();
			response.sendRedirect(request.getContextPath() + "JSP");
			return;
			
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
