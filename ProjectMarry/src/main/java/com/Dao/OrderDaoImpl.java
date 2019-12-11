package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import com.Bean.OrderBean;
import com.Bean.OrderDetailsBean;
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
		
		try (PreparedStatement stmt1 = 
				con.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);){
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
			if(generatedKeys.next()) {
				id = generatedKeys.getInt(1);
			}else {
				throw new RuntimeException("無法取得Orders表格主鍵");
			}
			Set<OrderDetailsBean> details = ob.getOrderDetail();
			try(PreparedStatement stmt2 = con.prepareStatement(sqlOrderDetails);){
				for(OrderDetailsBean odb : details) {
					stmt2.setInt(1, id);
					stmt2.setInt(2, odb.getProductID());
					stmt2.setString(3, odb.getProductName());
					stmt2.setInt(4, odb.getQuantity());
					stmt2.setInt(5, odb.getUnitPrice());
					stmt2.setInt(6, odb.getSubtotal());
					stmt2.setFloat(7, odb.getDiscount());
					Timestamp tsOD = new Timestamp(odb.getOrderDate().getTime());
					stmt2.setTimestamp(8,tsOD);
					stmt2.setString(9, odb.getMemo());
					stmt2
				}
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
