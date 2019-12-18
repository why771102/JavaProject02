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
					eb.setLocation( rs.getString("location"));
					eb.setHall( rs.getString("hall"));
					eb.setTablecount( rs.getString("tablecount"));
					eb.setInoutdoor( rs.getString("inoutdoor"));
					eb.setLunchprice( rs.getString("lunchprice"));
					eb.setDinnerprice( rs.getString("dinnerprice"));
					eb.setVenuedesc( rs.getString("venuedesc"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return eb;
		
	
	}
	
	public JavaBean addVenue(String productid,String vendorid,String location,String hall,String tablecount,String inoutdoor,String lunchprice,String dinnerprice
			,String venuestatus,String venuedesc) {
		
		String qryStmt = "Insert into Venue(productid,vendorid,location,hall,tablecount,inoutdoor,lunchprice,dinnerprice,venuestatus,venuedesc) Values(?,?,?,?,?,?,?,?,?,?)";
		JavaBean eb=new com.editor.JavaBean();
		try {	
				PreparedStatement stmt = conn.prepareStatement(qryStmt);
				stmt.setString(1,vendorid);
				stmt.setString(2, productid);
				stmt.setString(3, location);
				stmt.setString(4, hall);
				stmt.setString(5, tablecount);
				stmt.setString(6, inoutdoor);
				stmt.setString(7, lunchprice);
				stmt.setString(8, dinnerprice);
				stmt.setString(9, venuestatus);
				stmt.setString(10, venuedesc);
				
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

	
	
	
	public JavaBean updateVenue(String vendorid,String productid,String location,String hall,String tablecount,String inoutdoor,String lunchprice,String dinnerprice
			,String venuestatus,String venuedesc) {
		String qryStmt = "Update Venue Set vendorid=?,productid=?,location=?,hall=?,tablecount=?,inoutdoor=?,lunchprice=?,dinnerprice=? ,venuedesc=? where productid=?";
		JavaBean eb=new com.editor.JavaBean();
		try {
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			
			stmt.setString(1, vendorid);
			stmt.setString(2, productid);
			stmt.setString(3, location);
			stmt.setString(4, hall);
			stmt.setString(5, tablecount);
			stmt.setString(6, inoutdoor);
			stmt.setString(7, lunchprice);
			stmt.setString(8, dinnerprice);
			stmt.setString(9, venuedesc);
			stmt.setString(10, productid);
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
		String qryStmt = "Update Venue Set venuestatus=0 where productid=?";
//		String qryStmt = "Delete From Venue where productid=?";
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
			String qryStmt = "SELECT* FROM Venue where venuestatus=1";
//			String qryStmt = "SELECT* FROM Venue where =?;
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
		
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				JavaBean eb=new com.editor.JavaBean();
				eb.setVendorid( rs.getString("vendorid"));
				eb.setProductid( rs.getString("productid"));
				eb.setLocation( rs.getString("location"));
				eb.setHall( rs.getString("hall"));
				eb.setTablecount( rs.getString("tablecount"));
				eb.setInoutdoor( rs.getString("inoutdoor"));
				eb.setLunchprice( rs.getString("lunchprice"));
				eb.setDinnerprice( rs.getString("dinnerprice"));
				eb.setVenuedesc( rs.getString("venuedesc"));
				vens.add(eb);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vens;
	}


	



	
	
	
	
}
