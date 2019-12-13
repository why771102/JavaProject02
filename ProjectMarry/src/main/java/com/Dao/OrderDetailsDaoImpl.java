package com.Dao;

import java.sql.Connection;

import com.Bean.OrderDetailVenuesBean;
import com.Interface.IOrderDetailsDao;

public class OrderDetailsDaoImpl implements IOrderDetailsDao {
	
	Connection conn;
	
	public OrderDetailsDaoImpl() {
	}
	
	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	@Override
	//計算每項產品的總價(數量*單價*折扣)
	public Double getOrderSubtotal(OrderDetailVenuesBean odb) {
		double subtotal = odb.getQuantity() * odb.getUnitPrice() * odb.getDiscount();
		return subtotal;
	}
}
