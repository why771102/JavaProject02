package com.Interface;

import java.sql.Connection;
import com.Bean.OrderDetailsBean;

public interface IOrderDetailsDao {
	
	public void setConnection(Connection conn);
	Double getOrderSubtotal(OrderDetailsBean odb);

}
