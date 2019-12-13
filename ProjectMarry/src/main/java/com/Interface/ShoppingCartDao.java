package com.Interface;

import java.sql.Blob;

import com.Bean.ProductBean;
import com.Bean.VenueBean;

public interface ShoppingCartDao {
//	//查詢此member 在order table裡面status = 0 是否有東西 返回orderID
	public int  getShoppingCart(int Id);
	//如果有東西在DB 把shoppingCart table 全部撈出
	public VenueBean getVenue(int orderId);
	public ProductBean getProduct(int orderId);
	//全數刪除order table裡面的資料 (記得要先刪掉fk)
	public boolean  deleteShoppingCart(int Id);
	//刪除venue table裡面的資料 (記得要先刪掉fk)
	public boolean  deleteVendor(int orderId , int vendorID);
	public boolean  deleteVenue(int orderId , int venueID );
	//刪除product table裡面的資料 (記得要先刪掉fk)
	public boolean  deleteSupplier(int orderId ,int supplierID);
	public boolean  deleteProduct(int orderId ,int productID);


    //要在 venue detail table查場地有沒有被預訂(取出時間比對)
	public int[]  querytime_orderID(int venueID  , int time ,String date);
	//要在 order table查場地有沒有被預訂(取出時間比對)找status 為 1 or 2
	public boolean  querytime_(int[] orderId);
	
	//找出venue 場地單價  放進查詢裡面  因為要判斷買的時間是上午場還是下午場,所以必須購買給時間讓他判斷要取哪個值
	public int venuePrice(int venueID, int time);
	//找出純粹婚禮小物的價格
	public int productPrice(int ProductID);
	//把購物車存進order table   status 從0改1
	public boolean updateStatus(int ID, int orderId);
	//按了購買後  如果有數量的更改
	public boolean updateQty(int orderId,int productId);
	public boolean updateTable(int orderId,int venueId);
	//查詢庫存(假設庫存都沒了 delete購物車商品)
	public int queryQty(int productId,int quantity);
	//查詢庫存(假設庫存 少於購買數量 update購物車數量)
	
	//存場地
	public boolean saveVenue(VenueBean vb);
	//存商品
	public boolean saveProduct(ProductBean pb);
	
	//抓DB照片
	public Blob queryImage(int productId);
}
