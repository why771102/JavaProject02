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
import com.Bean.OrderDetailProductsBean;
import com.Bean.OrderDetailVenuesBean;
import com.Interface.IOrderDao;

public class OrderDaoImpl implements IOrderDao {
	private String memberId = null;
	Connection con;
	int orderNo = 0;

	
	public OrderDaoImpl(Connection con) {
		this.con = con;
	}
	
	@Override
	public void insertOrder(OrderBean ob) {
		String sqlOrder = "Insert Into Order(ID, InvoiceTitle, VATnumber,"
				+ "Status, ShippingAddress, OrderDate, ShippingStatus) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		String sqlOrderDetailProducts = "Insert Into OrderDetailProducts("
				+ "OrderID, ProductID, ProductName, Quantity, UnitPrice,"
				+ "Discount, Memo) values(?, ?, ?, ?, ?, ?, ?)";

		String sqlOrderDetailVenues = "Insert Into OrderDetailVenues(OrderID,"
				+ "ProductID, StartTime, Date, TableCount) values(?, ?, ?, ?, ?)";
		ResultSet generatedKeys = null;

		try (PreparedStatement stmt1 = con.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);) {
			stmt1.setInt(1, ob.getID());
			stmt1.setString(2, ob.getInvoiceTitle());
			stmt1.setString(3, ob.getVATnumber());
			stmt1.setInt(4, 1);
			stmt1.setString(5, ob.getShippingAddress());
			Timestamp tsOD = new Timestamp(ob.getOrderDate().getTime());
			stmt1.setTimestamp(6, tsOD);
			stmt1.setInt(7, ob.getShippingStatus());
			stmt1.executeUpdate();
			int id = 0;
			generatedKeys = stmt1.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
			} else {
				throw new RuntimeException("�L�k���oOrders���D��");
			}
			Set<OrderDetailVenuesBean> details = ob.getOrderDetailVenue();
			try (PreparedStatement stmt2 = con.prepareStatement(sqlOrderDetailVenues);) {
				for (OrderDetailVenuesBean odvb : details) {
					stmt2.setInt(1, id);
					stmt2.setString(2, odvb.getProductID());
					stmt2.setInt(3, odvb.getStartTime());
					Timestamp tsD = new Timestamp(odvb.getDate().getTime());
					stmt2.setTimestamp(4, tsD);
					stmt2.setInt(5, odvb.getTableCount());
					stmt2.executeUpdate();
					stmt2.clearParameters();
				}
			}
			Set<OrderDetailProductsBean> details1 = ob.getOrderDetailProduct();
			try(PreparedStatement stmt3 = con.prepareStatement(sqlOrderDetailProducts);){
				for(OrderDetailProductsBean odpb : details1) {
					stmt3.setInt(1, id);
					stmt3.setString(2, odpb.getProductID());
					stmt3.setString(3, odpb.getProductName());
					stmt3.setInt(4, odpb.getQuantity());
					stmt3.setInt(5, odpb.getUnitPrice());
					stmt3.setFloat(6, odpb.getDiscount());
					stmt3.setString(7, odpb.getMemo());
					stmt3.executeUpdate();
					stmt3.clearParameters();
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("#insertOrder()�o��SQL�ҥ~:  " + e.getMessage());
		}
		

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
			throw new RuntimeException("getOrder()�o�Ϳ��~ �L�k�s��Ʈw");
		}

		Set<OrderDetailVenuesBean> set1 = null;
		Set<OrderDetailProductsBean> set2 = null;


		String sql = "SELECT * FROM Order WHERE OrderID=?";
		String sql1 = "SELECT * FROM OrderDetailVenuesBean WHERE OrderID = ?";
		String sql2 = "SELECT * FROM OrderDetailProductsBean WHERE OrderID = ?";
		try (	PreparedStatement ps = con.prepareStatement(sql);
				PreparedStatement ps1 = con.prepareStatement(sql1);
				PreparedStatement ps2 = con.prepareStatement(sql2);) {
			ps.setInt(1, orderId);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
//					Integer oid = rs.getInt("OrderID");
					Integer id = rs.getInt("ID");
					String InvoiceTitle = rs.getString("InvoiceTitle");
					String VATnumber = rs.getString("VATnumber");
					Integer Status = rs.getInt("Status");
					String ShippingAddress = rs.getString("ShippingAddress");

					ob = new OrderBean();

					Date OrderDate = rs.getDate("OrderDate");
					Integer ShippingStatus = rs.getInt("ShippingStatus");
					ob = new OrderBean(orderId, id, InvoiceTitle, VATnumber, Status,
							ShippingAddress, OrderDate, null);

				}
			}
			ps1.setInt(1, orderId);
			try (ResultSet rs = ps1.executeQuery();) {
				set1 = new HashSet<>();
				while (rs.next()) {
//					Integer orderId2 = rs.getInt("OrderID");
					String productIDV = rs.getString("ProductID");
					Integer StartTime = rs.getInt("StartTime");
					Date Date = rs.getDate("Date");
					Integer TableCount = rs.getInt("TableCount");
					OrderDetailVenuesBean odb = new OrderDetailVenuesBean(orderId, productIDV, StartTime,
							Date, TableCount);
					set1.add(odb);
				}
				ob.setOrderDetailVenue(set1);
			}
			ps2.setInt(1, orderId);
			try (ResultSet rs = ps2.executeQuery();){
				set2 = new HashSet<>();
				while(rs.next()) {
//					Integer orderId3 = rs.getInt("OrderID");
					String productIDP = rs.getString("ProductID");
					String productName = rs.getString("ProductName");
					Integer quantity = rs.getInt("Quantity");
					Integer unitPrice = rs.getInt("UnitPrice");
					Float discount = rs.getFloat("Discount");
					String memo = rs.getString("Memo");
					OrderDetailProductsBean odpb = new OrderDetailProductsBean(orderId, productIDP, 
							productName, quantity, unitPrice, discount, memo);
					set2.add(odpb);
				}
				ob.setOrderDetailProduct(set2);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("OrderDaoImpl���O��getOrder()�o�Ϳ��~");
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
			throw new RuntimeException("getAllOrders()�o�Ϳ��~ �L�k�s��Ʈw");
		}

//		DataSource ds = null;


		List<OrderBean> list = new ArrayList<OrderBean>();
		String sql = "SELECT OrderID FROM Order";
		try (
//				Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
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
			throw new RuntimeException("getMemberOrders()�o�Ϳ��~ �L�k�s��Ʈw");
		}
	}
	public List<OrderBean> getMemberUnpaidOrders(String id) {
//		DataSource ds = null;

		List<OrderBean> list = new ArrayList<OrderBean>();
		String sql = "SELECT OrderID FROM Order where ID=?, Status=? Order by orderDate desc";
		try (
//			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, id);
			ps.setInt(2, 1);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					Integer no = rs.getInt(1);
					list.add(getOrder(no));
				}
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return list;
		
	}

	@Override
	public List<OrderBean> getMemberPaidOrders(String id) {
//		DataSource ds = null;
		List<OrderBean> list = new ArrayList<OrderBean>();
		String sql = "SELECT OrderID FROM Order where ID=?, Status=? Order by orderDate desc";
		try (
//			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, id);
			ps.setInt(2, 2);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					Integer no = rs.getInt(1);
					list.add(getOrder(no));
				}
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return list;
		
	}
	@Override
	public List<OrderBean> getMemberCompletedOrders(String id) {
//		DataSource ds = null;
		List<OrderBean> list = new ArrayList<OrderBean>();
		String sql = "SELECT OrderID FROM Order where ID=?, Status=? Order by orderDate desc";
		try (
//			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, id);
			ps.setInt(2, 3);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					Integer no = rs.getInt(1);
					list.add(getOrder(no));
				}
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return list;
		
	}
	
	@Override
	public List<OrderBean> getMemberCancelledOrders(String id) {
//		DataSource ds = null;
		List<OrderBean> list = new ArrayList<OrderBean>();
		String sql = "SELECT OrderID FROM Order where ID=?, Status=? Order by orderDate desc";
		try (
//			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, id);
			ps.setInt(2, 4);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					Integer no = rs.getInt(1);
					list.add(getOrder(no));
				}
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return list;
		
	}
}
