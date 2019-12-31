package com.Interface;

import java.util.List;

import org.json.JSONArray;

import com.Bean.OrderBean;

public interface IOrderDao {
	
	public OrderBean getOrder(int OrderID);

	public List<OrderBean> getAllOrders(int id,int Status);

	public List<OrderBean> getMemberPaidOrders(String id);

	public List<OrderBean> getMemberCompletedOrders(String id);

	public List<OrderBean> getMemberCancelledOrders(String id);

	boolean updateStatus(OrderBean ob);

	JSONArray showProductDetail(int orderId);
}
