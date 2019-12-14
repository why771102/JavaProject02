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

import com.Dao.EditorDaoImpl;
import com.editor.EditorBean;


@WebServlet("/EditorUpdate")
public class EditorUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn;

    public EditorUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String Account = request.getParameter("Account");
		String Pwd = request.getParameter("Pwd");
	
		EditorBean ub = new EditorBean();
	
		ub.setAccount(Account);
		ub.setPwd(Pwd);
		
		EditorDaoImpl udi = new EditorDaoImpl(conn);
		EditorBean rub = udi.updateUserData(ub);
		
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
