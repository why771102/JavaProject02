package com.Interface;

import com.Bean.ProductBean;

public interface IOrderDetailsDao {
	//���o���a�`����
	public int getVenueTotal(int orderId, int productId);
	//���o���~�`����
	public double getProductTotal(ProductBean pb);
}
