package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bean.ProductBean;
import com.Interface.IOrderDetailsDao;

public class OrderDetailsDaoImpl implements IOrderDetailsDao {

	Connection conn;

	public OrderDetailsDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	// �p��C�����~���`��(�ƶq*���*�馩)
	// ���a
	public int getVenueTotal(int orderId, int productId) {
		int price = 0; //Interger price = null;
		// OrderDetailVenues DB
		String sqlstr = "SELECT StartTime FROM OrderDetailVenues WHERE OrderId= ? and ProductId= ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sqlstr);
			ps.setInt(1, orderId);
			ps.setInt(2, productId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Integer startTime = rs.getInt("StartTime");
				if (startTime == 0) {
					// Venue DB
					String sqlstr1 = "SELECT LunchPrice FROM Venue WHERE ProductId= ?";
					PreparedStatement ps1 = conn.prepareStatement(sqlstr1);
					ps1.setInt(1, productId);
					ResultSet rs1 = ps.executeQuery();
					if (rs1.next()) {
						price = rs1.getInt("LunchPrice");
					}
					rs1.close();
					ps1.close();
				} else {
					String sqlstr1 = "SELECT DinnerPrice FROM Venue WHERE ProductId= ?";
					PreparedStatement ps1 = conn.prepareStatement(sqlstr1);
					ps1.setInt(1, productId);
					ResultSet rs1 = ps.executeQuery();
					if (rs1.next()) {
						price = rs1.getInt("DinnerPrice");
					}
					rs1.close();
					ps1.close();
				}
				rs.close();
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���o���astartTime���~");
		}
		
		return price;
	}

	// ���~ OrderDetailProducts
	public double getProductTotal(ProductBean pb) {
		double subtotal = pb.getQuantity() * pb.getUnitPrice() * pb.getDiscount();
		return subtotal;
	}
	
}
