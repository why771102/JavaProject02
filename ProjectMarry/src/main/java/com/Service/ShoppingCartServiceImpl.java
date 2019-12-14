package com.Service;

import java.util.List;

import com.Bean.OrderBean;
import com.Bean.OrderDetailProductsBean;
import com.Bean.OrderDetailVenuesBean;
import com.Bean.ProductBean;
import com.Interface.ShoppingCartDao;

public class ShoppingCartServiceImpl implements ShoppingCartService {

	private ShoppingCartDao scdao;
	
	@Override
	public int getShoppingCart(int Id) {
		// TODO Auto-generated method stub
		return scdao.getShoppingCart(Id);
	}

	@Override
	public OrderDetailVenuesBean getVenue(int orderId) {
		// TODO Auto-generated method stub
		return scdao.getVenue(orderId);
	}

	@Override
	public boolean deleteShoppingCart(int Id) {
		// TODO Auto-generated method stub
		return scdao.deleteShoppingCart(Id);
	}

	@Override
	public boolean deleteVendor(int orderId, int vendorID) {
		// TODO Auto-generated method stub
		return scdao.deleteVendor(orderId, vendorID);
	}

	@Override
	public boolean deleteVenue(int orderId, String productID) {
		// TODO Auto-generated method stub
		return  scdao.deleteVenue(orderId, productID);
	}

	@Override
	public boolean deleteSupplier(int orderId, int supplierID) {
		// TODO Auto-generated method stub
		return scdao.deleteSupplier(orderId, supplierID);
	}

	@Override
	public boolean deleteProduct(int orderId, String productID) {
		// TODO Auto-generated method stub
		return scdao.deleteProduct(orderId, productID);
	}

	@Override
	public List<Integer> querytime_orderID(String productID, int time, String date) {
		// TODO Auto-generated method stub
		return scdao.querytime_orderID(productID, time, date);
	}

	@Override
	public boolean querytime_VenueStatus(List<Integer> orderIds) {
		// TODO Auto-generated method stub
		return scdao.querytime_VenueStatus(orderIds);
	}

	@Override
	public int getVenuePrice(int orderId, String productId) {
		// TODO Auto-generated method stub
		return scdao.getVenuePrice(orderId, productId);
	}

	@Override
	public double getProductPrice(ProductBean pb) {
		// TODO Auto-generated method stub
		return scdao.getProductPrice(pb);
	}

	@Override
	public boolean updateStatus(OrderBean ob) {
		// TODO Auto-generated method stub
		return scdao.updateStatus(ob);
	}

	@Override
	public boolean updateQty(OrderDetailProductsBean odpb) {
		// TODO Auto-generated method stub
		return scdao.updateQty(odpb);
	}

	@Override
	public boolean updateTable(OrderDetailVenuesBean odvb) {
		// TODO Auto-generated method stub
		return scdao.updateTable(odvb);
	}

	@Override
	public int queryQty(OrderDetailProductsBean odpb) {
		// TODO Auto-generated method stub
		return scdao.queryQty(odpb);
	}

	@Override
	public boolean saveVenue(int orderId, OrderDetailVenuesBean odvb) {
		// TODO Auto-generated method stub
		return scdao.saveVenue(orderId, odvb);
	}

	@Override
	public boolean saveProduct(int orderId, OrderDetailProductsBean pb) {
		// TODO Auto-generated method stub
		return scdao.saveProduct(orderId, pb);
	}

	@Override
	public boolean saveShoppingCart(OrderBean ob) {
		// TODO Auto-generated method stub
		return scdao.saveShoppingCart(ob);
	}

	@Override
	public OrderDetailProductsBean querySameProduct(int orderId, ProductBean pb) {
		// TODO Auto-generated method stub
		return scdao.querySameProduct(orderId, pb);
	}

	@Override
	public JSONObject getProduct(int orderId) {
		// TODO Auto-generated method stub
		return scdao.getProduct(orderId);
	}

}
