package com.Dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bean.VenueImageBean;
import com.Interface.IVenueImageDao;

public class VenueImageDaoImpl implements IVenueImageDao {
	Connection conn;

	public VenueImageDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public VenueImageBean getVenueImage(String ProductID) {
		VenueImageBean vib = null;
		String sql = "SELECT * FROM VenueImage WHERE ProductID=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ProductID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String productID = ProductID;
				Blob blob = rs.getBlob(2);
				String imageName = rs.getString(3);
				vib = new VenueImageBean(productID, blob, imageName);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("getVenueImage()失敗");
		}
		return vib;
	}

	@Override
	public void processInsertImage(Blob blob, String ProductID, String imageName) {
		// FileInputStream fis = new
		// FileInputStream("C:/Users/User/Downloads/wedding/wedding1.jpg");
		String sqlstr = "INSERT INTO VenueImage(ProductID, VenueImage, imageName) values(?, ?, ?) ";
		try (PreparedStatement ps = conn.prepareStatement(sqlstr);) {
			ps.setString(1, ProductID);
			ps.setBlob(2, blob);
			ps.setString(3, imageName);
			ps.executeUpdate();
			System.out.println("Insert Successful");
		} catch (SQLException e) {
			System.out.println("Insert fail");
			e.printStackTrace();
		}

	}

}
