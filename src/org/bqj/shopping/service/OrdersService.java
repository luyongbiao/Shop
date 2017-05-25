package org.bqj.shopping.service;

import java.util.List;

import org.bqj.shopping.dao.OrdersDAO;
import org.bqj.shopping.dao.impl.OrdersDAOImpl;
import org.bqj.shopping.entity.Orders;

public class OrdersService {
	private OrdersDAO ordersDAO;
	
	
	public OrdersService(OrdersDAO ordersDAO) {
		super();
		this.ordersDAO = new OrdersDAOImpl();
	}

	//show orders
	public void showOrders(int customerId) {
		List<Orders> ordersList = this.ordersDAO.findOrdersByCustomerId(customerId);
	}
	
	//delete one Order
	public void deleteOneOrder(int ordersId) {
		this.ordersDAO.removeOne(ordersId);//
	}
}
