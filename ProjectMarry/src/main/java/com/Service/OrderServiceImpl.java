package com.Service;

import java.sql.Connection;
import java.util.List;

import com.Bean.OrderBean;
import com.Interface.IOrderDao;
import com.Service.OrderService;

public class OrderServiceImpl implements OrderService {
	Connection conn;
	private IOrderDao od;
	
	public OrderServiceImpl(Connection conn) {
		this.conn = conn;
	}

	public IOrderDao getOdao() {
		return od;
	}

	public void setOdao(IOrderDao od) {
		this.od = od;
	}
	
	@Override
	public OrderBean getOrder(int OrderID) {
		return od.getOrder(OrderID);
	}

	@Override
	public List<OrderBean> getAllOrders() {
		return od.getAllOrders();
	}

	@Override
	public List<OrderBean> getMemberOrders(String MemberID) {
		return od.getMemberOrders(MemberID);
	}
}
