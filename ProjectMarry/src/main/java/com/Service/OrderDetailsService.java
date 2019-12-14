package com.Service;

import com.Bean.ProductBean;

public interface OrderDetailsService {
	//取得場地總價錢
	public int getVenueTotal(int orderId, int productId);
	//取得產品總價錢
	public double getProductTotal(ProductBean pb);
}
