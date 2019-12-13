package com.Bean;

public class ProductBean {
	private String ProductID;
	private String ProductName;
	private Integer UnitPrice;
	private Integer PSupplierID;
	private Integer Quantity;
	private Integer ProductStatus;
	
	public ProductBean(String ProductID, String ProductName, Integer UnitPrice,
			Integer PSupplierID, Integer Quantity, Integer ProductStatus) {
		this.ProductID = ProductID;
		this.ProductName = ProductName;
		this.UnitPrice = UnitPrice;
		this.PSupplierID = PSupplierID;
		this.Quantity = Quantity;
		this.ProductStatus = ProductStatus;
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
	public Integer getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		UnitPrice = unitPrice;
	}
	public Integer getPSupplierID() {
		return PSupplierID;
	}
	public void setPSupplierID(Integer pSupplierID) {
		PSupplierID = pSupplierID;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	public Integer getProductStatus() {
		return ProductStatus;
	}
	public void setProductStatus(Integer productStatus) {
		ProductStatus = productStatus;
	}
	
	
}
