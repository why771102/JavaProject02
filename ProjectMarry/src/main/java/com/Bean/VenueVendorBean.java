package com.Bean;

public class VenueVendorBean {
	private Integer VendorID;
	private String Vendor;
	private Integer Stars;
	
	public VenueVendorBean() {
		
	}
	
	public VenueVendorBean(Integer VendorID, String Vendor, Integer Stars) {
		this.VendorID = VendorID;
		this.Vendor = Vendor;
		this.Stars = Stars;
	}
	
	public Integer getVendorID() {
		return VendorID;
	}
	public void setVendorID(Integer vendorID) {
		VendorID = vendorID;
	}
	public String getVendor() {
		return Vendor;
	}
	public void setVendor(String vendor) {
		Vendor = vendor;
	}
	public Integer getStars() {
		return Stars;
	}
	public void setStars(Integer stars) {
		Stars = stars;
	}
	
	
}
