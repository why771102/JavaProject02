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
	//�p��C�����~���`��(�ƶq*���*�馩)
	public Double getOrderSubtotal(OrderDetailVenuesBean odb) {
		double subtotal = odb.getQuantity() * odb.getUnitPrice() * odb.getDiscount();
		return subtotal;
	}
}
