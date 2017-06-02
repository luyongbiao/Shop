package org.bqj.shopping.dao;


import java.util.List;

import org.bqj.shopping.entity.Orders;

public interface OrdersDAO extends BaseDAO<Orders> {
	List<Orders> findOrdersByCustomerId(int customerId);
	int findOrdersByCreateTime(String createTime,int customerId);
}
