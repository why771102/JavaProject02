
package com.Servlet;


import java.io.IOException;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.Date;


import javax.naming.Context;

import javax.naming.InitialContext;

import javax.naming.NamingException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import javax.sql.DataSource;


import com.Bean.OrderBean;

import com.Bean.OrderDetailProductsBean;

import com.Bean.OrderDetailVenuesBean;

import com.Bean.ProductBean;

import com.Bean.UserBean;

import com.Bean.VenueBean;

import com.Service.ShoppingCartServiceImpl;


/**

 * Servlet implementation class PutItemInShoppingCartServlet

 */

@WebServlet("/PutItemInShoppingCartServlet")

public class PutItemInShoppingCartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    Connection conn;


    public PutItemInShoppingCartServlet() {

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

        response.setContentType("txex/html;charset=UTF-8");


        ShoppingCartServiceImpl scs = new ShoppingCartServiceImpl(conn);

//        String Account = request.getParameter("Account");

//        String Pwd = request.getParameter("Pwd");

//        UserBean rub = udi.userLogin(ub);


        // 確認是否有帳號密碼，從cookies?取出東西來

        Cookie[] cookies = request.getCookies();

        String name = "";

//                cookies.getClass().getName();

        for (int i = 0; i < cookies.length; i++) {

            Cookie cook = cookies[i];

            name = cook.getName();

        }

//        UserBean user = request.getParameter("user");
//
//        OrderDetailProductsBean odpb = request.getParameter("product");
//
//        OrderDetailVenuesBean odvb = request.getParameter("Venue");

        // 如果 有登入

        if (name.equalsIgnoreCase(null)) {

            try {

                int ID = user.getId();

                // 確認是否 有status =0的 order ID 的購物車 將此orderID取出

                int orderID = scs.getShoppingCart(ID); // 看回傳值如果是0代表沒有購物車


                OrderBean ob = new OrderBean(orderID, ID, null, null, null, null, null, 0);


                // 如果沒有 新建一個 saveShoppingCart

                if (orderID == 0) {

                    boolean exist = scs.saveShoppingCart(ob);

                    boolean result = false;


                    if (exist == true) {

                        if (odpb.getProductID().equals(null)) {


                            result = scs.saveVenue(orderID, odvb);

                        } else {

                            result = scs.saveProduct(orderID, odpb);

                        }

                        if (result == true) {

                            System.out.println("新增orderdetail成功");

                        } else {

                            System.out.println("新增orderdetail失敗");

                        }


                    } else {

                        System.out.println("新增購物車失敗");

//                      return false;

                    }


                    // 購物車內有東西

                } else {

                    //// 判斷要加入的東西 是場地還是物品

                    boolean result = false;

                    //// 判斷要加入的東西 是場地

                    if (odpb.getProductID().equals(null)) {

                        OrderDetailVenuesBean Oldodvb = scs.querySameVenue(orderID, odvb);

                        if (Oldodvb.getTableCount() > 0) {

                            System.out.println("購物車內已經有此場地");


                        } else {

                            boolean saveresult = scs.saveVenue(orderID, odvb);

                            if (saveresult == true) {

                                System.out.println("放進商品購物車");

                            } else {

                            }

                        }

                        //// 判斷要加入的東西 是物品

                    } else {

                        // 先查查看有沒有相同的物品

                        OrderDetailProductsBean Oldodpb = scs.querySameProduct(orderID, odpb);

                        int Qtyresult = Oldodpb.getQuantity();

                        // 如果ＱＴＹ有 代表購物車已經有相同的物品

                        if (Qtyresult > 0) {

                            int newQty = odpb.getQuantity() + Qtyresult;

                            odpb.setQuantity(newQty);

                            boolean updateResult = scs.updateQty(odpb);

                            if (updateResult == true) {

                                System.out.println("更新Qty成功");

                            } else {

                            }

                        } else {

                            boolean saveresult = scs.saveProduct(orderID, odpb);

                            if (saveresult == true) {

                                System.out.println("放進商品購物車");

                            } else {

                            }

                        }


                    }

                }


            } catch (Exception e) {

            }


            // 如果 沒有登入 傳送到login

        } else {

            request.setAttribute("user", rub);

            RequestDispatcher rd = request.getRequestDispatcher("/HTML/LogIn.jsp"); // JSP

            rd.forward(request, response);

        }


    }


    /**

     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse

     *      response)

     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        // TODO Auto-generated method stub

        doGet(request, response);

    }


}



