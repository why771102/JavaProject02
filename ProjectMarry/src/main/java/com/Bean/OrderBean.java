package com.Bean;

import java.util.Date;

public class OrderBean {
	
	private Integer OrderID;
	private Integer ID;
	private Date StartDate;
	private Date EndDate;
	private String InvoiceTitle;
	private String VATnumber;
	private Integer PaymentStatus;
	private String ShippingAddress;
	private char CancelTag;
	
	public OrderBean (int OrderID, int ID, Date StartDate, Date EndDate, 
			String InvoiceTtitle, String VATnumber, int PaymentStatus, String InvoiceTitle,
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
	
	public int getOrderID() {
		return OrderID;
	}
	
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
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
	public int getPaymentStatus() {
		return PaymentStatus;
	}
	public void setPaymentStatus(int paymentStatus) {
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
