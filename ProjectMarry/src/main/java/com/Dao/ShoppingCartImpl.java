package com.Dao;

import com.Bean.ShoppingCartBean;
import com.Interface.ShoppingCartDao;

public class ShoppingCartImpl implements ShoppingCartDao {

	@Override
	public ShoppingCartBean getSCItem(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteShoppingCart(int Id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean querytime(int ProductID, String time) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int productPrice(int ProductID, String time) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int productPrice(int ProductID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean saveShoppingCart(ShoppingCartBean scb) {
		// TODO Auto-generated method stub
		return false;
	}

}
