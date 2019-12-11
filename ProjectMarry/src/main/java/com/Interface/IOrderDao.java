package com.Interface;

import java.sql.Connection;
import java.util.List;

import com.Bean.OrderBean;

public interface IOrderDao {
	
	public void insertOrder(OrderBean ob);
	
	public void setConnection(Connection con);
	
	public OrderBean getOrder(int orderNo);
	
	public List<OrderBean> getAllOrders();
	
	public List<OrderBean> getMemberOrders(String id);
}
