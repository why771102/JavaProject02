package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bean.ProductBean;
import com.Interface.ProductDao;

public class ProductDaoImpl implements ProductDao {
	
	Connection conn;
	
	public ProductDaoImpl(Connection conn) {
		this.conn = conn;
	}


	@Override
	public List<ProductBean> showProductList() {
		
		String sql = "select * from Products";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<ProductBean> pbl = new ArrayList<ProductBean>();
			
			if(rs.next()) {
				if(rs.getInt("productStatus") == 1) {
					ProductBean pb = new ProductBean();
					pb.setProductID(rs.getString("ProductID"));
					pb.setProductName(rs.getString("ProductName"));
					pb.setUnitPrice(rs.getInt("UnitPrice"));
					pb.setPSupplierID(rs.getInt("PSupplierID"));
					pb.setQuantity(rs.getInt("Quantity"));
					pb.setProductStatus(rs.getInt("ProductStatus"));
					pb.setDiscount(rs.getDouble("Discount"));
					pbl.add(pb);
				}
			}
			return pbl;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return null;
		
	}
	
	
	@Override
	public ProductBean ProductDetail(ProductBean pb) {
		
		String sql = "select * from Products where ProductID = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, pb.getProductID());
			ResultSet rs = stmt.executeQuery();
			ProductBean npb = null;
			if(rs.next()) {
				npb = new ProductBean();
				npb.setProductID(rs.getString("ProductID"));
				npb.setProductName(rs.getString("ProductName"));
				npb.setUnitPrice(rs.getInt("UnitPrice"));
				npb.setPSupplierID(rs.getInt("PSupplierID"));
				npb.setQuantity(rs.getInt("Quantity"));
				npb.setProductStatus(rs.getInt("ProductStatus"));
				npb.setDiscount(rs.getDouble("Discount"));
			}
			
			return npb;			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
	

}
