package com.Bean;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class OrderBean {
	
	private Integer OrderID;
	private Integer ID;
	private String InvoiceTitle;
	private String VATnumber;
	private String Status;
	private String ShippingAddress;
	private Date OrderDate;
	private Integer ShippingStatus;
	Set<OrderDetailVenuesBean> orderDetail = new LinkedHashSet<>();
	
	public Set<OrderDetailVenuesBean> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(Set<OrderDetailVenuesBean> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public OrderBean(Integer OrderID, Integer ID, String InvoiceTitle, String VATnumber, String Status,
			String ShippingAddress, Date OrderDate, Integer ShippingStatus) {
		this.OrderID = OrderID;
		this.ID = ID;
		this.InvoiceTitle = InvoiceTitle;
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

	public String getInvoiceTitle() {
		return InvoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		InvoiceTitle = invoiceTitle;
	}

	public String getVATnumber() {
		return VATnumber;
	}

	public void setVATnumber(String vATnumber) {
		VATnumber = vATnumber;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
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
