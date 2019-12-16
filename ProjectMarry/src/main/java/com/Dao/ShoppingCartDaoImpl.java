package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.Bean.OrderBean;
import com.Bean.OrderDetailProductsBean;
import com.Bean.OrderDetailVenuesBean;
import com.Bean.ProductBean;
import com.Interface.ShoppingCartDao;

public class ShoppingCartDaoImpl implements ShoppingCartDao {
    Connection conn;

    public ShoppingCartDaoImpl(Connection conn) {
   	 this.conn = conn;
    }

    @Override
    public int getShoppingCart(int Id) {
   	 int OD = 0;
   	 String sqlstr = "Select OrderID From Orders Where ID=? and Status = 0";
//只撈status=0的 orderID 會撈少筆資料
   	 try {
   		 PreparedStatement ps = conn.prepareStatement(sqlstr);
   		 ps.setInt(1, Id);
   		 ResultSet rs = ps.executeQuery();
   		 while (rs.next()) {
   			 Integer OrderId = rs.getInt("OrderID");
   			 OD = OrderId;
   		 }
   		 rs.close();
   		 ps.close();
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   		 throw new RuntimeException("取得會員訂單Status錯誤");
   	 }
   	 return OD;
    }

    @Override
    public JSONArray showProduct(int orderId) {
   	 JSONObject jo = new JSONObject();
   	 JSONArray ja = new JSONArray();
   	 String sqlstr = "Select * From OrderDetailProducts as odp Full Outer Join "
   			 + "Products as p on p.ProductID = odp.ProductID Where OrderID= ? order by PSupplierID";
   	 try {
   		 PreparedStatement ps = conn.prepareStatement(sqlstr);
   		 ps.setInt(1, orderId);
   		 ResultSet rs = ps.executeQuery();
   		 while (rs.next()) {
   			 String productId = rs.getString("ProductID");
   			 String productName = rs.getString("ProductName");
   			 Integer Qty = rs.getInt("Quantity");
   			 Integer unitprice = rs.getInt("UnitPrice");
   			 Float discount = rs.getFloat("Discount");
   			 String pSupplier = rs.getString("PSupplierID");
   			 jo.put("ProductID", productId);
   			 jo.put("ProductName", productName);
   			 jo.put("Quantity", Qty);
   			 jo.put("UnitPrice", unitprice);
   			 jo.put("Discount", discount);
   			 jo.put("pSupplierId", pSupplier);
   			 ja.put(jo);
   		 }
   		 rs.close();
   		 ps.close();
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   		 throw new RuntimeException("取出product購物車資料失敗");
   	 }
   	 return ja;
    }

    @Override
    public JSONArray showVenue(int orderId) {
   	 JSONObject jo = new JSONObject();
   	 JSONArray ja = new JSONArray();
   	 String sqlstr = "Select * From OrderDetailVenues as odv left join Venue as v"
   			 + " on odv.ProductID = v.ProductID Where OrderID= ?";
   	 try {
   		 PreparedStatement ps = conn.prepareStatement(sqlstr);
   		 ps.setInt(1, orderId);
   		 ResultSet rs = ps.executeQuery();
   		 while (rs.next()) {
   			 String productId = rs.getString("ProductID");
   			 Integer startTime = rs.getInt("StartTime");
   			 String date = rs.getString("Date");
   			 Integer tableCount = rs.getInt("TableCount");
   			 String location = rs.getString("Location");
   			 String hall = rs.getString("Hall");
   			 Integer InOutdoor = rs.getInt("InOutdoor");
   			 Integer vendorId = rs.getInt("VendorID");
//   			 String vendor = rs.getString("Vendor");
   			 if (startTime == 0) {
   				 Integer lunchPrice = rs.getInt("LunchPrice");
   				 jo.put("Price", lunchPrice);
   			 } else {
   				 Integer dinnerPrice = rs.getInt("DinnerPrice");
   				 jo.put("Price", dinnerPrice);
   			 }
   			 jo.put("ProductID", productId);
   			 jo.put("StartTime", startTime);
   			 jo.put("Date", date);
   			 jo.put("TableCount", tableCount);
   			 jo.put("Location", location);
   			 jo.put("Hall", hall);
   			 jo.put("InOutdoor", InOutdoor);
   			 jo.put("VendorID", vendorId);
//   			 jo.put("vendor", vendor);
   			 ja.put(jo);
   		 }
   		 rs.close();
   		 ps.close();
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   		 throw new RuntimeException("取出Venue購物車資料失敗");
   	 }
   	 return ja;
    }

    @Override
    public List<OrderDetailVenuesBean> getVenue(int orderId) {
   	 List<OrderDetailVenuesBean> listODVB = new ArrayList<>();
   	 String sqlstr = "Select * From OrderDetailVenues WHERE OrderID=?";
   	 try {
   		 PreparedStatement ps = conn.prepareStatement(sqlstr);
   		 ps.setInt(1, orderId);
   		 ResultSet rs = ps.executeQuery();
   		 while (rs.next()) {
   			 OrderDetailVenuesBean odvb = new OrderDetailVenuesBean();
   			 odvb.setOrderID(rs.getInt(1));
   			 odvb.setProductID(rs.getString(2));
   			 odvb.setStartTime(rs.getInt(3));
   			 odvb.setDate(rs.getString(4));
   			 odvb.setTableCount(rs.getInt(5));
   			 listODVB.add(odvb);
   		 }
   		 rs.close();
   		 ps.close();
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   	 }
   	 return listODVB;

    }

    @Override
    public List<OrderDetailProductsBean> getProduct(int orderId) {
   	 List<OrderDetailProductsBean> listODPB = new ArrayList<>();
   	 String sqlstr = "Select * From OrderDetailProducts WHERE OrderID=?";
   	 try {
   		 PreparedStatement ps = conn.prepareStatement(sqlstr);
   		 ps.setInt(1, orderId);
   		 ResultSet rs = ps.executeQuery();
   		 while (rs.next()) {
   			 OrderDetailProductsBean odpb = new OrderDetailProductsBean();
   			 odpb.setOrderID(rs.getInt(1));
   			 odpb.setProductID(rs.getString(2));
   			 odpb.setQuantity(rs.getInt(3));
   			 listODPB.add(odpb);
   		 }
   		 rs.close();
   		 ps.close();
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   	 }
   	 return listODPB;

    }

    @Override
    public boolean deleteShoppingCart(int Id) {
   	 String sqlstr = "DELETE FROM Order WHERE ID=? and Status=0";
   	 try {
   		 PreparedStatement ps = conn.prepareStatement(sqlstr);
   		 ps.setInt(1, Id);
   		 if (ps.executeUpdate() != 0) {
   			 ps.close();
   			 return true;
   		 } else {
   			 ps.close();
   			 return false;
   		 }
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   		 throw new RuntimeException("刪除Orders表格失敗");
   	 }
    }

    @Override
    public boolean deleteVendor(int orderId, int vendorID) {
   	 boolean result = false;
   	 String sqlQuery = "SELECT ProductID FROM Venue WHERE vendorID = ?";
   	 String sqlDelete = "DELETE FROM OrderDetailVenues WHERE orderID = ? and ProductID=?";
   	 List<String> list = new ArrayList<>();
   	 try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
   		 stmt.setInt(1, vendorID);
   		 try (ResultSet rs = stmt.executeQuery();) {
   			 while (rs.next()) {
   				 String pID = rs.getString(1);
   				 list.add(pID);
   			 }
   			 rs.close();
   			 stmt.close();
   		 }
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   		 throw new RuntimeException("ShoppingCartDaoImpl的deleteVendor()的QueryVendorID出錯誤");
   	 }

   	 try (PreparedStatement stmt1 = conn.prepareStatement(sqlDelete);) {
   		 for (int i = 0; i < list.size(); i++) {
   			 stmt1.setInt(1, orderId);
   			 stmt1.setString(2, list.get(i));
   			 stmt1.execute();
   		 }
   		 stmt1.close();
   		 result = true;
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   		 result = false;
   		 throw new RuntimeException("ShoppingCartDaoImpl的deleteVendor()出錯誤");
   	 }
   	 return result;
    }

    @Override
    public boolean deleteVenue(int orderId, String productID) {
   	 boolean result = false;
   	 String sql = "DELETE FROM OrderDetailVenues WHERE orderId=? and productId=?";
   	 try (PreparedStatement stmt = conn.prepareStatement(sql);) {
   		 stmt.setInt(1, orderId);
   		 stmt.setString(2, productID);
   		 stmt.execute();
   		 result = true;
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   		 result = false;
   		 throw new RuntimeException("ShoppingCartDaoImpl的deleteVenue()出錯誤");
   	 }
   	 return result;
    }

    @Override
    public boolean deleteSupplier(int orderId, int supplierID) {
   	 boolean result = false;
   	 String sqlQuery = "SELECT ProductID FROM Products WHERE PSupplierID = ?";
   	 String sqlDelete = "DELETE FROM OrderDetailProducts WHERE OrderID = ? and ProductID = ?";
   	 List<String> list = new ArrayList<>();
   	 try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
   		 stmt.setInt(1, supplierID);
   		 try (ResultSet rs = stmt.executeQuery();) {
   			 while (rs.next()) {
   				 String pID = rs.getString(1);
   				 list.add(pID);
   			 }
   			 rs.close();
   			 stmt.close();
   		 }
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   		 result = false;
   		 throw new RuntimeException("ShoppingCartDaoImpl的deleteSupplier()出錯誤");
   	 }
   	 try (PreparedStatement stmt1 = conn.prepareStatement(sqlDelete);) {
   		 for (int i = 0; i < list.size(); i++) {
   			 stmt1.setInt(1, orderId);
   			 stmt1.setString(2, list.get(i));
   			 stmt1.execute();
   		 }
   		 stmt1.close();
   		 result = true;
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   		 result = false;
   		 throw new RuntimeException("ShoppingCartDaoImpl的deleteSupplier()出錯誤");
   	 }
   	 return result;
    }

    @Override
    public boolean deleteProduct(int orderId, String productID) {
   	 boolean result = false;
   	 String sql = "DELETE FROM OrderDetailProducts WHERE orderId=? and productId=?";
   	 try (PreparedStatement stmt = conn.prepareStatement(sql);) {
   		 stmt.setInt(1, orderId);
   		 stmt.setString(2, productID);
   		 stmt.execute();
   		 result = true;
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   		 result = false;
   		 throw new RuntimeException("ShoppingCartDaoImpl的deleteSupplier()出錯誤");
   	 }
   	 return result;
    }

    @Override
    public List<Integer> querytime_orderID(String productID, int time, String date) {
   	 List<Integer> orderIDs = new ArrayList<>();
   	 String sqlQuery = "SELECT orderID FROM OrderDetailVenues WHERE productID=? and Date=? and StartTime=?";
   	 try (PreparedStatement stmt = conn.prepareStatement(sqlQuery);) {
   		 stmt.setString(1, productID);
   		 stmt.setString(2, date);
   		 stmt.setInt(3, time);
   		 ResultSet rs = stmt.executeQuery();
   		 while (rs.next()) {
   			 Integer orderID = rs.getInt(1);
   			 orderIDs.add(orderID);

   		 }
   		 rs.close();
   		 stmt.close();
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   	 }
   	 return orderIDs;
    }

    @Override
    public boolean querytime_VenueStatus(List<Integer> orderIds) {
   	 // 若result = false 表示場地沒有被出租可以被下訂單
   	 boolean result = false;
   	 String sqlQuery = "SELECT Status FROM Orders WHERE OrderID=?";
   	 try {
   		 PreparedStatement stmt = conn.prepareStatement(sqlQuery);
   		 for (int orderID : orderIds) {
   			 stmt.setInt(1, orderID);
   		 }
   		 ResultSet rs = stmt.executeQuery();
   		 while (rs.next()) {
   			 int status = rs.getInt(1);
   			 if (status != 0 && status != 4) {
   				 result = true;
   			 } else {
   				 result = false;
   			 }
   		 }
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   	 }
   	 return result;
    }

    @Override
    public int getVenuePrice(int orderId, String productId) {
   	 int price = 0;
   	 // OrderDetailVenues DB
   	 String sqlstr = "SELECT StartTime FROM OrderDetailVenues WHERE OrderId= ? and ProductId= ?";
   	 try {
   		 PreparedStatement ps = conn.prepareStatement(sqlstr);
   		 ps.setInt(1, orderId);
   		 ps.setString(2, productId);
   		 ResultSet rs = ps.executeQuery();
   		 if (rs.next()) {
   			 Integer startTime = rs.getInt("StartTime");
   			 if (startTime == 0) {
   				 // Venue DB
   				 String sqlstr1 = "SELECT LunchPrice FROM Venue WHERE ProductId= ?";
   				 PreparedStatement ps1 = conn.prepareStatement(sqlstr1);
   				 ps1.setString(1, productId);
   				 ResultSet rs1 = ps1.executeQuery();
   				 if (rs.next()) {
   					 price = rs1.getInt("LunchPrice");
   				 }
   			 } else {
   				 String sqlstr1 = "SELECT DinnerPrice FROM Venue WHERE ProductId= ?";
   				 PreparedStatement ps1 = conn.prepareStatement(sqlstr1);
   				 ps1.setString(1, productId);
   				 ResultSet rs1 = ps1.executeQuery();
   				 if (rs.next()) {
   					 price = rs1.getInt("DinnerPrice");
   				 }
   			 }
   		 }
   		 rs.close();
   		 ps.close();
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   		 throw new RuntimeException("取得場地價錢失敗");
   	 }
   	 return price;
    }

//    public double getProductPrice(ProductBean pb) {
//   	 double subtotal = pb.getQuantity() * pb.getUnitPrice() * pb.getDiscount();
//   	 return subtotal;
//    }

    // 把購物車存進orders table status 從0改1
    @Override
    public boolean updateStatus(OrderBean ob) { // 會員下訂單????
   	 String sql = " update Orders set Status=? where ID=? and OrderID=?";
//String sql = “UPDATE Orders SET Status = 1 where ID=? and OrderID=?”;
   	 try {
   		 PreparedStatement state = conn.prepareStatement(sql);
   		 state.setInt(1, ob.getStatus());
   		 state.setInt(2, ob.getID());
   		 state.setInt(3, ob.getOrderID());
   		 state.executeUpdate();
   		 state.close();
   		 return true;

   	 } catch (Exception e) {
   		 e.printStackTrace();
   	 }
   	 return false;
    }

    // 按了購買後 如果有數量的更改
    @Override
    public boolean updateQty(OrderDetailProductsBean odpb) {
   	 String sql = " update OrderDetailVenuesBean set Quantity=? where OrderID=? and ProductID=?";
//String sql = “UPDATE OrderDetailProductsBean set Quantity=? where OrderID=? and ProductID=?";
   	 try {
   		 PreparedStatement state = conn.prepareStatement(sql);
   		 state.setInt(1, odpb.getQuantity());
   		 state.setInt(2, odpb.getOrderID());
   		 state.setString(3, odpb.getProductID());
   		 state.executeUpdate();
   		 state.close();
   		 return true;

   	 } catch (Exception e) {
   		 e.printStackTrace();
   	 }
   	 return false;
    }

    // 按了購買後 如果有數量的更改
    @Override
    public boolean updateTable(OrderDetailVenuesBean odvb) {
   	 String sql = " update OrderDetailVenuesBean set TableCount=? where OrderID=? and ProductID=?";
   	 try {
   		 PreparedStatement state = conn.prepareStatement(sql);
   		 state.setInt(1, odvb.getTableCount());
   		 state.setInt(2, odvb.getOrderID());
   		 state.setString(3, odvb.getProductID());
   		 state.executeUpdate();
   		 state.close();
   		 return true;

   	 } catch (Exception e) {
   		 e.printStackTrace();
   	 }
   	 return false;
    }

    @Override
    // 查詢庫存(假設庫存都沒了 delete購物車商品)
    public int queryQty(String ProductId) {
   	 String sql = "select Quantity from Products where productID= ?";
   	 int stockQty = 0;
   	 try {

   		 PreparedStatement state = conn.prepareStatement(sql);
   		 state.setString(1, ProductId);
   		 ResultSet rs = state.executeQuery();
   		 if (rs.next()) {
   			 stockQty = rs.getInt("Quantity");
   			 rs.close();
   			 state.close();
   			 return stockQty;

   		 } else {
   			 return stockQty;
   		 }
   	 } catch (Exception e) {
   		 e.printStackTrace();
   		 System.out.println("查詢庫存失敗");
   	 }

   	 return stockQty;
    }

    @Override
//  如果沒有相同的場地 儲存場地在OrderDetailVenuesBean
    public boolean saveVenue(int orderID, OrderDetailVenuesBean odvb) {
   	 String sql = "insert into OrderDetailVenues (OrderID,ProductID,StartTime,Date,TableCount) value(?,?,?,?,?) ";
   	 try {

   		 PreparedStatement state = conn.prepareStatement(sql);
   		 state.setInt(1, orderID);
   		 state.setString(2, odvb.getProductID());
   		 state.setInt(3, odvb.getStartTime());
   		 state.setString(4, odvb.getDate());
   		 state.setInt(5, odvb.getTableCount());
   		 state.execute();
   		 state.close();
   		 System.out.println("新增場地成功");
   		 return true;

   	 } catch (Exception e) {
   		 System.out.println("新增場地失敗");
   		 return false;
   	 }

    }

    @Override
//   如果沒有相同的商品 儲存商品在OrderDetailProducts
    public boolean saveProduct(int orderId, OrderDetailProductsBean pb) {
   	 String sql = "insert into OrderDetailProducts(OrderID,ProductID,Quantity) value(?,?,?) ";

   	 try {
   		 PreparedStatement state = conn.prepareStatement(sql);
   		 state.setInt(1, orderId);
   		 state.setString(2, pb.getProductID());
//   state.setString(3, pb.getProductName());
   		 state.setInt(3, pb.getQuantity());
//   state.setInt(4, pb.getUnitPrice());
//
//   state.setDouble(5, pb.getDiscount());
//        	state.setString(7, memo);
   		 state.execute();
   		 state.close();
   		 System.out.println("新增商品成功");
   		 return true;
   	 } catch (Exception e) {
   		 System.out.println("新增商品失敗");
   		 return false;
   	 }
    }

    @Override
    // 確認 member沒有購物車 幫他new一個
    public boolean saveShoppingCart(OrderBean ob) {
   	 String sql = "insert into Order(ID,Status) value(?,?) ";
   	 try {
   		 PreparedStatement state = conn.prepareStatement(sql);
   		 state.setInt(1, ob.getID());
   		 state.setInt(2, 0);
   		 state.execute();
   		 state.close();
   		 return true;
   	 } catch (Exception e) {
   		 return false;
   	 }
    }

    @Override
    // 在 OrderDetailProducts member 購物車裡找有沒有相同的商品
    public OrderDetailProductsBean querySameProduct(int orderId, OrderDetailProductsBean odpb) {
   	 OrderDetailProductsBean odpb2 = new OrderDetailProductsBean();
   	 try {
   		 String sql = "select * from OrderDetailProducts where OrderID=? and ProductID=?";
   		 PreparedStatement state = conn.prepareStatement(sql);
   		 state.setInt(1, orderId);
   		 state.setString(2, odpb.getProductID());
   		 ResultSet rs = state.executeQuery(sql);
   		 if (rs.next()) {
   			 odpb2.setOrderID(orderId);
   			 odpb2.setProductID(rs.getString("ProductID"));
//	odpb2.setProductName(rs.getString("ProductName"));
   			 odpb2.setQuantity(rs.getInt("Quantity"));
//	odpb2.setUnitPrice(rs.getInt("UnitPrice"));
//         	pb2.setDiscount(rs.getDouble(""));
//	odpb2.setMemo(rs.getString("Memo"));
   			 rs.close();
   			 state.close();
   		 } else {
   		 }
   		 odpb2.setQuantity(odpb.getQuantity() + odpb2.getQuantity());
   		 // 如果進去else odpb2 就會是null
   		 return odpb2;
   	 } catch (Exception e) {
   		 System.out.println("查詢失敗");
   		 return odpb2;
   	 }
    }

    @Override
    // 在 OrderDetailVenues member 購物車裡找有沒有相同的時間的場地
    public OrderDetailVenuesBean querySameVenue(int orderId, OrderDetailVenuesBean odvb) {
   	 OrderDetailVenuesBean odvb2 = new OrderDetailVenuesBean();
   	 try {
   		 String sql = "select * from OrderDetailVenues where OrderID=? and ProductID=? and StartTime=? and Date=?";
   		 PreparedStatement state = conn.prepareStatement(sql);
   		 state.setInt(1, orderId);
   		 state.setString(2, odvb.getProductID());
   		 state.setInt(3, odvb.getStartTime());
   		 state.setString(4, odvb.getDate());
   		 ResultSet rs = state.executeQuery(sql);
   		 if (rs.next()) {
   			 odvb2.setOrderID(orderId);
   			 odvb2.setProductID(rs.getString("ProductID"));
//	odpb2.setProductName(rs.getString("ProductName"));
   			 odvb2.setStartTime((rs.getInt("StartTime")));
   			 odvb2.setDate(rs.getString("Date"));
//	odpb2.setUnitPrice(rs.getInt("UnitPrice"));
//         	pb2.setDiscount(rs.getDouble(""));
//	odpb2.setMemo(rs.getString("Memo"));
   			 rs.close();
   			 state.close();
   		 } else {
   		 }

   		 // 如果進去else odpb2 就會是null

   	 } catch (Exception e) {
   		 System.out.println("查詢失敗");
   	 }
   	 return odvb2;
    }



    
}



