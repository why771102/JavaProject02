package com.Bean;

import java.util.Date;

public class ShoppingCartBean {
	private Integer ID;
	private Integer ProductID;
	private Integer Quantity;
	private Date StartDate;
	private Date EndDate;

	public ShoppingCartBean(Integer ID, Integer ProductID, Integer Quantity, Date StartDate, Date EndDate) {
        this.ID =  ID;
        this.ProductID =  ProductID;
        this.Quantity =  Quantity;
        this.StartDate =  StartDate;
        this.EndDate =  EndDate;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getProductID() {
		return ProductID;
	}

	public void setProductID(Integer productID) {
		ProductID = productID;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
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

}
