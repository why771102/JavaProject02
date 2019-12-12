package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import com.Bean.OrderBean;
import com.Bean.OrderDetailsBean;
import com.Interface.IOrderDao;

public class OrderDaoImpl implements IOrderDao {
	private String memberId = null;
	private Connection con;
	int orderNo = 0;

	@Override
	public void insertOrder(OrderBean ob) {
		String sqlOrder = "Insert Into Order" + "(ID, StartDate, EndDate, InvoiceTitle, "
				+ "VATnumber, ShippingAddress) values(?, ?, ?, ?, ?, ?)";
		String sqlOrderDetails = "Insert Into OrderDetails" + "(OrderID, ProductID, ProductName, Quantity, "
				+ "UnitPrice, SubTotal, Discount, OrderDate, Memo, "
				+ "ShipmentStatus) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		ResultSet generatedKeys = null;

		try (PreparedStatement stmt1 = con.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);) {
			stmt1.setInt(1, ob.getID());
			Timestamp tsSD = new Timestamp(ob.getStartDate().getTime());
			stmt1.setTimestamp(2, tsSD);
			Timestamp tsED = new Timestamp(ob.getEndDate().getTime());
			stmt1.setTimestamp(3, tsED);
			stmt1.setString(4, ob.getInvoiceTitle());
			stmt1.setString(5, ob.getVATnumber());
			stmt1.setString(6, ob.getShippingAddress());
			stmt1.executeUpdate();
			int id = 0;
			generatedKeys = stmt1.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
			} else {
				throw new RuntimeException("無法取得Orders表格主鍵");
			}
			Set<OrderDetailsBean> details = ob.getOrderDetail();
			try (PreparedStatement stmt2 = con.prepareStatement(sqlOrderDetails);) {
				for (OrderDetailsBean odb : details) {
					stmt2.setInt(1, id);
					stmt2.setInt(2, odb.getProductID());
					stmt2.setString(3, odb.getProductName());
					stmt2.setInt(4, odb.getQuantity());
					stmt2.setInt(5, odb.getUnitPrice());
					stmt2.setInt(6, odb.getSubtotal());
					stmt2.setFloat(7, odb.getDiscount());
					Timestamp tsOD = new Timestamp(odb.getOrderDate().getTime());
					stmt2.setTimestamp(8, tsOD);
					stmt2.setString(9, odb.getMemo());
					stmt2.setInt(10, odb.getShipmentStatus());
					stmt2.executeUpdate();
					stmt2.clearParameters();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("#insertOrder()發生SQL例外:  " + e.getMessage());
		}

	}

	@Override
	public void setConnection(Connection con) {
		this.con = con;
	}

	@Override
	public OrderBean getOrder(int orderId) {
		OrderBean ob = null;
		DataSource ds = null;
		Set<OrderDetailsBean> set = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=ProjectMarry";
			con = DriverManager.getConnection(connUrl, "sa", "P@ssword");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("getOrder()發生錯誤 無法連資料庫");
		}

		String sql = "SELECT * FROM Order WHERE OrderId=?";
		String sql1 = "SELECT * FROM OrderDetails WHERE OrderId = ?";
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				PreparedStatement ps1 = con.prepareStatement(sql1);) {
			ps.setInt(1, orderId);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					Integer oid = rs.getInt("orderID");
					Integer id = rs.getInt("ID");
					Date StartDate = rs.getDate("StartDate");
					Date EndDate = rs.getDate("EndDate");
					String InvoiceTitle = rs.getString("InvoiceTitle");
					String VATnumber = rs.getString("VATnumber");
					String PaymentStatus = rs.getString("PaymentStatus");
					String ShippingAddress = rs.getString("ShippingAddress");
					ob = new OrderBean(oid, id, StartDate, EndDate, InvoiceTitle, VATnumber, PaymentStatus,
							ShippingAddress, null);
				}
			}
			ps1.setInt(1, orderId);
			try (ResultSet rs = ps1.executeQuery();) {
				set = new HashSet<>();
				while (rs.next()) {
					int orderId2 = rs.getInt("OrderID");
					int productID = rs.getInt("ProductID");
					String productName = rs.getString("ProductName");
					int quantity = rs.getInt("Quantity");
					int unitPrice = rs.getInt("UnitPrice");
					int subtotal = rs.getInt("Subtotal");
					float discount = rs.getInt("Discount");
					String memo = rs.getString("Memo");
					OrderDetailsBean odb = new OrderDetailsBean(orderId2, productID, productName, quantity, unitPrice,
							subtotal, discount, null, memo, null);
					set.add(odb);
				}
				ob.setOrderDetail(set);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("OrderDaoImpl類別的getOrder()發生錯誤");
		}
		return ob;
	}

	public String getmemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public List<OrderBean> getAllOrders() {
		DataSource ds = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=ProjectMarry";
			con = DriverManager.getConnection(connUrl, "sa", "P@ssword");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("getAllOrders()發生錯誤 無法連資料庫");
		}
		List<OrderBean> list = new ArrayList<OrderBean>();
		String sql = "SELECT OrderID FROM Order";
		try (
			Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		) {
			while(rs.next()) {
				Integer no = rs.getInt(1);
				list.add(getOrder(no));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public List<OrderBean> getMemberOrders(String id) {
		DataSource ds = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=ProjectMarry";
			con = DriverManager.getConnection(connUrl, "sa", "P@ssword");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("getMemberOrders()發生錯誤 無法連資料庫");
		}
		List<OrderBean> list = new ArrayList<OrderBean>();
		String sql = "SELECT OrderNo FROM Order where ID=? Order by orderDate desc";
		try (
			Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
				){
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();){
				while(rs.next()) {
					Integer no = rs.getInt(1);
					list.add(getOrder(no));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

}
