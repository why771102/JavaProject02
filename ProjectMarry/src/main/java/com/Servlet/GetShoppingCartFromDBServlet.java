package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;

import com.Bean.OrderDetailProductsBean;
import com.Service.ShoppingCartService;
import com.Service.ShoppingCartServiceImpl;
import com.Service.UserService;
import com.Service.UserServiceImpl;

@WebServlet("/GetShoppingCartFromDBServlet")
public class GetShoppingCartFromDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
//    public GetShoppingCartFromDBServlet() {
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		init();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("getSC");

		//根據員工帳號尋找相對應ID
		UserService us = new UserServiceImpl(conn);
		Integer MemberId = us.getIdFromCookie(request);
		System.out.println(MemberId);
		
		try {
			String url = "/HTML/ShoppingCart.jsp";
			ShoppingCartService scs = new ShoppingCartServiceImpl(conn);
				// 依據該ID找相對應的OrderId
				Integer OrderId = scs.getShoppingCart(MemberId);
				System.out.println(OrderId);
				// 若OrderId不等於0則有放過購物車,將資料取出
				if (OrderId != 0) {
					// 判斷購物車物品是否有venue
					JSONArray venue = scs.showVenue(OrderId);
//					int venueSubtotal = 0;
					if (venue != null && venue.length() != 0) {
						// 是venue,比對該venue的時間是否已被訂走
						// 抓取array中每筆object
						for (int i = 0; i < venue.length(); i++) {
							JSONObject obj = (JSONObject) venue.get(i);
							String pId = obj.getString("ProductID");
							Integer st = obj.getInt("StartTime");
							String date = obj.getString("Date");
							// 計算場地價格
//							venueSubtotal = scs.getVenuePrice(OrderId, pId);
							// 場地是否被訂走的比對
							List<Integer> qId = scs.querytime_orderID(pId, st, date);
							boolean b = scs.querytime_VenueStatus(qId);
							if (b == true) {
								// 如果被訂走 => 表格不顯示
//								System.out.println(venue + "b");
								venue.remove(i);
//								System.out.println(venue + "af");
								
							} else {
								// false:沒被訂走 => 表格顯示但沒變動
							}
						}
						request.setAttribute("venueArray", venue);
//						System.out.println(venue);
					} else {
						// 沒有場地商品不做動作
					}
					// 判斷購物車物品是否有product
					JSONArray product = scs.showProduct(OrderId);
//					int productSubtotal = 0;
					if (product != null && product.length() != 0) {
						// 是product,比對其庫存數
						for (int i = 0; i < product.length(); i++) {
							JSONObject obj = (JSONObject) product.get(i);
							String pId = obj.getString("ProductID");
							int originQty = obj.getInt("Quantity");
							int productUnitPrice = obj.getInt("UnitPrice");
//							int productDiscount = obj.getInt("Discount");
							// 顯示產品的總價價格
//							productSubtotal = originQty * productUnitPrice * productDiscount;
							// 庫存數
							int stockQty = scs.queryQty(pId);
							obj.put("stockQty", stockQty);
							//下拉式選項最多10
							if (originQty <= stockQty) {
								//庫存量足夠, 下拉式欄位數量不變
//								out.write("下拉式欄位數量不變");

							} else if (originQty > stockQty && stockQty != 0) {
								// 庫存數查到是多少下拉就改多少
								OrderDetailProductsBean odpb = new OrderDetailProductsBean(OrderId, pId, stockQty);
								scs.updateQty(odpb);
								obj.put("Quantity", stockQty);
								
//								out.write("修正數量後的div");
							} else {
								// 不顯示div
							}
						}
						request.setAttribute("productArray", product);
					} else {
						// 沒有產品商品不做動作
						
					}
					int a = 123;
					request.setAttribute("a", a);
					RequestDispatcher rd = request.getRequestDispatcher(url);
					rd.forward(request, response);
				}else {
//					System.out.println(OrderId + "2");
				}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查詢DB內的購物車失敗..");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() {

		try {
			Context context = new InitialContext();
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
