package com.Service;

import java.util.Set;

<<<<<<< HEAD:ProjectMarry/src/main/java/com/model/ShoppingCart.java
import com.Bean.OrderDetailVenuesBean;
=======
>>>>>>> bfdd051b71b73d72388376a9e55ecba98c4db778:ProjectMarry/src/main/java/com/Service/ShoppingCartServiceImpl.java
import com.Bean.ShoppingCartBean;
import com.Dao.ShoppingCartImpl;

public class ShoppingCartServiceImpl {
	//桌數問題??? setQuantity
	
	//按加入購物車 就要存DB
	//按下去後就要判斷購物車DB是否有這個商品
	//如果沒有就是insert
	//有update
	//按下叉叉去就delete
	//按進購物車先判斷購物車先判斷有沒有場地 有場地 就去order table 找 有沒有被訂走
	
	
	
	//如修改商品數量 是確定付款後    東西存進orderDetail 在刪除購物車DB 
	

	//先判斷DB有沒有此member的shoppingCart
	//如果有 將訂單撈出 放進新的LinkedHaschMap
	
    // 放進新的LinkedHaschMap 就刪除DB裡面的舊的購物車
	
/*	
//	//如果DB裡面沒有 shopping cart 把cart new 出來 並且先把資料時存在ShoppingCartBean裡面
//private Map<Integer, ShoppingCartBean> cart = new LinkedHashMap<>();




    public ShoppingCartServiceImpl() {}
//jsp 顯示頁面的方法
    public Map<Integer, ShoppingCartBean> getContent(){// ${ShoppingCart.content}

          //${ShoppingCart.content}

        return cart;

    }
  */

    

    //加入購物車（）

    public  void addToCart( ShoppingCartBean scb) {
      int	 ProductID =  scb.getProductID();
    	  //我們DB定的 流水號從10000開始存場地 
    	//如果購買的商品是場地
           if(ProductID >= 10000) {
        	   //是場地
        	   //如果要查場地有沒有被預訂
        	   ShoppingCartImpl sci = new ShoppingCartImpl(); 
        	   boolean aa = sci.querytime(ProductID, scb.getStartDate().toString());
        //查詢自己購物車是否有相同場地
               
        	   
        	 //如果購買的商品是婚禮小物	   
           }else {
        	   //是商品

               //檢查庫存

               if(true) { 

                  return;

               }else {}

               //如果客戶cart裡面沒有此產品

               if(cart.get(ProductID) == null) {

                   cart.put(ProductID,scb);


                   //如果有 此地方加購
               }else {

            	   ShoppingCartBean sbean = cart.get(ProductID);
                   //加購的數量
//                   scb.getQuantity();
//                   //原有的數量
//                   sbean.getQuantity();
                   //加再一起
            	   sbean.setQuantity(scb.getQuantity()+sbean.getQuantity());

               }

           }
    }
    
    
//    public  void addToCartV(int productID ,VenueBean vb)   {
//    	
//    }

    // 點進購物車後  更正產品數量
    public boolean modifyQty(int ProductID,int newQty) {
     if(ProductID <= 0) {
    	 if(cart.get(ProductID) != null) {

             ShoppingCartBean bean = cart.get(ProductID);

             bean.setQuantity(newQty);

             return true;

         }else {

             return false;

         }
     }
       
        return false;
    }


    //刪除購物車商品    Map介面的remove()方法

    public int deleteItem(int ProductID) {
    
    		//從暫時存放Bean裡面刪除
    		 if( cart.get(ProductID) != null) {
           	  cart.remove(ProductID); // Map介面的remove()方法
           	  return 1;
             }else {
            	 return 0;
             }
           
    	


    }
    
  //確認購物車 購物車內的物品種類
    public int getItemNumber() {

        return cart.size();

    }

  //計算購物車內物品總金額
    public double getSubtotal(){
		double subTotal = 0 ;
		Set<Integer> set = cart.keySet();
		for(int n : set){
			ShoppingCartBean scb = cart.get(n);
			int  id =scb.getProductID();
			//找出物品單價  放進查詢裡面
			//
			double price    = scb.getUnitPrice();
			double discount = scb.getDiscount();
			int qty      = scb.getQuantity();
			
			subTotal +=  price * discount * qty;
		}
		return subTotal;
	}
  

    

}



	
	

