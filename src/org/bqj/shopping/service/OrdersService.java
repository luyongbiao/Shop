package org.bqj.shopping.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bqj.shopping.dao.CartDetailDAO;
import org.bqj.shopping.dao.GoodsDAO;
import org.bqj.shopping.dao.OrdersDAO;
import org.bqj.shopping.dao.OrdersDetailDAO;
import org.bqj.shopping.dao.impl.CartDetailDAOImpl;
import org.bqj.shopping.dao.impl.GoodsDAOImpl;
import org.bqj.shopping.dao.impl.OrdersDAOImpl;
import org.bqj.shopping.dao.impl.OrdersDetailDAOImpl;
import org.bqj.shopping.entity.CartDetail;
import org.bqj.shopping.entity.Goods;
import org.bqj.shopping.entity.Orders;
import org.bqj.shopping.entity.OrdersDetail;

public class OrdersService {
	private OrdersDAO ordersDAO;
	private OrdersDetailDAO ordersDetailDAO;
	private CartDetailDAO cartDetailDAO;
	private GoodsDAO goodsDAO;
	
	public OrdersService() {
		ordersDAO = new OrdersDAOImpl();
		ordersDetailDAO = new OrdersDetailDAOImpl();
		cartDetailDAO = new CartDetailDAOImpl();
		goodsDAO = new GoodsDAOImpl();
	}
	public Orders saveOrders(int customerId,int[] cartDetaileIds/*,String ordersNote*/){
		Orders orders = new Orders();
//		orders.setOrdersNote(ordersNote);
		orders.setOrdersCreateTime(new Timestamp(new Date().getTime()));
		orders.setOrdersStatusId(1);//设置为未付款。
		orders.setCustomerId(customerId);
		this.ordersDAO.save(orders);
		/*System.out.println(orders.getOrdersCreateTime().toString().substring(0,19));*/
		int ordersId = this.ordersDAO.findOrdersByCreateTime(orders.getOrdersCreateTime().toString().substring(0,19),customerId);
		System.out.println(ordersId);
		orders.setOrdersId(ordersId);
		saveOrdersDetails(orders,cartDetaileIds);
		return orders;
	}
	
	public void saveOrdersDetails(Orders orders,int[] cartDetaileIds) {
		for (int cartDetaileId : cartDetaileIds) {
			OrdersDetail ordersDetail = new OrdersDetail();
			ordersDetail.setOrdersId(orders.getOrdersId());
			ordersDetail.setGoodsId(this.cartDetailDAO.loadById(cartDetaileId).getGoodsId());
			ordersDetail.setGoodsCount(this.cartDetailDAO.loadById(cartDetaileId).getGoodsCount());
			ordersDetail.setTotalPrice(this.cartDetailDAO.loadById(cartDetaileId).getTotalPrice());
			this.ordersDetailDAO.save(ordersDetail);
		}
	}
	public int[] transcartDetaileIdsStringtoId (String[] cartDetaileIds) {
		if (cartDetaileIds == null) {
			System.out.println("cartDetaileIds is null");
			return null;
		}
		int [] cds = new int[cartDetaileIds.length];
		for (int i = 0;i < cartDetaileIds.length;i ++) {
			cds[i] = Integer.parseInt(cartDetaileIds[i]);
		}
		return cds;
	}
	
	 public Map<CartDetail,Goods> transListAll(String[] cartDetaileIds) {
		 if (cartDetaileIds == null) {
			 System.out.println("cartDetaileIds is null");
			 return null;
		 }
		 int [] cds = new int[cartDetaileIds.length];
		 for (int i = 0;i < cartDetaileIds.length;i ++) {
			 cds[i] = Integer.parseInt(cartDetaileIds[i]);					
		 }
		 Map<CartDetail,Goods> Goods_map = new HashMap<>();
		 for(int cd : cds ){
			 CartDetail cartDetail = this.cartDetailDAO.loadById(cd);
			 Goods good = this.goodsDAO.loadById(cartDetail.getGoodsId());
			 Goods_map.put(cartDetail,good);
		 }
		 return Goods_map;
	 }
	 
	
	 public List<Orders> listOrders(int customerId) {
		 List<Orders> orders_list = this.ordersDAO.findOrdersByCustomerId(customerId);
		 return orders_list;
	 }
	 
	 public List<OrdersDetail> listOrdersDetails(Orders orders){
		 List<OrdersDetail> ordersDetail_list = this.ordersDetailDAO.findOrdersDetailByOrdersId(orders.getOrdersId());
		 return ordersDetail_list;
	 }
	 
	 public Map<OrdersDetail,Goods> OrderDetailListAllGoods(Orders orders) {
		 List<OrdersDetail> ordersDetail_list = listOrdersDetails(orders);
		 Map<OrdersDetail,Goods> Goods_map = new HashMap<>();
		 for(OrdersDetail ordersDetail : ordersDetail_list ){
			 Goods good = this.goodsDAO.loadById(ordersDetail.getGoodsId());
			 Goods_map.put(ordersDetail,good);
		 }
		 return Goods_map;
	 }
	 
	 
	 public Map<Orders,List<OrdersDetail>> listAll(int customerId) {
		 List<Orders> orders = listOrders(customerId);
		 List<OrdersDetail> ordersDetail_list = new ArrayList<>();
		 Map<Orders,List<OrdersDetail>> orders_map = new HashMap<>();
		 for(Orders order : orders) {
			 ordersDetail_list = listOrdersDetails(order);
			 orders_map.put(order,ordersDetail_list);
		 }
		/* Map<CartDetail,Goods> Goods_map = new HashMap<>();
		 for(int cd : cds ){
			 CartDetail cartDetail = this.cartDetailDAO.loadById(cd);
			 Goods good = this.goodsDAO.loadById(cartDetail.getGoodsId());
			 Goods_map.put(cartDetail,good);
		 }*/
		 return orders_map;
	 }
	 
	 public Map<Orders,Map<OrdersDetail,Goods>> listGoodsInOrders(int customerId) {
		 List<Orders> orders_list = listOrders(customerId);
		 Map<Orders,Map<OrdersDetail,Goods>> m = new HashMap<>(); 
		 for(Orders o : orders_list) {
			 Map<OrdersDetail,Goods> map2 = OrderDetailListAllGoods(o);
			 m.put(o,map2);
		 }
		 return m;
	 }
	/* public Map<OrdersDetail,Goods> listGoodsInOrders(Orders order) {
		 Map<OrdersDetail,Goods> Goods_map = new HashMap<>();
		 List<OrdersDetail> ordersDetail_list = listOrdersDetails(order);
		 for(OrdersDetail ordersDetail : ordersDetail_list ){
			 Goods good = this.goodsDAO.loadById(ordersDetail.getGoodsId());
			 Goods_map.put(ordersDetail,good);
		 }
		 return Goods_map;
	 }*/
	 
	 
	 
}
