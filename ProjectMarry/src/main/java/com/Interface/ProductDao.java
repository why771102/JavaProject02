package com.Interface;

import java.util.List;

import com.Bean.ProductBean;

public interface ProductDao {

	public List<ProductBean> showProductList();

	public ProductBean ProductDetail(ProductBean pb);

}