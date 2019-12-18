package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bean.ProductBean;
import com.Bean.VenueBean;
import com.Interface.IVenueDao;

public class VenueDaoImpl implements IVenueDao {
	
	Connection conn;
	
	public VenueDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<VenueBean> showVenueList() {
		String sqlstmt = "Select * from Venue";
		try {
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			ResultSet rs = stmt.executeQuery();
			List<VenueBean> vb1 = new ArrayList<VenueBean>();
			while(rs.next()) {
				VenueBean vb = new VenueBean();
				vb.setVendorID(rs.getInt("VendorID"));
				vb.setProductID(rs.getString("ProductID"));
				vb.setLocation(rs.getString("Location"));
				vb.setHall(rs.getString("Hall"));
				vb.setTableCount(rs.getInt("TableCount"));
				vb.setInOutdoor(rs.getInt("InOutdoor"));
				vb.setLunchPrice(rs.getInt("LunchPrice"));
				vb.setDinnerPrice(rs.getInt("DinnerPrice"));
				vb.setVenueDesc(rs.getString("VenueDesc"));
				vb1.add(vb);
			}
			return vb1;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public VenueBean VenueDetail(VenueBean vb) {
		
		String sql = "select * from Venue where ProductID = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, vb.getProductID());
			ResultSet rs = stmt.executeQuery();
			VenueBean nvb = null;
			if(rs.next()) {
				nvb = new VenueBean();
				nvb.setProductID(rs.getString("ProductID"));
				nvb.setVendorID(rs.getInt("VendorID"));
				nvb.setLocation(rs.getString("Location"));
				nvb.setHall(rs.getString("Hall"));
				nvb.setTableCount(rs.getInt("TableCount"));
				nvb.setInOutdoor(rs.getInt("InOutdoor"));
				nvb.setLunchPrice(rs.getInt("LunchPrice"));
				nvb.setDinnerPrice(rs.getInt("DinnerPrice"));
				nvb.setVenueDesc(rs.getString("VenueDesc"));
			}
			
			return nvb;			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String VenueName(VenueBean vb) {
		String sqlstmt2 = "Select * from VenueVendor where VendorID = ? ";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sqlstmt2);
			stmt.setInt(1, vb.getVendorID());
			ResultSet rs = stmt.executeQuery();
			String item = null;
			if(rs.next()) {
				item = rs.getString("Vendor") ;
			}
			return item;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
