package com.Service;

import java.util.Set;

<<<<<<< HEAD:ProjectMarry/src/main/java/com/model/ShoppingCart.java
import com.Bean.OrderDetailVenuesBean;
=======
>>>>>>> bfdd051b71b73d72388376a9e55ecba98c4db778:ProjectMarry/src/main/java/com/Service/ShoppingCartServiceImpl.java
import com.Bean.ShoppingCartBean;
import com.Dao.ShoppingCartImpl;

public class ShoppingCartServiceImpl {
	//��ư��D??? setQuantity
	
	//���[�J�ʪ��� �N�n�sDB
	//���U�h��N�n�P�_�ʪ���DB�O�_���o�Ӱӫ~
	//�p�G�S���N�Oinsert
	//��update
	//���U�e�e�h�Ndelete
	//���i�ʪ������P�_�ʪ������P�_���S�����a �����a �N�horder table �� ���S���Q�q��
	
	
	
	//�p�ק�ӫ~�ƶq �O�T�w�I�ګ�    �F��s�iorderDetail �b�R���ʪ���DB 
	

	//���P�_DB���S����member��shoppingCart
	//�p�G�� �N�q�漴�X ��i�s��LinkedHaschMap
	
    // ��i�s��LinkedHaschMap �N�R��DB�̭����ª��ʪ���
	
/*	
//	//�p�GDB�̭��S�� shopping cart ��cart new �X�� �åB�����Ʈɦs�bShoppingCartBean�̭�
//private Map<Integer, ShoppingCartBean> cart = new LinkedHashMap<>();




    public ShoppingCartServiceImpl() {}
//jsp ��ܭ�������k
    public Map<Integer, ShoppingCartBean> getContent(){// ${ShoppingCart.content}

          //${ShoppingCart.content}

        return cart;

    }
  */

    

    //�[�J�ʪ����]�^

    public  void addToCart( ShoppingCartBean scb) {
      int	 ProductID =  scb.getProductID();
    	  //�ڭ�DB�w�� �y�����q10000�}�l�s���a 
    	//�p�G�ʶR���ӫ~�O���a
           if(ProductID >= 10000) {
        	   //�O���a
        	   //�p�G�n�d���a���S���Q�w�q
        	   ShoppingCartImpl sci = new ShoppingCartImpl(); 
        	   boolean aa = sci.querytime(ProductID, scb.getStartDate().toString());
        //�d�ߦۤv�ʪ����O�_���ۦP���a
               
        	   
        	 //�p�G�ʶR���ӫ~�O�B§�p��	   
           }else {
        	   //�O�ӫ~

               //�ˬd�w�s

               if(true) { 

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

    // �I�i�ʪ�����  �󥿲��~�ƶq
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


    //�R���ʪ����ӫ~    Map������remove()��k

    public int deleteItem(int ProductID) {
    
    		//�q�Ȯɦs��Bean�̭��R��
    		 if( cart.get(ProductID) != null) {
           	  cart.remove(ProductID); // Map������remove()��k
           	  return 1;
             }else {
            	 return 0;
             }
           
    	


    }
    
  //�T�{�ʪ��� �ʪ����������~����
    public int getItemNumber() {

        return cart.size();

    }

  //�p���ʪ��������~�`���B
    public double getSubtotal(){
		double subTotal = 0 ;
		Set<Integer> set = cart.keySet();
		for(int n : set){
			ShoppingCartBean scb = cart.get(n);
			int  id =scb.getProductID();
			//��X���~���  ��i�d�߸̭�
			//
			double price    = scb.getUnitPrice();
			double discount = scb.getDiscount();
			int qty      = scb.getQuantity();
			
			subTotal +=  price * discount * qty;
		}
		return subTotal;
	}
  

    

}



	
	

