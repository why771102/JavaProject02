package com.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
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
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

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
		
		Part part = request.getPart("photo1");
		InputStream in = part.getInputStream();
		String header = part.getHeader("Content-Disposition");
		System.out.println(header);
		// header=> form-data; name="photo"; filename="all.png" -- chrome, firefox
		// use indexOf to catch "filename" position
		int idx = header.indexOf("filename");
		System.out.println(idx);
		// idx=> position 25 will be the start of "filename"
		// use substring to extract the position of filename => all.png
		String filename = header.substring(idx + 10, header.length() - 1);

		byte[] buf = new byte[1024]; //1024 memory given here
		int length;
		while ((length = in.read(buf)) != -1) {
			try {
				Blob blob = new SerialBlob(buf);
				vis.processInsertImage(blob, "V1", filename);
			} catch (SerialException e) {

				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//		String savePath = this.getServletContext().getRealPath("Files");

//		List<Byte> photos = (List<Byte>)request.getInputStream();
//		for (Byte photo : photos) {
//			String header = photo.getHeader("Content-Dispostion");
//			int start = header.lastIndexOf("=");
//			String fileName = header.substring(start + 1).replace("\"", "");
//			
//			if(fileName != null && !"".equals(fileName)) {
//				photo.write(savePath + "/" + fileName);
//			}

//			vis.processInsertImage(photo, "V1", fileName);
//		}
		
		response.getWriter().append("Insert Successful!!").append(request.getContextPath());

		try {
			conn.close();
		} catch (SQLException e) {
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
