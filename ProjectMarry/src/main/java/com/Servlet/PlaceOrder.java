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

import com.Bean.OrderBean;
import com.Service.OrderService;
import com.Service.OrderServiceImpl;
import com.Service.ShoppingCartService;
import com.Service.ShoppingCartServiceImpl;
import com.Service.UserService;
import com.Service.UserServiceImpl;

/**
 * Servlet implementation class PlaceOrder
 */
@WebServlet("/PlaceOrder")
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;

	public PlaceOrder() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init();
		HttpSession session = request.getSession(false);

		if (session == null) {
			response.sendRedirect(getServletContext().getContextPath() + "/LogIn.jsp");
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		ShoppingCartService scs = new ShoppingCartServiceImpl(conn);
		OrderService os = new OrderServiceImpl(conn);

		UserService us = new UserServiceImpl(conn);
		Integer MemberId = us.getIdFromCookie(request);

		Integer OrderId = scs.getShoppingCart(MemberId);
		System.out.println("This is orderID=" + OrderId);
		OrderBean od = os.getOrder(OrderId);

		boolean result = os.updateStatus(od);
		System.out.println(result);
		RequestDispatcher rd = request.getRequestDispatcher("/HTML/OrderDetailUnpaid.jsp");
		rd.forward(request, response);
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
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
