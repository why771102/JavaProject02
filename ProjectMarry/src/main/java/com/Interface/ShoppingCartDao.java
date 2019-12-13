package com.Interface;

import java.sql.Blob;

import com.Bean.ProductBean;
import com.Bean.VenueBean;

public interface ShoppingCartDao {
//	//�d�ߦ�member �border table�̭�status = 0 �O�_���F�� ��^orderID
	public int  getShoppingCart(int Id);
	//�p�G���F��bDB ��shoppingCart table �������X
	public VenueBean getVenue(int orderId);
	public ProductBean getProduct(int orderId);
	//���ƧR��order table�̭������ (�O�o�n���R��fk)
	public boolean  deleteShoppingCart(int Id);
	//�R��venue table�̭������ (�O�o�n���R��fk)
	public boolean  deleteVendor(int orderId , int vendorID);
	public boolean  deleteVenue(int orderId , int venueID );
	//�R��product table�̭������ (�O�o�n���R��fk)
	public boolean  deleteSupplier(int orderId ,int supplierID);
	public boolean  deleteProduct(int orderId ,int productID);


    //�n�b venue detail table�d���a���S���Q�w�q(���X�ɶ����)
	public int[]  querytime_orderID(int venueID  , int time ,String date);
	//�n�b order table�d���a���S���Q�w�q(���X�ɶ����)��status �� 1 or 2
	public boolean  querytime_(int[] orderId);
	
	//��Xvenue ���a���  ��i�d�߸̭�  �]���n�P�_�R���ɶ��O�W�ȳ��٬O�U�ȳ�,�ҥH�����ʶR���ɶ����L�P�_�n�����ӭ�
	public int venuePrice(int venueID, int time);
	//��X�º�B§�p��������
	public int productPrice(int ProductID);
	//���ʪ����s�iorder table   status �q0��1
	public boolean updateStatus(int ID, int orderId);
	//���F�ʶR��  �p�G���ƶq�����
	public boolean updateQty(int orderId,int productId);
	public boolean updateTable(int orderId,int venueId);
	//�d�߮w�s(���]�w�s���S�F delete�ʪ����ӫ~)
	public int queryQty(int productId,int quantity);
	//�d�߮w�s(���]�w�s �֩��ʶR�ƶq update�ʪ����ƶq)
	
	//�s���a
	public boolean saveVenue(VenueBean vb);
	//�s�ӫ~
	public boolean saveProduct(ProductBean pb);
	
	//��DB�Ӥ�
	public Blob queryImage(int productId);
}
