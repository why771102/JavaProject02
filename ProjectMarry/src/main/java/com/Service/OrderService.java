package com.Service;

import java.util.List;

import com.Bean.OrderBean;

public interface OrderService {

	public OrderBean getOrder(int OrderID);

	List<OrderBean> getMemberUnpaidOrders(String id);

	List<OrderBean> getMemberPaidOrders(String id);

	List<OrderBean> getMemberCompletedOrders(String id);

	List<OrderBean> getMemberCancelledOrders(String id);
	
	public boolean updateStatus(OrderBean ob);

	public List<OrderBean> getAllOrders(int id,int Status);
}
