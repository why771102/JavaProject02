package com.Bean;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class OrderBean {
	
	private Integer OrderID;
	private Integer ID;
	private Date StartDate;
	private Date EndDate;
	private String InvoiceTitle;
	private String VATnumber;
	private char PaymentStatus;
	private String ShippingAddress;
	private char CancelTag;
	Set<OrderDetailsBean> orderDetail = new LinkedHashSet<>();
	
	public Set<OrderDetailsBean> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(Set<OrderDetailsBean> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public OrderBean (Integer OrderID, Integer ID, Date StartDate, Date EndDate, 
			String InvoiceTtitle, String VATnumber, char PaymentStatus, String InvoiceTitle,
			String ShippingAddress, char CancelTag) {
		this.OrderID = OrderID;
		this.ID = ID;
		this.StartDate = StartDate;
		this.EndDate = EndDate;
		this.InvoiceTitle = InvoiceTitle;
		this.VATnumber = VATnumber;
		this.PaymentStatus = PaymentStatus;
		this.ShippingAddress = ShippingAddress;
		this.CancelTag = CancelTag;
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

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
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

	public char getPaymentStatus() {
		return PaymentStatus;
	}

	public void setPaymentStatus(char paymentStatus) {
		PaymentStatus = paymentStatus;
	}

	public String getShippingAddress() {
		return ShippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		ShippingAddress = shippingAddress;
	}

	public char getCancelTag() {
		return CancelTag;
	}

	public void setCancelTag(char cancelTag) {
		CancelTag = cancelTag;
	}
	
	
}
