package com.Bean;

import java.util.Date;

public class OrderDetailVenuesBean {

	private Integer OrderID;
	private String ProductID;
	private Integer StartTime;
	private String Date;
	private Integer TableCount;
	
	
	
	public OrderDetailVenuesBean(Integer OrderID, String ProductID,
			Integer StartTime, String Date, Integer TableCount) {
		this.OrderID = OrderID;
		this.ProductID = ProductID;
		this.StartTime = StartTime;
		this.Date = Date;
		this.TableCount = TableCount;
		
	}

	public Integer getOrderID() {
		return OrderID;
	}

	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}

	public String getProductID() {
		return ProductID;
	}

	public void setProductID(String productID) {
		ProductID = productID;
	}

	public Integer getStartTime() {
		return StartTime;
	}

	public void setStartTime(Integer startTime) {
		StartTime = startTime;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public Integer getTableCount() {
		return TableCount;
	}

	public void setTableCount(Integer tableCount) {
		TableCount = tableCount;
	}

	
}
