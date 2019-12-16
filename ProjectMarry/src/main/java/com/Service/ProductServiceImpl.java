package com.Service;

import java.sql.Connection;
import java.util.List;

import com.Bean.ProductBean;
import com.Dao.ProductDaoImpl;
import com.Interface.ProductDao;

public class ProductServiceImpl implements ProductService {

	private ProductDao po;
	Connection conn;
	
	public ProductServiceImpl(Connection conn) {
		po = new ProductDaoImpl(conn);
		this.conn = conn;
	}

	@Override
	public List<ProductBean> showProductList() {
		
		return po.showProductList();
	}

	@Override
	public ProductBean ProductDetail(ProductBean pb) {
		
		return po.ProductDetail(pb);
	}

}
