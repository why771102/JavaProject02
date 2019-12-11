package com.Bean;

import java.util.Date;

public class OrderDetailsBean {

	private Integer OrderID;
	private Integer ProductID;
	private String ProductName;
	private Integer Quantity;
	private Integer UnitPrice;
	private Integer Subtotal;
	private Float Discount;
	private Date OrderDate;
	private String Memo;
	private Integer ShipmentStatus;
	
	public OrderDetailsBean(int OrderID, int ProductID, String ProductName,
			int Quantity, int UnitPrice, int Subtotal, float Discount, Date OrderDate, 
			String Memo, int ShipmentStatus) {
		this.OrderID = OrderID;
		this.ProductID = ProductID;
		this.ProductName = ProductName;
		this.Quantity = Quantity;
		this.UnitPrice = UnitPrice;
		this.Subtotal = Subtotal;
		this.Discount = Discount;
		this.OrderDate = OrderDate;
		this.Memo = Memo;
		this.ShipmentStatus = ShipmentStatus;
	}

	public Integer getOrderID() {
		return OrderID;
	}

	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}

	public Integer getProductID() {
		return ProductID;
	}

	public void setProductID(Integer productID) {
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

	public Integer getSubtotal() {
		return Subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		Subtotal = subtotal;
	}

	public Float getDiscount() {
		return Discount;
	}

	public void setDiscount(Float discount) {
		Discount = discount;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public String getMemo() {
		return Memo;
	}

	public void setMemo(String memo) {
		Memo = memo;
	}

	public Integer getShipmentStatus() {
		return ShipmentStatus;
	}

	public void setShipmentStatus(Integer shipmentStatus) {
		ShipmentStatus = shipmentStatus;
	}
	
}
