package com.Bean;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class OrderBean {
	
	private Integer OrderID;
	private Integer ID;
//	private String InvoiceTitle;
	private String VATnumber;
	private Integer Status;
	private String ShippingAddress;
	private Date OrderDate;
	private Integer ShippingStatus;
	Set<OrderDetailVenuesBean> orderDetailVenue = new LinkedHashSet<>();
	Set<OrderDetailProductsBean> orderDetailProduct = new LinkedHashSet<>();

	public Set<OrderDetailVenuesBean> getOrderDetailVenue() {
		return orderDetailVenue;
	}

	public void setOrderDetailVenue(Set<OrderDetailVenuesBean> orderDetailVenue) {
		this.orderDetailVenue = orderDetailVenue;
	}

	public Set<OrderDetailProductsBean> getOrderDetailProduct() {
		return orderDetailProduct;
	}

	public void setOrderDetailProduct(Set<OrderDetailProductsBean> orderDetailProduct) {
		this.orderDetailProduct = orderDetailProduct;
	}

	public OrderBean() {
		
	}
	
	public OrderBean(Integer OrderID, Integer ID, String VATnumber, Integer Status,
			String ShippingAddress, Date OrderDate, Integer ShippingStatus) {
		this.OrderID = OrderID;
		this.ID = ID;
//		this.InvoiceTitle = InvoiceTitle;
		this.VATnumber = VATnumber;
		this.Status = Status;
		this.ShippingAddress = ShippingAddress;
		this.OrderDate = OrderDate;
		this.ShippingStatus = ShippingStatus;
	}
	
	public Integer getOrderID() {
		return OrderID;
	}

	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

//	public String getInvoiceTitle() {
//		return InvoiceTitle;
//	}
//
//	public void setInvoiceTitle(String invoiceTitle) {
//		InvoiceTitle = invoiceTitle;
//	}

	public String getVATnumber() {
		return VATnumber;
	}

	public void setVATnumber(String vATnumber) {
		VATnumber = vATnumber;
	}

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	public String getShippingAddress() {
		return ShippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		ShippingAddress = shippingAddress;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public Integer getShippingStatus() {
		return ShippingStatus;
	}

	public void setShippingStatus(Integer shippingStatus) {
		ShippingStatus = shippingStatus;
	}

		
}
