package org.bqj.shopping.dao;


import java.util.List;

import org.bqj.shopping.entity.OrdersDetail;

public interface OrdersDetailDAO extends BaseDAO<OrdersDetail> {
	//find OrdersDetail by OrdersId and then we find the customer who ordered this order.
	public List<OrdersDetail> findOrdersDetailByOrdersId(int ordersid);
}
