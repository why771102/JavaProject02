package com.Service;

import com.Bean.ProductBean;

public interface OrderDetailsService {
	//���o���a�`����
	public int getVenueTotal(int orderId, int productId);
	//���o���~�`����
	public double getProductTotal(ProductBean pb);
}
