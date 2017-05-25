package org.bqj.shopping.dao;


import java.util.List;

import org.bqj.shopping.entity.Orders;

public interface OrdersDAO extends BaseDAO<Orders> {
	//find  Orders by customerId and then we can find the OrdersDetail
	public List<Orders> findOrdersByCustomerId(int customerId);
}
