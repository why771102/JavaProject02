package com.Service;

import java.sql.Blob;

import com.Bean.VenueImageBean;

public interface VenueImageService {
	
	public VenueImageBean getVenueImage(String ProductID);
	
	public void processInsertImage(Blob blob, String ProductID, String imageName);
}
