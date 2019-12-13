package com.Service;

import java.sql.Connection;
import java.util.List;

import com.Bean.OrderBean;
import com.Interface.IOrderDao;
import com.Service.OrderService;

public class OrderServiceImpl implements OrderService {
	Connection conn;
	private IOrderDao od;

//	private DataSource ds;

	
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

	@Override
	public void insertOrder(OrderBean ob) {
		
	}

	@Override
	public List<OrderBean> getMemberUnpaidOrders(String id) {
		return od.getMemberUnpaidOrders(id);
	}

	@Override
	public List<OrderBean> getMemberPaidOrders(String id) {
		return od.getMemberPaidOrders(id);
	}

	@Override
	public List<OrderBean> getMemberCompletedOrders(String id) {
		return od.getMemberCompletedOrders(id);
	}

	@Override
	public List<OrderBean> getMemberCancelledOrders(String id) {
		return od.getMemberCancelledOrders(id);
	}
}
