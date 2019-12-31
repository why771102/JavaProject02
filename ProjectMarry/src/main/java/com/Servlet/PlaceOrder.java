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

import com.Bean.OrderBean;
import com.Service.OrderService;
import com.Service.OrderServiceImpl;
import com.Service.ShoppingCartService;
import com.Service.ShoppingCartServiceImpl;
import com.Service.UserService;
import com.Service.UserServiceImpl;

/**
 * Servlet implementation class PlaceOrder
 */
@WebServlet("/PlaceOrder")
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;

	public PlaceOrder() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init();
		HttpSession session = request.getSession(false);

		if (session == null) {
			response.sendRedirect(getServletContext().getContextPath() + "/LogIn.jsp");
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		ShoppingCartService scs = new ShoppingCartServiceImpl(conn);
		OrderService os = new OrderServiceImpl(conn);

		UserService us = new UserServiceImpl(conn);
		Integer MemberId = us.getIdFromCookie(request);

		Integer OrderId = scs.getShoppingCart(MemberId);
		System.out.println("This is orderID=" + OrderId);
		OrderBean od = os.getOrder(OrderId);
		//改變status
		boolean result = os.updateStatus(od);
		System.out.println(result);
		
		//從orders table 取所有status =1 的資料 顯示在尚未付款頁面
		List<OrderBean> list = os.getAllOrders(MemberId,1);
		JSONArray getJa = new JSONArray();

		
		
		for(int i = 0;i<list.size();i++ ) {
			 //去取product 
//			 JSONObject pjo =new  JSONObject();
//			pjo.put(key, value)
//			 getJa.put(jo);
		}
		
		for(OrderBean ob: list) {
         
		 //去取product 
         JSONArray ja =  scs.showProduct(ob.getOrderID());//這邊會拿出某個orderID 的所有商品
         JSONObject pjo =new  JSONObject();//紀錄order訂單資訊
// 		 JSONObject  jo= (JSONObject) ja.get();//某個商品的資料
 		 
         pjo.put("orderDate", ob.getOrderDate());
         pjo.put("status", ob.getShippingStatus());
         pjo.put("shippingAddress", ob.getShippingAddress());
         pjo.put("orderDate", ob.getVATnumber());
         pjo.put("orderID",ob.getOrderID());
 		 ja.put(pjo);
		 getJa.put(ja);
		 
	
			 //去取venue
		}
		
		String getJaString = getJa.toString();
		
		//按下確認結帳後  跳進訂單頁面
		request.setAttribute("getJaString", getJaString);
		RequestDispatcher rd = request.getRequestDispatcher("/HTML/OrderDetailUnpaid.jsp");
		rd.forward(request, response);
		
		
//		os.getOrder(OrderId,1);
//		os.getOrder(OrderId, 2);
//		os.getOrder(OrderId, 3);
//		os.getOrder(OrderId, 4);
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
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
