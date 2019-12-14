package com.Bean;

public class VenueBean {

	private Integer VendorID;
	private String ProductID;
	private String Location;
	private String Hall;
	private Integer TableCount;
	private Integer InOutdoor;
	private Integer LunchPrice;
	private Integer DinnerPrice;
	
	public VenueBean() {
		
	}
	
	public VenueBean (Integer VendorID, String ProductID, String Location, String Hall,
			Integer TableCount, Integer InOutdoor, Integer LunchPrice, Integer DinnerPrice) {
		this.VendorID = VendorID;
		this.ProductID= ProductID;
		this.Location = Location;
		this.Hall = Hall;
		this.TableCount = TableCount;
		this.InOutdoor = InOutdoor;
		this.LunchPrice = LunchPrice;
		this.DinnerPrice = DinnerPrice;
	}

	public Integer getVendorID() {
		return VendorID;
	}

	public void setVendorID(Integer vendorID) {
		VendorID = vendorID;
	}

	public String getProductID() {
		return ProductID;
	}

	public void setProductID(String productID) {
		ProductID = productID;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getHall() {
		return Hall;
	}

	public void setHall(String hall) {
		Hall = hall;
	}

	public Integer getTableCount() {
		return TableCount;
	}

	public void setTableCount(Integer tableCount) {
		TableCount = tableCount;
	}

	public Integer getInOutdoor() {
		return InOutdoor;
	}

	public void setInOutdoor(Integer inOutdoor) {
		InOutdoor = inOutdoor;
	}

	public Integer getLunchPrice() {
		return LunchPrice;
	}

	public void setLunchPrice(Integer lunchPrice) {
		LunchPrice = lunchPrice;
	}

	public Integer getDinnerPrice() {
		return DinnerPrice;
	}

	public void setDinnerPrice(Integer dinnerPrice) {
		DinnerPrice = dinnerPrice;
	}

	
}
