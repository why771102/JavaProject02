package com.Bean;

public class VenueBean {

	private Integer VendorID;
	private Integer ProductID;
	private String VenueAddress;
	private String Hall;
	private Integer Tables;
	private Integer InOutdoor;
	private Integer LunchPrice;
	private Integer DinnerPrice;
	
	public VenueBean (Integer VendorID, Integer ProductID, String VenueAddress, String Hall,
			Integer Tables, Integer InOutdoor, Integer LunchPrice, Integer DinnerPrice) {
		this.VendorID = VendorID;
		this.ProductID= ProductID;
		this.VenueAddress = VenueAddress;
		this.Hall = Hall;
		this.Tables = Tables;
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

	public Integer getProductID() {
		return ProductID;
	}

	public void setProductID(Integer productID) {
		ProductID = productID;
	}

	public String getVenueAddress() {
		return VenueAddress;
	}

	public void setVenueAddress(String venueAddress) {
		VenueAddress = venueAddress;
	}

	public String getHall() {
		return Hall;
	}

	public void setHall(String hall) {
		Hall = hall;
	}

	public Integer getTables() {
		return Tables;
	}

	public void setTables(Integer tables) {
		Tables = tables;
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
