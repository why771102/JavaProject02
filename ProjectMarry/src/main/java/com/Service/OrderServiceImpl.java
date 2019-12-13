package com.Service;

import java.sql.Connection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.Bean.OrderBean;
import com.Interface.IOrderDao;
import com.Interface.OrderService;
import com.Bean.DBService;

public class OrderServiceImpl implements OrderService {
	private Connection conn;
	private IOrderDao od;
//	private DataSource ds;
	
	public OrderServiceImpl(Connection conn) {
		this.conn = conn;
	}
//	public OrderServiceImpl() {
//		try {
//			Context context = new InitialContext();
//			ds = (DataSource) context.lookup(DBService.JNDI_DB_NAME);
//			od = new OrderDaoImpl();
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
	
	public IOrderDao getOdao() {
		return od;
	}

	public void setOdao(IOrderDao od) {
		this.od = od;
	}
	
	
	@Override
	public OrderBean getOrder(int OrderID) {
		return od.getOrder(OrderID);
	}

	@Override
	public List<OrderBean> getAllOrders() {
		return od.getAllOrders();
	}

	@Override
	public List<OrderBean> getMemberOrders(String MemberID) {
		return od.getMemberOrders(MemberID);
	}

	@Override
	public void insertOrder(OrderBean ob) {
		
	}

	@Override
	public List<OrderBean> getMemberUnpaidOrders(String id) {
		return od.getMemberUnpaidOrders(id);
	}

	@Override
	public List<OrderBean> getMemberPaidOrders(String id) {
		return od.getMemberPaidOrders(id);
	}

	@Override
	public List<OrderBean> getMemberCompletedOrders(String id) {
		return od.getMemberCompletedOrders(id);
	}

	@Override
	public List<OrderBean> getMemberCancelledOrders(String id) {
		return od.getMemberCancelledOrders(id);
	}
}
