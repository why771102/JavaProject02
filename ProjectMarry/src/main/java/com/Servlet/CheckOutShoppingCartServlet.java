package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

import com.Bean.OrderDetailProductsBean;
import com.Bean.OrderDetailVenuesBean;
import com.Service.ShoppingCartService;
import com.Service.ShoppingCartServiceImpl;
import com.Service.UserService;
import com.Service.UserServiceImpl;

import net.sf.json.JSONArray;
//import org.json.JSONArray;

@WebServlet("/CheckOutShoppingCartServlet")
public class CheckOutShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

	public CheckOutShoppingCartServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init();
		HttpSession session = request.getSession(false);

		if (session == null) {
			response.sendRedirect(getServletContext().getContextPath() + "/LogIn.jsp");
			return;
		}

		ShoppingCartService scs = new ShoppingCartServiceImpl(conn);
		UserService us = new UserServiceImpl(conn);
		Integer MemberId = us.getIdFromCookie(request);
		Integer OrderId = scs.getShoppingCart(MemberId);

		
		String ODPB = request.getParameter("product");
		String ODVB = request.getParameter("venue");
//		System.out.println("ODPB" +ODPB);
		JSONArray jsonArrayProduct = JSONArray.fromObject(ODPB);
		JSONArray jsonArrayVenue = JSONArray.fromObject(ODVB);		
		
		List<OrderDetailProductsBean> odpbSEND = new ArrayList<>();
		List<OrderDetailVenuesBean> odvbSEND = new ArrayList<>();
//		System.out.println("arrayProduct" + arrayProduct.get(0));
		for(int i = 0; i < jsonArrayProduct.size(); i++) {
			
			JSONArray arrayProduct = jsonArrayProduct.getJSONArray(i);
			System.out.println("arrayProduct.get(0) " + arrayProduct.get(0));
			System.out.println("arrayProduct.get(1) " + arrayProduct.get(1));
			
			OrderDetailProductsBean odpb = new OrderDetailProductsBean();
			odpb.setOrderID(OrderId);
			odpb.setProductID((String)arrayProduct.get(0));
			odpb.setQuantity(Integer.parseInt((String) arrayProduct.get(1)));
			System.out.println(odpb.getProductID());
			System.out.println(odpb.getQuantity());
			boolean result = scs.updateQty(odpb);
			System.out.println(result);
			odpbSEND.add(odpb);
		}
		
		for(int i = 0; i < jsonArrayVenue.size(); i++) {
			JSONArray arrayVenue = jsonArrayVenue.getJSONArray(i);
			System.out.println("arrayVenue.get(0) " + arrayVenue.get(0));
			System.out.println("arrayVenue.get(1) " + arrayVenue.get(1));
			OrderDetailVenuesBean odvb = new OrderDetailVenuesBean();
			odvb.setOrderID(OrderId);
			odvb.setProductID((String)arrayVenue.get(0));
			odvb.setTableCount(Integer.parseInt((String)arrayVenue.get(1)));
			boolean r = scs.updateTable(odvb);
			System.out.println(r);
			odvbSEND.add(odvb);
		}
			request.setAttribute("odpbSEND", odpbSEND);
			request.setAttribute("odvbSEND", odvbSEND);
			RequestDispatcher rd = request.getRequestDispatcher("/HTML/Checkout.jsp");
			rd.forward(request, response);
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
