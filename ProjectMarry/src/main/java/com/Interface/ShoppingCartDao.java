package com.Interface;

import com.Bean.ShoppingCartBean;

public interface ShoppingCartDao {
//	//�d�ߦ�member �bshoppingCart table�̭��O�_���F��
//	public boolean  getShoppingCart(int Id);
	//�p�G���F��bDB ��shoppingCart table �������X
	public ShoppingCartBean getSCItem(int Id);
	//�R���ʪ���DB�̭������
	public boolean  deleteShoppingCart(int Id);
    //�n�b orderdetail table�d���a���S���Q�w�q(���X�ɶ����)
	public boolean  querytime(int ProductID , String time ,String date);
	//��Xvenue ���a���  ��i�d�߸̭�  �]���n�P�_�R���ɶ��O�W�ȳ��٬O�U�ȳ�,�ҥH�����ʶR���ɶ����L�P�_�n�����ӭ�
	public int productPrice(int ProductID, String time);
	//��X�º�B§�p��������
	public int productPrice(int ProductID);
	//���ʪ����s�ishoppingCart table
	public boolean saveShoppingCart(ShoppingCartBean scb);

}
