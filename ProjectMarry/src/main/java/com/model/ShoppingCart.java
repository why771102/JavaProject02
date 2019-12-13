package com.model;

import java.util.LinkedHashMap;
import java.util.Map;

import com.Bean.OrderDetailVenuesBean;
import com.Bean.ShoppingCartBean;
import com.Bean.VenueBean;

public class ShoppingCart {

	//��cart new �X�� �åB�����Ʈɦs�bShoppingCartBean�̭�
private Map<Integer, ShoppingCartBean> cart = new LinkedHashMap<>();




    public ShoppingCart() {}
//jsp ��ܭ�������k
    public Map<Integer, ShoppingCartBean> getContent(){// ${ShoppingCart.content}

          //${ShoppingCart.content}

        return cart;

    }


    

    //�[�J�ʪ����]���a�Ӥw,�ӫ~�n�t�~�g�H�H�^

    public  void addToCartV(int ProductID ,ShoppingCartBean scb) {
    	  //�ڭ�DB�w�� �y�����q10000�}�l�s���a 
           if(ProductID >= 10000) {
        	   //�O���a
        	   //�p�G�n�d���a���S���Q�w�q
        	   
        	   
        	   //�p�G�ӫ~���̨S���o�ӳ��a
        	   if(scb.getQuantity() <= 0 ) { 

                   return;

                }else {}
               //VenueBean �b orderDetil �����(���w�w�ɶ��^�٦��q������٬O����

               //return boolean   
           }else {
        	   //�O�ӫ~

               //�p�G�F��S�f

               if(scb.getQuantity() <= 0 ) { 

                  return;

               }else {}

               //�p�G�Ȥ�cart�̭��S�������~

               if(cart.get(ProductID) == null) {

                   cart.put(ProductID,scb);

                   //�p�G�� ���a��[��

               }else {

            	   ShoppingCartBean sbean = cart.get(ProductID);
                   //�[�ʪ��ƶq
//                   scb.getQuantity();
//                   //�즳���ƶq
//                   sbean.getQuantity();
                   //�[�A�@�_
            	   sbean.setQuantity(scb.getQuantity()+sbean.getQuantity());

               }

           }
    }
    
    
//    public  void addToCartV(int productID ,VenueBean vb)   {
//    	
//    }

    //�T�{�ʪ��� �󥿲��~�ƶq

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


    //�R���ʪ����ӫ~DB &session

    public int deleteItem(int ProductID) {
    	if(ProductID >= 10000) {
    		//�qDB�R��
    		return 1;
    	}else {
    		//�q�Ȯɦs��Bean�̭��R��
    		 if( cart.get(ProductID) != null) {
           	  cart.remove(ProductID); // Map������remove()��k
           	  return 1;
             }else {
            	 return 0;
             }
           
    	}


    }

    

  //�T�{�ʪ��� �ʪ����������~����

    public int getItemNumber() {

        return cart.size();

    }

  //�p���ʪ��������~�`���B

  

    

}



	
	

