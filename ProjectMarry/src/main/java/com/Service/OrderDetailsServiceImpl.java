package com.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bean.ProductBean;

public class OrderDetailsServiceImpl implements OrderDetailsService {
	
	Connection conn;

	public OrderDetailsServiceImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	// 計算每項產品的總價(數量*單價*折扣)
		// 場地
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
						ps.setInt(1, productId);
						ResultSet rs1 = ps.executeQuery();
						if (rs.next()) {
							price = rs.getInt("LunchPrice");
						}
					} else {
						String sqlstr1 = "SELECT DinnerPrice FROM Venue WHERE ProductId= ?";
						PreparedStatement ps1 = conn.prepareStatement(sqlstr1);
						ps.setInt(1, productId);
						ResultSet rs1 = ps.executeQuery();
						if (rs.next()) {
							price = rs.getInt("DinnerPrice");
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("取得場地startTime錯誤");
			}
			return price;
		}

		// 產品 OrderDetailProducts
		public double getProductTotal(ProductBean pb) {
			double subtotal = pb.getQuantity() * pb.getUnitPrice() * pb.getDiscount();
			return subtotal;
		}
		
	}
