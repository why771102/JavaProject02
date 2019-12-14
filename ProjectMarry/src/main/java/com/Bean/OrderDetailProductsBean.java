package com.Bean;

public class OrderDetailProductsBean {

	private Integer OrderID;
	private String ProductID;
	private Integer Quantity;

	
	public OrderDetailProductsBean() {
		
	}
	
	public OrderDetailProductsBean(Integer OrderID, String ProductID, Integer Quantity) {
		this.OrderID = OrderID;
		this.ProductID = ProductID;
		this.Quantity = Quantity;
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

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}



}
