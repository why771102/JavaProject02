package com.editor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/createvenue")
public class createvenue extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		IvenueImpl usedao=new IvenueImpl();
		JavaBean ven=usedao.addVenue(request.getParameter("vendorid"),request.getParameter("venueaddress"),request.getParameter("hall"),request.getParameter("tables"),request.getParameter("inoutdoor"),request.getParameter("lunchprice"),request.getParameter("dinnerprice"));
		request.setAttribute("ven", ven);
	
		List<JavaBean> vens =usedao.queryallVenue();
		request.setAttribute("vens", vens);
		request.getRequestDispatcher("HTML/getallvenue.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
