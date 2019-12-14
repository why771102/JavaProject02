package com.Interface;

import java.util.List;

import org.json.JSONObject;

import com.Bean.OrderBean;
import com.Bean.OrderDetailProductsBean;
import com.Bean.OrderDetailVenuesBean;
import com.Bean.ProductBean;

public interface ShoppingCartDao {
	// 查詢此member 在order table裡面status = 0 是否有東西 返回orderID
	public int getShoppingCart(int Id);

	// 如果有東西在DB 把shoppingCart table 全部撈出
	public OrderDetailVenuesBean getVenue(int orderId);

	public JSONObject getProduct(int orderId);

	// 全數刪除order table裡面的資料 (記得要先刪掉fk)
	public boolean deleteShoppingCart(int Id);

	// 刪除venue table裡面的資料 (記得要先刪掉fk)
	public boolean deleteVendor(int orderId, int vendorID);

	public boolean deleteVenue(int orderId, String productID);

	// 刪除product table裡面的資料 (記得要先刪掉fk)
	public boolean deleteSupplier(int orderId, int supplierID);

	public boolean deleteProduct(int orderId, String productID);

	// 要在 venue detail table查場地有沒有被預訂(取出時間比對)
	public List<Integer> querytime_orderID(String productID, int time, String date);

	// 要在 order table查場地有沒有被預訂(取出時間比對)找status 為 1 or 2
	public boolean querytime_VenueStatus(List<Integer> orderIds);

	// 找出venue 場地單價 放進查詢裡面 因為要判斷買的時間是上午場還是下午場,所以必須購買給時間讓他判斷要取哪個值
	public int getVenuePrice(int orderId, String productId);

	// 找出純粹婚禮小物的價格
	public double getProductPrice(ProductBean pb);

	// 把購物車存進order table status 從0改1
	public boolean updateStatus(OrderBean ob);

	// 按了購買後 如果有數量的更改
	public boolean updateQty(OrderDetailProductsBean odpb);

	public boolean updateTable(OrderDetailVenuesBean odvb);

	// 查詢庫存(假設庫存都沒了 delete購物車商品)
	public int queryQty(OrderDetailProductsBean odpb);
	// 查詢庫存(假設庫存 少於購買數量 update購物車數量)

	// 存場地
	public boolean saveVenue(int orderId, OrderDetailVenuesBean odvb);

	// 存商品
	public boolean saveProduct(int orderId, OrderDetailProductsBean pb);

	public boolean saveShoppingCart(OrderBean ob);

	public OrderDetailProductsBean querySameProduct(int orderId, ProductBean pb);

	// 抓DB照片
//	public Blob queryImage(String productId);
}
