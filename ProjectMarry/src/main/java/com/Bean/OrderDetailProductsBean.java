package com.Bean;

import java.util.Date;

public class OrderDetailProductsBean {

	private Integer OrderID;
	private String ProductID;
	private String ProductName;
	private Integer Quantity;
	private Integer UnitPrice;
	private Float Discount;
	private String Memo;
	
	public OrderDetailProductsBean(Integer OrderID, String ProductID, String ProductName,
			Integer Quantity, Integer UnitPrice, Integer Subtotal, Float Discount, Date OrderDate, 
			String Memo, Integer ShipmentStatus) {
		this.OrderID = OrderID;
		this.ProductID = ProductID;
		this.ProductName = ProductName;
		this.Quantity = Quantity;
		this.UnitPrice = UnitPrice;
		this.Discount = Discount;
		this.Memo = Memo;
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

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public Integer getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		UnitPrice = unitPrice;
	}

	public Float getDiscount() {
		return Discount;
	}

	public void setDiscount(Float discount) {
		Discount = discount;
	}

	public String getMemo() {
		return Memo;
	}

	public void setMemo(String memo) {
		Memo = memo;
	}
}
