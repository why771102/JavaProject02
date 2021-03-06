package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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

@WebServlet("/UpdateShoppingCartServlet")
public class UpdateShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       HttpSession session = null;
       Connection conn;
    public UpdateShoppingCartServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		init();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//判斷是否有登入
		session = request.getSession(false);
		if(session == null) {
			response.sendRedirect(getServletContext().getContextPath() + "/LogIn.jsp");
		}
		
		//獲取user的memberID
		ShoppingCartService scs = new ShoppingCartServiceImpl(conn);
		UserService us = new UserServiceImpl(conn);
		Integer MemberId = us.getIdFromCookie(request);
		
		Integer OrderId = scs.getShoppingCart(MemberId);
		
		String cmd = request.getParameter("cmd");
		String vID = request.getParameter("vId");
		String productID = request.getParameter("pId");
		
		
		if(cmd.equalsIgnoreCase("DELVENDOR")) {
			
			String VendorID = request.getParameter("vendorID");
			int vendorID = Integer.parseInt(VendorID);
			scs.deleteVendor(OrderId, vendorID);
			
		}else if(cmd.equalsIgnoreCase("DELSUPPLIER")) {
			
			String supplierID = request.getParameter("supplierID");
			int SupplierId = Integer.parseInt(supplierID);
			scs.deleteSupplier(OrderId, SupplierId);
			
		}else if(cmd.equalsIgnoreCase("DELVENUE")) {
			Integer StartTime = Integer.parseInt(request.getParameter("startTime"));
			scs.deleteVenue(OrderId, vID, StartTime);
			
		}else if(cmd.equalsIgnoreCase("DELPRODUCT")) {
			
			scs.deleteProduct(OrderId, productID);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("/GetShoppingCartFromDBServlet");
		rd.forward(request, response);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
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



