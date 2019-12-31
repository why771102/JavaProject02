package com.Service;

import java.sql.Blob;
import java.sql.Connection;

import com.Bean.VenueImageBean;
import com.Dao.VenueImageDaoImpl;
import com.Interface.IVenueImageDao;

public class VenueImageServiceImpl implements VenueImageService {
	private IVenueImageDao dao;
	private Connection conn;
	
	
	public VenueImageServiceImpl(Connection conn) {
		this.conn = conn;
		dao = new VenueImageDaoImpl(conn);
	}
	
	@Override
	public VenueImageBean getVenueImage(String ProductID) {
		return dao.getVenueImage(ProductID);
	}

	@Override
	public void processInsertImage(Blob blob, String ProductID, String imageName) {
		dao.processInsertImage(blob, ProductID, imageName);
		
	}

}
