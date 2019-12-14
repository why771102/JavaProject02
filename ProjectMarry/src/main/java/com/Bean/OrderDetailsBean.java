package com.Bean;

import java.sql.Blob;
import java.util.Date;

public class OrderDetailsBean {

	private int OrderID;
	private int ProductID;
	private String ProductName;
	private int Quantity;
	private int UnitPrice;
	private int Subtotal;
	private float Discount;
	private Date OrderDate;
	private Date ShippingDate;
	private char CancelTag;
	private String Memo;
	private int ProductStatus;
	private Blob VenueImage;
	
	public OrderDetailsBean() {
		
	}
	
	public OrderDetailsBean(int OrderID, int ProductID, String ProductName,
			int Quantity, int UnitPrice, int Subtotal, float Discount, Date OrderDate, 
			Date ShippingDate,char CancelTag, String Memo, int ProductStatus) {
		this.OrderID = OrderID;
		this.ProductID = ProductID;
		this.ProductName = ProductName;
		this.Quantity = Quantity;
		this.UnitPrice = UnitPrice;
		this.Subtotal = Subtotal;
		this.Discount = Discount;
		this.OrderDate = OrderDate;
		this.ShippingDate = ShippingDate;
		this.CancelTag = CancelTag;
		this.Memo = Memo;
		this.ProductStatus = ProductStatus;
		this.VenueImage = VenueImage;
	}
	
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		UnitPrice = unitPrice;
	}
	public int getSubtotal() {
		return Subtotal;
	}
	public void setSubtotal(int subtotal) {
		Subtotal = subtotal;
	}
	public float getDiscount() {
		return Discount;
	}
	public void setDiscount(float discount) {
		Discount = discount;
	}
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public Date getShippingDate() {
		return ShippingDate;
	}
	public void setShippingDate(Date shippingDate) {
		ShippingDate = shippingDate;
	}
	public char getCancelTag() {
		return CancelTag;
	}
	public void setCancelTag(char cancelTag) {
		CancelTag = cancelTag;
	}
	public String getMemo() {
		return Memo;
	}
	public void setMemo(String memo) {
		Memo = memo;
	}
	public int getProductStatus() {
		return ProductStatus;
	}
	public void setProductStatus(int productStatus) {
		ProductStatus = productStatus;
	}

	public Blob getVenueImage() {
		return VenueImage;
	}

	public void setVenueImage(Blob venueImage) {
		VenueImage = venueImage;
	}
	
	
}
