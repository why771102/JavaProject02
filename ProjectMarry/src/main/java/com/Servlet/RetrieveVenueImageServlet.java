package com.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
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

import com.Bean.VenueImageBean;
import com.Service.VenueImageService;
import com.Service.VenueImageServiceImpl;

@WebServlet("/RetrieveVenueImageServlet")
public class RetrieveVenueImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init();
		OutputStream os = null;
		InputStream is = null;
		String imagename = null;
		String mimeType = null;
		Blob blob = null;
		try {
			String productID = request.getParameter("productID");
			System.out.println(productID);
			VenueImageService vis = new VenueImageServiceImpl(conn);
			VenueImageBean vib = vis.getVenueImage(productID);
			blob = vib.getVenueImage();
			if (blob != null) {
				is = blob.getBinaryStream();
			}
			imagename = vib.getImageName();
			
			mimeType = getServletContext().getMimeType(imagename);
			response.setContentType(mimeType);
			os = response.getOutputStream();
			int len = 0;
			byte[] bytes = new byte[8192];
			while((len = is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(is != null) {
				is.close();
			}
			if(os!= null) {
				os.close();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
