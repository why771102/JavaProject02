package com.Interface;

import java.util.List;

import com.Bean.OrderBean;

public interface IOrderDao {
	
	public OrderBean getOrder(int OrderID, int Status);

	public List<OrderBean> getMemberUnpaidOrders(String id);

	public List<OrderBean> getMemberPaidOrders(String id);

	public List<OrderBean> getMemberCompletedOrders(String id);

	public List<OrderBean> getMemberCancelledOrders(String id);

	boolean updateStatus(OrderBean ob);
}
