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

import org.json.JSONArray;
import org.json.JSONObject;

import com.Bean.ProductBean;
import com.Bean.VenueBean;
import com.Service.ProductServiceImpl;
import com.Service.VenueServiceImpl;

@WebServlet("/VenueDetail")
public class VenueDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

	public VenueDetail() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		init();
		HttpSession session;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		VenueServiceImpl pdi = new VenueServiceImpl(conn);

		String ProductID = request.getParameter("ProductID");
		String VenueID = request.getParameter("VenueID");

		VenueBean vb = new VenueBean();

		vb.setProductID(ProductID);
		vb.setVendorID(Integer.parseInt(VenueID));

		VenueBean nvb = pdi.VenueDetail(vb);
		
		String item = pdi.VenueName(vb);
		

		if (nvb == null) {

			session = request.getSession();
			response.sendRedirect(request.getContextPath() + "/HTML/NoProductError.jsp");
			
		} else {
			

			request.setAttribute("VB", nvb);
			request.setAttribute("Vendor", item);
			session = request.getSession();
			RequestDispatcher rd = request.getRequestDispatcher("HTML/venue.jsp");
			rd.forward(request, response);
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
