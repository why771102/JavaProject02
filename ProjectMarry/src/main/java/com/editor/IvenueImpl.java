package com.editor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;

import com.editor.JavaBean;

public class IvenueImpl implements Ivenue {
	private static final long serialVersionUID = 1L;
	private DataSource ds = null;
	private Connection conn = null;
	
	{init();}
	public void init() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=GetMarry";
			conn = DriverManager.getConnection(connUrl, "sa", "P@ssw0rd");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public JavaBean queryVenue(String productid) {
		String qryStmt = "SELECT* FROM Venue where productid=?";
		JavaBean eb=new com.editor.JavaBean();
			try {
				PreparedStatement stmt = conn.prepareStatement(qryStmt);
			
				stmt.setString(1, productid);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					
					eb.setVendorid( rs.getString("vendorid"));
					eb.setProductid( rs.getString("productid"));
					eb.setVenueaddress( rs.getString("venueaddress"));
					eb.setHall( rs.getString("hall"));
					eb.setTables( rs.getString("tables"));
					eb.setInoutdoor( rs.getString("inoutdoor"));
					eb.setLunchprice( rs.getString("lunchprice"));
					eb.setDinnerprice( rs.getString("dinnerprice"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return eb;
		
	
	}
	
	public JavaBean addVenue(String vendorid,String venueaddress,String hall,String tables,String inoutdoor,String lunchprice,String dinnerprice) {
		String qryStmt = "Insert into Venue(vendorid,venueaddress,hall,tables,inoutdoor,lunchprice,dinnerprice) Values(?,?,?,?,?,?,?)";
		JavaBean eb=new com.editor.JavaBean();
		try {	
				PreparedStatement stmt = conn.prepareStatement(qryStmt);
				stmt.setString(1, vendorid);
				
				stmt.setString(2, venueaddress);
				stmt.setString(3, hall);
				stmt.setString(4, tables);
				stmt.setString(5, inoutdoor);
				stmt.setString(6, lunchprice);
				stmt.setString(7, dinnerprice);
				stmt.executeUpdate();
			
//				ResultSet rs = stmt.executeQuery();
//				while (rs.next()) {
//					
//					eb.setVendorid( rs.getString("vendorid"));
//					eb.setProductid( rs.getString("productid"));
//					eb.setVenueaddress( rs.getString("venueaddress"));
//					eb.setHall( rs.getString("hall"));
//					eb.setTables( rs.getString("tables"));
//					eb.setInoutdoor( rs.getString("inoutdoor"));
//					eb.setLunchprice( rs.getString("lunchprice"));
//					eb.setDinnerprice( rs.getString("dinnerprice"));
//				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return eb;
		
	
	}

	
	
	public JavaBean updateVenue(String vendorid,String productid,String venueaddress,String hall,String tables,String inoutdoor,String lunchprice,String dinnerprice) {
		String qryStmt = "Update Venue Set vendorid=?,venueaddress=?,hall=?,tables=?,inoutdoor=?,lunchprice=?,dinnerprice=? where productid=?";
		JavaBean eb=new com.editor.JavaBean();
		try {
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, vendorid);
			stmt.setString(2, venueaddress);
			
			stmt.setString(3, hall);
			stmt.setString(4, tables);
			stmt.setString(5, inoutdoor);
			stmt.setString(6, lunchprice);
			stmt.setString(7, dinnerprice);
			stmt.setString(8, productid);
			stmt.executeUpdate();
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				
//				eb.setVendorid( rs.getString("vendorid"));
//				eb.setProductid( rs.getString("productid"));
//				eb.setVenueaddress( rs.getString("venueaddress"));
//				eb.setHall( rs.getString("hall"));
//				eb.setTables( rs.getString("tables"));
//				eb.setInoutdoor( rs.getString("inoutdoor"));
//				eb.setLunchprice( rs.getString("lunchprice"));
//				eb.setDinnerprice( rs.getString("dinnerprice"));
//				
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eb;
	}
	
	public JavaBean deleteVenue(String productid){
		String qryStmt = "Delete From Venue where productid=?";
		JavaBean eb=new com.editor.JavaBean();
		try {
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, productid);
			stmt.executeUpdate();
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				eb.setVendorid( rs.getString("vendorid"));
//				eb.setProductid( rs.getString("productid"));
//				eb.setVenueaddress( rs.getString("venueaddress"));
//				eb.setHall( rs.getString("hall"));
//				eb.setTables( rs.getString("tables"));
//				eb.setInoutdoor( rs.getString("inoutdoor"));
//				eb.setLunchprice( rs.getString("lunchprice"));
//				eb.setDinnerprice( rs.getString("dinnerprice"));
//						
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eb;
	}
	
	public List<JavaBean> queryallVenue(){
		List<JavaBean> vens=new ArrayList<>();
		try {
			String qryStmt = "SELECT* FROM Venue";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				JavaBean eb=new com.editor.JavaBean();
				eb.setVendorid( rs.getString("vendorid"));
				eb.setProductid( rs.getString("productid"));
				eb.setVenueaddress( rs.getString("venueaddress"));
				eb.setHall( rs.getString("hall"));
				eb.setTables( rs.getString("tables"));
				eb.setInoutdoor( rs.getString("inoutdoor"));
				eb.setLunchprice( rs.getString("lunchprice"));
				eb.setDinnerprice( rs.getString("dinnerprice"));
				vens.add(eb);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vens;
	}



	
	
	
	
}
