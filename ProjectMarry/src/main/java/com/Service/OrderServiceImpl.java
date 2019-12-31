package com.Service;

import java.sql.Connection;
import java.util.List;

import com.Bean.OrderBean;
import com.Dao.OrderDaoImpl;
import com.Interface.IOrderDao;

public class OrderServiceImpl implements OrderService {
	Connection conn;
	private IOrderDao od;

	
	public OrderServiceImpl(Connection conn) {
		this.conn = conn;
		od = new OrderDaoImpl(conn);
	}

	@Override
	public OrderBean getOrder(int OrderID, int Status) {
		return od.getOrder(OrderID, Status);
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

	@Override
	public boolean updateStatus(OrderBean ob) {
		// TODO Auto-generated method stub
		return od.updateStatus(ob);
	}

}
