package com.Bean;

import java.sql.Blob;

public class VenueImageBean {
	private String ProductID;
	private Blob VenueImage;
	private String imageName;
	
	public VenueImageBean() {
		
	}
	
	public VenueImageBean(String ProductID, Blob VenueImage, String imageName) {
		this.ProductID = ProductID;
		this.VenueImage = VenueImage;
		this.imageName = imageName;
	}
	
	public String getProductID() {
		return ProductID;
	}
	public void setProductID(String productID) {
		ProductID = productID;
	}
	public Blob getVenueImage() {
		return VenueImage;
	}
	public void setVenueImage(Blob venueImage) {
		VenueImage = venueImage;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
}
