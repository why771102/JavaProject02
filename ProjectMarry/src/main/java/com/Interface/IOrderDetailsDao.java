package com.Interface;

import java.sql.Connection;
import com.Bean.OrderDetailVenuesBean;

public interface IOrderDetailsDao {
	
	public void setConnection(Connection conn);
	Double getOrderSubtotal(OrderDetailVenuesBean odb);

}
