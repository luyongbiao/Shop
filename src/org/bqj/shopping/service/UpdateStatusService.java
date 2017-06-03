package org.bqj.shopping.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bqj.shopping.dao.OrdersDAO;
import org.bqj.shopping.dao.impl.OrdersDAOImpl;
import org.bqj.shopping.entity.Goods;
import org.bqj.shopping.entity.Orders;
import org.bqj.shopping.entity.OrdersDetail;

public class UpdateStatusService {
	private OrdersDAO ordersDAO;
	private OrdersService ordersService;
	
	public UpdateStatusService(){
		this.ordersDAO = new OrdersDAOImpl();
		this.ordersService = new OrdersService();
	}
	
	public void updateStatus(int ordersId) {
		// TODO Auto-generated method stub
		OrdersDAOImpl ordersDao = new OrdersDAOImpl();
		Orders orders = new Orders();
		orders = ordersDao.loadById(ordersId);
		orders.setOrdersStatusId(3);
		ordersDao.modify(orders);
	}
	
	
	
	public Map<Orders,Map<OrdersDetail,Goods>> findAllList(){
		 List<Orders> orders_list = this.ordersDAO.findAll();
		 Map<Orders,Map<OrdersDetail,Goods>> m = new HashMap<>(); 
		 for(Orders o : orders_list) {
			 Map<OrdersDetail,Goods> map2 = this.ordersService.OrderDetailListAllGoods(o);
			 m.put(o,map2);
		 }
		 return m;
	}
 }
