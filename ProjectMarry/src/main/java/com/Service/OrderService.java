package com.Service;

import java.util.List;
import com.Bean.OrderBean;

public interface OrderService {
	
	public OrderBean getOrder(int OrderID);

	public List<OrderBean> getAllOrders();

	public List<OrderBean> getMemberOrders(String MemberID);
	
}
