package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import com.Service.VenueImageService;
import com.Service.VenueImageServiceImpl;

/**
 * Servlet implementation class UploadOneFile
 */
@WebServlet("/UploadFiles")
@MultipartConfig
public class UploadFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

	public UploadFiles() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init();
		System.out.println("000000");
		VenueImageService vis = new VenueImageServiceImpl(conn);

		String savePath = this.getServletContext().getRealPath("Files");

		List<Part> photos = (List<Part>) request.getParts();
		for (Part photo : photos) {
			String header = photo.getHeader("Content-Dispostion");
			int start = header.lastIndexOf("=");
			String fileName = header.substring(start + 1).replace("\"", "");
			
			if(fileName != null && !"".equals(fileName)) {
				photo.write(savePath + "/" + fileName);
			}
			vis.processInsertImage(photo, "V1", fileName);
		}
		
		response.getWriter().append("Insert Successful!!").append(request.getContextPath());

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