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

@WebServlet("/UpdateShoppingCartServlet")
public class UpdateShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       HttpSession session = null;
       Connection conn;
    public UpdateShoppingCartServlet() {
        super();
        
    }




	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		init();
		request.setCharacterEncoding("UFT-8");
		session = request.getSession(false);
		if(session == null) {
			response.sendRedirect(getServletContext().getContextPath() + "/LogIn.jsp");
		}
		
		ShoppingCartService scs = new ShoppingCartServiceImpl(conn);
		
		String cmd = request.getParameter("cmd");
		String memberID = request.getParameter("Id");//Cookie??需要再更改
		String quantity = request.getParameter("item");//改
		String vendor = request.getParameter("vendorID");
		OrderDetailProductsBean odpb= new OrderDetailProductsBean ();
		odpb.setProductID(request.getParameter("product")); 
		OrderDetailVenuesBean odvb = request.getParameter("Venue");
		
		int memID = Integer.parseInt(memberID.trim());

		if(cmd.equalsIgnoreCase("DELVENDOR")) {
			int vendorID = Integer.parseInt(vendor.trim());
			scs.deleteVendor(scs.getShoppingCart(memID), vendorID);
			RequestDispatcher rd = request.getRequestDispatcher("/ShoppingCart.jsp");
			rd.forward(request, response);
			return;
		}else if(cmd.equalsIgnoreCase("DELSUPPLIER")) {
			int supplierID = Integer.parseInt(item.trim());
			scs.deleteSupplier(scs.getShoppingCart(memID), supplierID);
			RequestDispatcher rd = request.getRequestDispatcher("/ShoppingCart.jsp");
			rd.forward(request, response);
			return;
		}else if(cmd.equalsIgnoreCase("DELVENUE")) {
			scs.deleteVenue(scs.getShoppingCart(memID), item);
			RequestDispatcher rd = request.getRequestDispatcher("/ShoppingCart.jsp");
			rd.forward(request, response);
			return;
		}else if(cmd.equalsIgnoreCase("DELPRODUCT")) {
			scs.deleteProduct(scs.getShoppingCart(memID), item);
			RequestDispatcher rd = request.getRequestDispatcher("/ShoppingCart.jsp");
			rd.forward(request, response);
			return;

			RequestDispatcher rd = request.getRequestDispatcher("/ShoppingCart.jsp");
			rd.forward(request, response);
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



