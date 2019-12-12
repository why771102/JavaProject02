package com.Interface;

import com.Bean.ShoppingCartBean;

public interface ShoppingCartDao {
//	//查詢此member 在shoppingCart table裡面是否有東西
//	public boolean  getShoppingCart(int Id);
	//如果有東西在DB 把shoppingCart table 全部撈出
	public ShoppingCartBean getSCItem(int Id);
	//刪除購物車DB裡面的資料
	public boolean  deleteShoppingCart(int Id);
    //要在 orderdetail table查場地有沒有被預訂(取出時間比對)
	public boolean  querytime(int ProductID , String time ,String date);
	//找出venue 場地單價  放進查詢裡面  因為要判斷買的時間是上午場還是下午場,所以必須購買給時間讓他判斷要取哪個值
	public int productPrice(int ProductID, String time);
	//找出純粹婚禮小物的價格
	public int productPrice(int ProductID);
	//把購物車存進shoppingCart table
	public boolean saveShoppingCart(ShoppingCartBean scb);

}
