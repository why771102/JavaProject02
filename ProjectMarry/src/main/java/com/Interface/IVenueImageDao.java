package com.Interface;

import java.sql.Blob;

import com.Bean.VenueImageBean;

public interface IVenueImageDao {
	
	public VenueImageBean getVenueImage(String ProductID);
	
	public void processInsertImage(Blob blob, String ProductID, String imageName);
	
}
