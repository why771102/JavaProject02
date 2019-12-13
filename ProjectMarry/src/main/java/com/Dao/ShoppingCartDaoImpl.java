package com.Dao;

import com.Bean.VenueBean;
import com.Interface.ProductBean;
import com.Interface.ShoppingCartDao;

public class ShoppingCartDaoImpl implements ShoppingCartDao {

	@Override
	public int getShoppingCart(int Id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VenueBean getVenue(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteShoppingCart(int Id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteVendor(int orderId, int vendorID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteVenue(int orderId, int venueID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteShop(int orderId, int ShopID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(int orderId, int productID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] querytime_orderID(int venueID, int time, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean querytime_(int[] orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int productPrice(int venueID, int time) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int productPrice(int ProductID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateStatus(int ID, int orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateQty(int orderId, int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTable(int orderId, int venueId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int queryQty(int productId, int quantity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean saveVenue(VenueBean vb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductBean getProduct(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveProduct(ProductBean pb) {
		// TODO Auto-generated method stub
		return false;
	}

}
