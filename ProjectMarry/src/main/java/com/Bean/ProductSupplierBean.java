package com.Bean;

public class ProductSupplierBean {
	public Integer PSupplierID;
	public String PSupplierName;
	
	public ProductSupplierBean() {
		
	}
	
	public ProductSupplierBean(Integer PSupplierID, String PSupplierName) {
		this.PSupplierID = PSupplierID;
		this.PSupplierName = PSupplierName;
	}
	
	public Integer getPSupplierID() {
		return PSupplierID;
	}
	public void setPSupplierID(Integer pSupplierID) {
		PSupplierID = pSupplierID;
	}
	public String getPSupplierName() {
		return PSupplierName;
	}
	public void setPSupplierName(String pSupplierName) {
		PSupplierName = pSupplierName;
	}
	
	
}
