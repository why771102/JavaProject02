package com.editor;

public class JavaBean {
	private static final long serialVersionUID = 1L;
	private String vendorid;
	private String productid;
	private String location;
	private String hall;
	private String tablecount;
	private String inoutdoor;
	private String lunchprice;
	private String dinnerprice;
	private String venuedesc;
	
	public String getTablecount() {
		return tablecount;
	}
	public void setTablecount(String tablecount) {
		this.tablecount = tablecount;
	}
	
	
	public String getVenuedesc() {
		return venuedesc;
	}
	public void setVenuedesc(String venuedesc) {
		this.venuedesc = venuedesc;
	}
	public String getVenuestatus() {
		return venuestatus;
	}
	public void setVenuestatus(String venuestatus) {
		this.venuestatus = venuestatus;
	}
	private String venuestatus;
	
	
	public String getVendorid() {
		return vendorid;
	}
	public void setVendorid(String vendorid) {
		this.vendorid = vendorid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
	}

	public String getInoutdoor() {
		return inoutdoor;
	}
	public void setInoutdoor(String inoutdoor) {
		this.inoutdoor = inoutdoor;
	}
	public String getLunchprice() {
		return lunchprice;
	}
	public void setLunchprice(String lunchprice) {
		this.lunchprice = lunchprice;
	}
	public String getDinnerprice() {
		return dinnerprice;
	}
	public void setDinnerprice(String dinnerprice) {
		this.dinnerprice = dinnerprice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}