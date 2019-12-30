package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Bean.OrderBean;
import com.Interface.IOrderDao;

public class OrderDaoImpl implements IOrderDao {
	Connection conn;
	
	public OrderDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	// 把購物車存進orders table status 從0改1
    @Override
    public boolean updateStatus(OrderBean ob) { // 會員下訂單????
        String sql = " update Orders set Status=1, OrderDate=? where ID=? and OrderID=?";
        try {
            PreparedStatement state = conn.prepareStatement(sql);
            java.util.Date date=new java.util.Date();  
            
            state.setLong(1, date);
            state.setInt(2, ob.getID());
            state.setInt(3, ob.getOrderID());
            state.execute();
            state.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public OrderBean getOrder(int OrderID) {
		OrderBean ob = new OrderBean();
		String sql = "SELECT * FROM Orders where OrderID=?";
		try (PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setInt(1, OrderID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ob.setOrderID(rs.getInt("OrderID"));
				ob.setID(rs.getInt("ID"));
//				ob.setInvoiceTitle(rs.getString("InvoiceTitle"));
				ob.setVATnumber(rs.getString("VATnumber"));
				ob.setStatus(rs.getInt("Status"));
				ob.setShippingAddress(rs.getString("ShippingAddress"));
				ob.setOrderDate(rs.getDate("OrderDate"));
				ob.setShippingStatus(rs.getInt("ShippingStatus"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ob;
	}

	public List<OrderBean> getMemberUnpaidOrders(String id) {
		List<OrderBean> list = new ArrayList<OrderBean>();
		List<Integer> orders = new ArrayList<Integer>();
		String sql = "SELECT OrderID FROM Orders where ID=?, Status=? Order by OrderDate desc";
		try (PreparedStatement ps = conn.prepareStatement(sql);	) {
			ps.setString(1, id);
			ps.setInt(2, 1);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					orders.add(rs.getInt(1));
				}
			}
			ps.close();
			for(int i = 0; i < orders.size(); i++) {
				list.add(this.getOrder(orders.get(i)));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}

	@Override
	public List<OrderBean> getMemberPaidOrders(String id) {
		List<OrderBean> list = new ArrayList<OrderBean>();
		List<Integer> orders = new ArrayList<Integer>();
		String sql = "SELECT OrderID FROM Orders where ID=?, Status=? Order by OrderDate desc";
		try (PreparedStatement ps = conn.prepareStatement(sql);	) {
			ps.setString(1, id);
			ps.setInt(2, 2);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					orders.add(rs.getInt(1));
				}
			}
			ps.close();
			for(int i = 0; i < orders.size(); i++) {
				list.add(this.getOrder(orders.get(i)));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}

	@Override
	public List<OrderBean> getMemberCompletedOrders(String id) {
		List<OrderBean> list = new ArrayList<OrderBean>();
		List<Integer> orders = new ArrayList<Integer>();
		String sql = "SELECT OrderID FROM Orders where ID=?, Status=? Order by OrderDate desc";
		try (PreparedStatement ps = conn.prepareStatement(sql);	) {
			ps.setString(1, id);
			ps.setInt(2, 3);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					orders.add(rs.getInt(1));
				}
			}
			ps.close();
			for(int i = 0; i < orders.size(); i++) {
				list.add(this.getOrder(orders.get(i)));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}

	@Override
	public List<OrderBean> getMemberCancelledOrders(String id) {
		List<OrderBean> list = new ArrayList<OrderBean>();
		List<Integer> orders = new ArrayList<Integer>();
		String sql = "SELECT OrderID FROM Orders where ID=?, Status=? Order by OrderDate desc";
		try (PreparedStatement ps = conn.prepareStatement(sql);	) {
			ps.setString(1, id);
			ps.setInt(2, 4);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					orders.add(rs.getInt(1));
				}
			}
			ps.close();
			for(int i = 0; i < orders.size(); i++) {
				list.add(this.getOrder(orders.get(i)));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}

	
}
