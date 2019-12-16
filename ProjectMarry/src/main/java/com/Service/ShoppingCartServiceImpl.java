package com.Service;

import java.sql.Connection;
import java.util.List;

import org.json.JSONArray;

import com.Bean.OrderBean;
import com.Bean.OrderDetailProductsBean;
import com.Bean.OrderDetailVenuesBean;
import com.Bean.ProductBean;
import com.Dao.ShoppingCartDaoImpl;
import com.Interface.ShoppingCartDao;

public class ShoppingCartServiceImpl implements ShoppingCartService {

	private ShoppingCartDao scdao;
	Connection conn;
	
	public ShoppingCartServiceImpl(Connection conn) {
		this.conn = conn;
		scdao = new ShoppingCartDaoImpl(conn);
	}
	
	@Override
	public int getShoppingCart(int Id) {
		// TODO Auto-generated method stub
		return scdao.getShoppingCart(Id);
	}

	@Override
	public JSONArray showVenue(int orderId) {
		// TODO Auto-generated method stub
		return scdao.showVenue(orderId);
	}
	
	@Override
	public JSONArray showProduct(int orderId) {
		// TODO Auto-generated method stub
		return scdao.showProduct(orderId);
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

//	@Override
//	public double getProductPrice(ProductBean pb) {
//		// TODO Auto-generated method stub
//		return scdao.getProductPrice(pb);
//	}

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
	public int queryQty(String productId) {
		// TODO Auto-generated method stub
		return scdao.queryQty(productId);
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
	public List<OrderDetailVenuesBean> getVenue(int orderId) {
		// TODO Auto-generated method stub
		return  scdao.getVenue(orderId);
	}

	@Override
	public List<OrderDetailProductsBean> getProduct(int orderId) {
		// TODO Auto-generated method stub
		return scdao.getProduct(orderId);
	}

	@Override
	public OrderDetailProductsBean querySameProduct(int orderId, OrderDetailProductsBean odpb) {
		// TODO Auto-generated method stub
		return scdao.querySameProduct(orderId, odpb);
	}

	@Override
	public OrderDetailVenuesBean querySameVenue(int orderId, OrderDetailVenuesBean odvb) {
		// TODO Auto-generated method stub
		return scdao.querySameVenue(orderId, odvb);
	}

}
