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
	
	public OrderBean getOrder(int OrderID) {
		OrderBean ob = null;
		String sql = "SELECT * FROM Orders where OrderID=?";
		try (PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setInt(1, OrderID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Integer orderID = rs.getInt("OrderID");
				Integer ID = rs.getInt("ID");
				String InvoiceTitle = rs.getString("InvoiceTitle");
				String VATnumber = rs.getString("VATnumber");
				Integer Status = rs.getInt("Status");
				String ShippingAddress = rs.getString("ShippingAddress");
				Date OrderDate = rs.getDate("OrderDate");
				Integer ShippingStatus = rs.getInt("ShippingStatus");
				ob = new OrderBean(orderID, ID, InvoiceTitle, VATnumber, Status, ShippingAddress, OrderDate, ShippingStatus);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
