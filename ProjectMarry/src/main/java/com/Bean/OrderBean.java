package com.Bean;

import java.util.Date;

public class OrderBean {
	
	private int OrderID;
	private int ID;
	private Date StartDate;
	private Date EndDate;
	private String InvoiceTitle;
	private String VATnumber;
	private int PaymentStatus;
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
	
	
}
