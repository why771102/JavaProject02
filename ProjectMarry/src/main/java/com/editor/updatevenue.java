package com.editor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updatevenue")
public class updatevenue extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		IvenueImpl usedao=new IvenueImpl();
		
		JavaBean ven =usedao.updateVenue(request.getParameter("vendorid"),request.getParameter("productid"),request.getParameter("venueaddress"),request.getParameter("hall"),request.getParameter("tables"),request.getParameter("inoutdoor"),request.getParameter("lunchprice"),request.getParameter("dinnerprice")
				,request.getParameter("venuestatus"));
		request.setAttribute("ven", ven);
		JavaBean ven2 =usedao.queryVenue(request.getParameter("productid"));
		request.setAttribute("ven", ven2);
		request.getRequestDispatcher("HTML/completevenue.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
