package org.bqj.shopping.dao;


import java.util.List;

import org.bqj.shopping.entity.OrdersDetail;

public interface OrdersDetailDAO extends BaseDAO<OrdersDetail> {
	List<OrdersDetail> findOrdersDetailByOrdersId(int OrdersId);
	OrdersDetail findOrdersDetailByForigenkey(int OrdersId,int goodsId);
}
