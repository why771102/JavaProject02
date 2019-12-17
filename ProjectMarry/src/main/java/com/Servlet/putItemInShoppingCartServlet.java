
package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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

import com.Bean.OrderBean;
import com.Bean.OrderDetailProductsBean;
import com.Bean.OrderDetailVenuesBean;
import com.Service.ShoppingCartServiceImpl;
import com.Service.UserService;
import com.Service.UserServiceImpl;

/**
 * 
 * Servlet implementation class PutItemInShoppingCartServlet
 * 
 */

@WebServlet("/PutItemInShoppingCartServlet")

public class putItemInShoppingCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection conn;

	public putItemInShoppingCartServlet() {

		super();

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		

		init();

		HttpSession session;

		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html;charset=UTF-8");

		ShoppingCartServiceImpl scs = new ShoppingCartServiceImpl(conn);

//        String Account = request.getParameter("Account");

//        String Pwd = request.getParameter("Pwd");

//        UserBean rub = udi.userLogin(ub);

		// 確認是否有帳號密碼，從cookies?取出東西來
		// 根據員工帳號尋找相對應ID
		UserService us = new UserServiceImpl(conn);
		Integer MemberId = us.getIdFromCookie(request);
		System.out.println(MemberId);


        OrderDetailProductsBean odpb = new  OrderDetailProductsBean();
        OrderDetailVenuesBean odvb = new OrderDetailVenuesBean();
		//Venue
        String  VendorID = request.getParameter("VendorID");
        if((request.getParameter("Time"))  !=  null && request.getParameter("Table")  !=  null ) {
		
		 odvb.setProductID(request.getParameter("ProductID")); 
		 System.out.println(request.getParameter("Time"));
		 odvb.setStartTime(Integer.parseInt(request.getParameter("Time")));
		 odvb.setDate( request.getParameter("Date"));
		 odvb.setTableCount( Integer.parseInt(request.getParameter("Table")));
		  request.getParameter("Vendor");
		  request.getParameter("Hall");
		  request.getParameter("Price");
		  request.getParameter("Time");
        }
		//Product
		  
		  if(request.getParameter("PSupplierID") != null ) { 
		  String SupplierID = request.getParameter("PSupplierID");
		 odpb.setProductID(request.getParameter("ProductID"));
		 odpb.setQuantity( Integer.parseInt(request.getParameter("Quantity")));
		  request.getParameter("ProductName");
		  request.getParameter("Price");
		  }
//		  request.getParameter("Date");
//		  request.getParameter("Time");
//		  

		// 如果 有登入
		  
		if (MemberId != 0) {
			  String resultText ="";  
			 
              String path =request.getHeader("referer");
			try {
              
				int ID = MemberId;

				// 確認是否 有status =0的 order ID 的購物車 將此orderID取出
                //
				int orderID = scs.getShoppingCart(ID); //如果有status =0的東西 就把orderID取出
				// 看回傳值如果是0代表沒有購物車
				 odpb.setOrderID(orderID);
				OrderBean ob = new OrderBean(orderID, ID, null, null, null, null, null, 0);

				// 如果沒有 新建一個 saveShoppingCart

				if (orderID == 0) {

					boolean exist = scs.saveShoppingCart(ob);//反正這個方法沒有存orderID
					int NeworderID = scs.getShoppingCart(ID);
					boolean result = false;

					// 新建 saveShoppingCart 成功
					if (exist == true) {

						if (VendorID != null) {
                            //把東西存在OrderVenuesdetail
							result = scs.saveVenue(NeworderID, odvb);

						} else if(request.getParameter("PSupplierID") != null) {
							 //把東西存在OrderProductdetail
							result = scs.saveProduct(NeworderID, odpb);

						}else {}

						if (result == true) {
							resultText+= "放進購物車成功";
							System.out.println("新增orderdetail DB成功");

						} else {
							resultText+= "放進購物車失敗";
							System.out.println("新增orderdetail DB失敗");

						}

					} else {
						resultText+= "新增購物車失敗";
						System.out.println("新增購物車失敗");

//                      return false;

					}
				

					// 購物車內有東西

				} else {

					//// 判斷要加入的東西 是場地還是物品

					boolean result = false;

					//// 判斷要加入的東西 是場地

					if (VendorID != null) {

						OrderDetailVenuesBean Oldodvb = scs.querySameVenue(orderID, odvb);
                        //有重複場地
						System.out.println(Oldodvb.getTableCount());
						if (Oldodvb.getTableCount() !=null) {
							resultText+= "購物車內已有相同時間的同樣場地";
							System.out.println("購物車內已經有此場地");
                        //沒有重複場地
						} else {

							boolean saveresult = scs.saveVenue(orderID, odvb);

							if (saveresult == true) {
								resultText+= "放場地進購物車成功";
								System.out.println("放進場地購物車");
							
							} else {

							}

						}

						//// 判斷要加入的東西 是物品

					} else if(request.getParameter("PSupplierID")!= null) {

						// 先查查看有沒有相同的物品

						OrderDetailProductsBean Oldodpb = scs.querySameProduct(orderID, odpb);

						int Qtyresult = Oldodpb.getQuantity();

						
						// 如果ＱＴＹ有 代表購物車已經有相同的物品
						if (Qtyresult > 0) {
                             
							int newQty = odpb.getQuantity() + Qtyresult;
							System.out.println(Qtyresult);
							System.out.println(odpb.getQuantity());
							 System.out.println(newQty);
							odpb.setQuantity(newQty);

							boolean updateResult = scs.updateQty(odpb);

							if (updateResult == true) {
								resultText+= "商品放進購物車,更新Qty成功";
								System.out.println("更新Qty成功");

							} else {
								resultText+= "商品放進購物車失敗 ,更新Qty失敗";
								System.out.println("更新Qty失敗");
							}
					    // 如果ＱＴＹ沒有  代表可以直接存進去
						} else {

							boolean saveresult = scs.saveProduct(orderID, odpb);

							if (saveresult == true) {
								resultText+= "商品放進購物車";
								System.out.println("放進商品購物車");
							

							} else {
								resultText+= "商品放進購物車失敗";
								System.out.println("放進商品購物車失敗");
							}
					

						}

					}

				}

			} catch (Exception e) {
				resultText+= "新增失敗";
                e.printStackTrace();
			}
			request.setAttribute("path",path );
			request.setAttribute("resultText",resultText );
			RequestDispatcher rd = request.getRequestDispatcher("HTML/putItemInShoppingCartSucess.jsp");   //JSP
			   rd.forward(request, response);

			

			// 如果 沒有登入 傳送到login

		} else {

			

			RequestDispatcher rd = request.getRequestDispatcher("/HTML/LogIn.jsp"); // JSP

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

		// TODO Auto-generated method stub

		doGet(request, response);

	}

}


