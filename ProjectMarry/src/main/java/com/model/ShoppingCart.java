package com.model;

import java.util.LinkedHashMap;
import java.util.Map;

import com.Bean.OrderDetailVenuesBean;
import com.Bean.ShoppingCartBean;
import com.Bean.VenueBean;

public class ShoppingCart {

	//把cart new 出來 並且先把資料時存在ShoppingCartBean裡面
private Map<Integer, ShoppingCartBean> cart = new LinkedHashMap<>();




    public ShoppingCart() {}
//jsp 顯示頁面的方法
    public Map<Integer, ShoppingCartBean> getContent(){// ${ShoppingCart.content}

          //${ShoppingCart.content}

        return cart;

    }


    

    //加入購物車（場地而已,商品要另外寫？？）

    public  void addToCartV(int ProductID ,ShoppingCartBean scb) {
    	  //我們DB定的 流水號從10000開始存場地 
           if(ProductID >= 10000) {
        	   //是場地
        	   //如果要查場地有沒有被預訂
        	   
        	   
        	   //如果商品車裡沒有這個場地
        	   if(scb.getQuantity() <= 0 ) { 

                   return;

                }else {}
               //VenueBean 在 orderDetil 撈資料(比對預定時間）還有訂單取消還是成立

               //return boolean   
           }else {
        	   //是商品

               //如果東西沒貨

               if(scb.getQuantity() <= 0 ) { 

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

    //確認購物車 更正產品數量

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


    //刪除購物車商品DB &session

    public int deleteItem(int ProductID) {
    	if(ProductID >= 10000) {
    		//從DB刪除
    		return 1;
    	}else {
    		//從暫時存放Bean裡面刪除
    		 if( cart.get(ProductID) != null) {
           	  cart.remove(ProductID); // Map介面的remove()方法
           	  return 1;
             }else {
            	 return 0;
             }
           
    	}


    }

    

  //確認購物車 購物車內的物品種類

    public int getItemNumber() {

        return cart.size();

    }

  //計算購物車內物品總金額

  

    

}



	
	

