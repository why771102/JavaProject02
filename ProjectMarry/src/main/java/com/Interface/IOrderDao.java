package com.Interface;

import java.util.List;

import com.Bean.OrderBean;

public interface IOrderDao {
	
	OrderBean getOrder(int OrderID);

	List<OrderBean> getMemberUnpaidOrders(String id);

	List<OrderBean> getMemberPaidOrders(String id);

	List<OrderBean> getMemberCompletedOrders(String id);

	List<OrderBean> getMemberCancelledOrders(String id);
}
