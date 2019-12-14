package com.Interface;

import java.sql.Connection;
import java.util.List;

import com.Bean.OrderBean;

public interface IOrderDao {
	
	public void insertOrder(OrderBean ob);
	
	public OrderBean getOrder(int orderNo);
	
	public List<OrderBean> getAllOrders();
	
	public List<OrderBean> getMemberOrders(String id);

	List<OrderBean> getMemberUnpaidOrders(String id);

	List<OrderBean> getMemberPaidOrders(String id);

	List<OrderBean> getMemberCompletedOrders(String id);

	List<OrderBean> getMemberCancelledOrders(String id);
}
