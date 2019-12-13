package com.Interface;

import com.Bean.ProductBean;

public interface IOrderDetailsDao {

	//取得場地總價錢
	public int getVenueTotal(int orderId, int productId);
	public double getProductTotal(ProductBean pb);
}
