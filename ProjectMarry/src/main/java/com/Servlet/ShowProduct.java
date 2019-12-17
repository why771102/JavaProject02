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
import com.Service.ProductServiceImpl;


@WebServlet("/ShowProduct")
public class ShowProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn;

    public ShowProduct() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		init();
		HttpSession session;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		ProductServiceImpl pdi = new ProductServiceImpl(conn);
		List<ProductBean> PList = pdi.showProductList();
		
		System.out.println(PList.get(0).getProductName());
		JSONArray ja = new JSONArray();
		System.out.println(PList.size());
		
		for(int i = 0;i < PList.size();i++) {
			JSONObject productJsonObject = new JSONObject();
			productJsonObject.put("ProductID", PList.get(i).getProductID());
			productJsonObject.put("ProductName", PList.get(i).getProductName());
			productJsonObject.put("UnitPrice", PList.get(i).getUnitPrice());
			productJsonObject.put("ProductID", PList.get(i).getProductID());
			productJsonObject.put("PSupplierID", PList.get(i).getPSupplierID());
			productJsonObject.put("Quantity", PList.get(i).getQuantity());
			productJsonObject.put("ProductStatus", PList.get(i).getProductStatus());
			productJsonObject.put("Discount", PList.get(i).getDiscount());
			productJsonObject.put("Depiction", PList.get(i).getDepiction());
			ja.put(productJsonObject);
		}
		
		String JsonArrayString = ja.toString();
		
		
		request.setAttribute("PList", JsonArrayString);
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
