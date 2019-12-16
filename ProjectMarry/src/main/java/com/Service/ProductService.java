package com.Service;

import java.util.List;

import com.Bean.ProductBean;

public interface ProductService {

	public List<ProductBean> showProductList();

	public ProductBean ProductDetail(ProductBean pb);
	
	
	
	
}
