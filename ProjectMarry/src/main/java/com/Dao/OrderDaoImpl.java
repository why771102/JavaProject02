package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import com.Bean.OrderBean;
import com.Interface.IOrderDao;

public class OrderDaoImpl implements IOrderDao{
	private Connection con;
	int orderNo = 0;
	@Override
	public void insertOrder(OrderBean ob) {
		String sqlOrder = "Insert Into Order"
				+ "(ID, StartDate, EndDate, InvoiceTitle, "
				+ "VATnumber, ShippingAddress) values(?, ?, ?, ?, ?, ?)";
		String sqlOrderDetails = "Insert Into OrderDetails"
				+ "(OrderID, ProductID, ProductName, Quantity, "
				+ "UnitPrice, SubTotal, Discount, OrderDate, Memo, "
				+ "ShipmentStatus) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		ResultSet generatedKeys = null;
		
		try {
			PreparedStatement stmt = 
					con.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, ob.getID());
			Timestamp tsSD = new Timestamp(ob.getStartDate().getTime());
			stmt.setTimestamp(2, tsSD);
			Timestamp tsED = new Timestamp(ob.getEndDate().getTime());
			stmt.setTimestamp(3, tsED);
			stmt.setString(4, ob.getInvoiceTitle());
			stmt.setString(5, ob.getVATnumber());
			stmt.setString(6, ob.getShippingAddress());
			stmt.executeUpdate();
			int id = 0;
			generatedKeys = stmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				id = generatedKeys.getInt(1);
			}else {
				throw new RuntimeException("無法取得Orders表格主鍵");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
	}

	@Override
	public OrderBean getOrder(int orderNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderBean> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderBean> getMemberOrders(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
