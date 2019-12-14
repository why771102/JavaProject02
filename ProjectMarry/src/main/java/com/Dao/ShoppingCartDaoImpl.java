package com.Dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bean.OrderBean;
import com.Bean.OrderDetailProductsBean;
import com.Bean.OrderDetailVenuesBean;
import com.Bean.ProductBean;
import com.Bean.VenueBean;
import com.Interface.ShoppingCartDao;

public class ShoppingCartDaoImpl implements ShoppingCartDao {
    Connection conn;

    public ShoppingCartDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int getShoppingCart(int Id) {
        int OD = 0;
        String sqlstr = "Select Status, OrderID From Order Where ID= ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlstr);
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Integer status = rs.getInt("Status");
                Integer OrderId = rs.getInt("OrderID");
                if (status == 0) {
                    OD = OrderId;
                }
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
    public OrderDetailVenuesBean getVenue(int orderId) {
        OrderDetailVenuesBean odvb = null;
        String sqlstr = "Select * From OrderDetailVenues Where OrderID= ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlstr);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String productId = rs.getString("ProductID");
                Integer time = rs.getInt("StartTime");
                String date = rs.getString("Date");
                Integer tableCount = rs.getInt("TableCount");
                odvb = new OrderDetailVenuesBean(orderId, productId, time, date, tableCount);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("取得會員訂單Status錯誤");
        }
        return odvb;
    }

    @Override
    public JSONObject getProduct(int orderId) {
        JSONObject jo = new JSONObject();
        String sqlstr = "Select * From OrderDetailProducts as odp Full Outer Join "
                + "Products as p on p.ProductID = odp.ProductID Where OrderID= ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlstr);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String productId = rs.getString("odp.ProductID");
                String productName = rs.getString("ProductName");
                Integer Qty = rs.getInt("odp.Quantity");
                Integer unitprice = rs.getInt("UnitPrice");
                Float discount = rs.getFloat("Discount");
                jo.put("ProductID", productId);
                jo.put("ProductName", productName);
                jo.put("Quantity", Qty);
                jo.put("UnitPrice", unitprice);
                jo.put("Discount", discount);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("取出product購物車資料失敗");
        }
        return jo;
    }

    @Override
    public boolean deleteShoppingCart(int Id) {
        String sqlstr = "Delete From Order Where ID= ?";
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
            throw new RuntimeException("刪除Order表格失敗");
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
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String pID = rs.getString(1);
                list.add(pID);
            }
            rs.close();
            stmt.close();
            try (PreparedStatement stmt1 = conn.prepareStatement(sqlDelete);) {
                for (int i = 0; i < list.size(); i++) {
                    stmt1.setInt(1, orderId);
                    stmt1.setString(2, list.get(i));
                    stmt1.execute();
                }
                stmt1.close();

                result = true;
            }
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
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String pID = rs.getString(1);
                list.add(pID);
            }
            rs.close();
            stmt.close();

            try (PreparedStatement stmt1 = conn.prepareStatement(sqlDelete);) {
                for (int i = 0; i < list.size(); i++) {
                    stmt1.setInt(1, orderId);
                    stmt1.setString(2, list.get(i));
                    stmt1.execute();
                }
                stmt1.close();

                result = true;
            }

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
        // 若result = true 表示場地沒有被出租可以被下訂單
        boolean result = false;
        String sqlQuery = "SELECT Status FROM Order WHERE OrderID=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            for (int orderID : orderIds) {
                stmt.setInt(1, orderID);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int status = rs.getInt(1);
                if (status != 0 || status != 4) {
                    result = false;
                } else {
                    result = true;
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

    @Override
    public double getProductPrice(ProductBean pb) {
        double subtotal = pb.getQuantity() * pb.getUnitPrice() * pb.getDiscount();
        return subtotal;
    }

    // 把購物車存進order table status 從0改1
    @Override
    public boolean updateStatus(OrderBean ob) {
        String sql = " update Order set Status=? where ID=? and OrderID=?";
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
    public int queryQty(OrderDetailProductsBean odpb) {
        String sql = "select Quantity from Products where productID=? ";
        int stockQty = 0;
        try {

            PreparedStatement state = conn.prepareStatement(sql);
            state.setString(1, odpb.getProductID());
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {

                stockQty = rs.getInt("OrderID");
                rs.close();
                state.close();
                return stockQty;

            } else {
                return stockQty;
            }

        } catch (Exception e) {
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
//            state.setString(7, memo);
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
    public OrderDetailProductsBean querySameProduct(int orderId, ProductBean pb) {
        OrderDetailProductsBean odpb2 = new OrderDetailProductsBean();
        try {
            String sql = "select * from OrderDetailProducts where OrderID=? and ProductID=?";
            PreparedStatement state = conn.prepareStatement(sql);
            state.setInt(1, orderId);
            state.setString(2, pb.getProductID());
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {
                odpb2.setOrderID(orderId);
                odpb2.setProductID(rs.getString("ProductID"));
//    odpb2.setProductName(rs.getString("ProductName"));
                odpb2.setQuantity(rs.getInt("Quantity"));
//    odpb2.setUnitPrice(rs.getInt("UnitPrice"));
//             pb2.setDiscount(rs.getDouble(""));
//    odpb2.setMemo(rs.getString("Memo"));
                rs.close();
                state.close();
            } else {
            }
            odpb2.setQuantity(pb.getQuantity() + odpb2.getQuantity());
            // 如果進去else odpb2 就會是null
            return odpb2;
        } catch (Exception e) {
            System.out.println("查詢失敗");
            return odpb2;
        }
    }
}



