package com.Service;

import java.sql.Connection;
import java.util.List;
import com.Bean.OrderBean;

public interface OrderService {

	public void setConnection(Connection conn);
	
	public OrderBean getOrder(int OrderID);

	public List<OrderBean> getAllOrders();

	public List<OrderBean> getMemberOrders(String MemberID);
	
}
