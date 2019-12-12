package com.Dao;

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
	private DataSource ds;
	
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
	public void setConnection(Connection conn) {
		this.conn = conn;
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
}
