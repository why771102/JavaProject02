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

import com.Dao.EditorDaoImpl;

@WebServlet("/EditorUserDataQuery")
public class EditorDataQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
       
    public EditorDataQuery() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		init();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		EditorDaoImpl udi = new EditorDaoImpl(conn);
		//做一個葉面，來getParamer，才能取到帳號
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
