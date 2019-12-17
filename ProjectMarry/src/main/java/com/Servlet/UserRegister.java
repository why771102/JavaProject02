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
import com.Service.UserServiceImpl;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

	public UserRegister() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session;
		init();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String Name = request.getParameter("Name");
		String Account = request.getParameter("Account");
		String Pwd = request.getParameter("Pwd");
		String Pwd2 = request.getParameter("Pwd2");
		String Birth = request.getParameter("Birth");
		String Gender = request.getParameter("Gender");
		String Mobile = request.getParameter("Mobile");
		String Tel = request.getParameter("Tel");
		String UID = request.getParameter("Uid");
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

		Map<String, String> errorMsgMap = new HashMap<String, String>();

		if (Name == null || Name.trim().length() == 0) {
			errorMsgMap.put("NameEmptyError", "姓名欄位不得空白！");
		}
		if (Account == null || Account.trim().length() == 0) {
			errorMsgMap.put("AccountEmptyError", "帳號欄位不得空白！");
		}
		if (Pwd == null || Pwd.trim().length() == 0) {
			errorMsgMap.put("PwdEmptyError", "密碼欄位不得空白！");
		} else if (!Pwd.equals(Pwd2)) {
			errorMsgMap.put("PwdNotSameError", "密碼必須相同！");
		}
		if (Birth == null || Birth.trim().length() == 0) {
			errorMsgMap.put("BirthEmptyError", "生日欄位不得空白！");
		}
		if (Gender == null || Gender.trim().length() == 0) {
			errorMsgMap.put("GenderEmptyError", "性別欄位必須勾選！");
		}
		if (Mobile == null || Mobile.trim().length() == 0) {
			errorMsgMap.put("MobileEmptyError", "行動電話欄位不得空白！");
		}
		if (UID == null || UID.trim().length() == 0) {
			errorMsgMap.put("UIDEmptyError", "身分證字號欄位不得空白！");
		}
		if (Mail == null || Mail.trim().length() == 0) {
			errorMsgMap.put("MailEmptyError", "電子郵件欄位不得空白！");
		}
		if (Address == null || Address.trim().length() == 0) {
			errorMsgMap.put("AddressEmptyError", "住址欄位不得空白！");
		}

		 UserServiceImpl udi = new UserServiceImpl(conn);
		
		if (udi.accountExists(ub) == true) {
			errorMsgMap.put("AccountEmptyError2", "帳號已存在!");
		}

		if (udi.uidExists(ub) == true) {
			errorMsgMap.put("UIDEmptyError2", "身分證字號已被使用!");
		}
		
		if (!errorMsgMap.isEmpty()) {
			request.setAttribute("errorMsgMap", errorMsgMap);
			RequestDispatcher rd = request.getRequestDispatcher("/HTML/UserRegister.jsp"); // JSP
			rd.forward(request, response);
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		UserBean rub = udi.register(ub);

		if (rub == null) {

			request.setAttribute("user", rub);
			RequestDispatcher rd = request.getRequestDispatcher("/HTML/UserRegister.jsp"); // JSP
			rd.forward(request, response);

		} else {

			session = request.getSession();
			session.setAttribute("user", rub);
			response.sendRedirect(request.getContextPath() + "/HTML/UserRegisterSucess.jsp");

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return;
//			request.setAttribute("user", rub);
//			RequestDispatcher rd = request.getRequestDispatcher("/HTML/UserRegisterSucess.jsp");   //JSP
//			rd.forward(request, response);

		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
