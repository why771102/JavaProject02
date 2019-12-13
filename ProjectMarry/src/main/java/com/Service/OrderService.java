package com.Service;

import java.util.List;

import com.Bean.OrderBean;

public interface OrderService {

public void insertOrder(OrderBean ob);
	
	public OrderBean getOrder(int orderNo);

	
	public List<OrderBean> getAllOrders();
	
	public List<OrderBean> getMemberOrders(String id);

	List<OrderBean> getMemberUnpaidOrders(String id);

	List<OrderBean> getMemberPaidOrders(String id);

	List<OrderBean> getMemberCompletedOrders(String id);

	List<OrderBean> getMemberCancelledOrders(String id);
}
