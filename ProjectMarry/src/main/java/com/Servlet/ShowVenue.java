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


@WebServlet("/ShowVenue")
public class ShowVenue extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn;

    public ShowVenue() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		init();
		HttpSession session;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		VenueServiceImpl vi = new VenueServiceImpl(conn);
		List<VenueBean> VList = vi.showVenueList();
		
		JSONArray ja = new JSONArray();
		
		for(int i = 0;i < VList.size();i++) {
			JSONObject productJsonObject = new JSONObject();
			productJsonObject.put("ProductID", VList.get(i).getProductID());
			productJsonObject.put("VendorID", VList.get(i).getVendorID());
			productJsonObject.put("Location", VList.get(i).getLocation());
			productJsonObject.put("Hall", VList.get(i).getHall());
			productJsonObject.put("TableCount", VList.get(i).getTableCount());
			productJsonObject.put("InOutdoor", VList.get(i).getInOutdoor());
			productJsonObject.put("LunchPrice", VList.get(i).getLunchPrice());
			productJsonObject.put("DinnerPrice", VList.get(i).getDinnerPrice());
			ja.put(productJsonObject);
		}
		
		String JsonArrayString = ja.toString();
		
		
		request.setAttribute("VList", JsonArrayString);
		session = request.getSession();
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(JsonArrayString);
		
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	public void init() {
		
		Context context;
		try {
			context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
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
