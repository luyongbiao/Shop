package org.bqj.shopping.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	public Orders saveOrders(int customerId,int[] cartDetaileIds/*,String ordersNote*/, int OrdersStatus){
		Orders orders = new Orders();
//		orders.setOrdersNote(ordersNote);
		orders.setOrdersCreateTime(new Timestamp(new Date().getTime()));
		orders.setOrdersStatusId(OrdersStatus);//设置为未付款。
		orders.setCustomerId(customerId);
		this.ordersDAO.save(orders);
		/*System.out.println(orders.getOrdersCreateTime().toString().substring(0,19));*/
		int ordersId = this.ordersDAO.findOrdersByCreateTime(orders.getOrdersCreateTime().toString().substring(0,19),customerId);
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
	
	 public Map<CartDetail,Goods> transListAllByCartDetailId(String[] cartDetaileIds) {
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
	 
	 public Orders changetoOrders(int ordersId) { 
		 return this.ordersDAO.loadById(ordersId);
	 }
	 
	 public Map<OrdersDetail,Goods> cartDetailToOrdersDetail(Map<CartDetail,Goods> m,int ordersId) {
		 Map<OrdersDetail,Goods> map = new HashMap<>();
		 //用Set噶方法取出key同埋value
		 Set<CartDetail> cartDetails = m.keySet();
		 for (CartDetail cartDetail : cartDetails) {
			 Goods good = m.get(cartDetail);
			 OrdersDetail ordersDetail = this.ordersDetailDAO.findOrdersDetailByForigenkey(ordersId, good.getGoodsId());
			 map.put(ordersDetail, good);
		 }
		 return map;
	 }
	 
	 public Map<OrdersDetail,Goods> transListAllByOrdersDetailId(String[] ordersDetailId) {
		 if (ordersDetailId == null) {
			 System.out.println("ordersDetailId is null");
			 return null;
		 }
		 int [] ods = new int[ordersDetailId.length];
		 for (int i = 0;i < ordersDetailId.length;i ++) {
			 ods[i] = Integer.parseInt(ordersDetailId[i]);					
		 }
		 Map<OrdersDetail,Goods> Goods_map = new HashMap<>();
		 for(int od : ods ){
			 OrdersDetail ordersDetail = this.ordersDetailDAO.loadById(od);
			 Goods good = this.goodsDAO.loadById(ordersDetail.getGoodsId());
			 Goods_map.put(ordersDetail,good);
		 }
		 return Goods_map;
	 }
	 
	 //通过customerId查找Orders
	 public List<Orders> listOrders(int customerId) {
		 List<Orders> orders_list = this.ordersDAO.findOrdersByCustomerId(customerId);
		 return orders_list;
	 }
	 
	 //通过customeId和OrdersStatusId查询Orders
	 public List<Orders> listOrders(int customerId,int OrdersStatusId) {
		 List<Orders> orders_list = this.ordersDAO.findOrdersByForiegnKey(customerId,OrdersStatusId);
		 return orders_list;
	 }

	 //通过Orders查询多个OrdersDetail
	 public List<OrdersDetail> listOrdersDetails(Orders orders){
		 List<OrdersDetail> ordersDetail_list = this.ordersDetailDAO.findOrdersDetailByOrdersId(orders.getOrdersId());
		 return ordersDetail_list;
	 }
	 
	 //列出OrdersDetail和对应的Goods，存入map中
	 public Map<OrdersDetail,Goods> OrderDetailListAllGoods(Orders orders) {
		 List<OrdersDetail> ordersDetail_list = listOrdersDetails(orders);
		 Map<OrdersDetail,Goods> Goods_map = new HashMap<>();
		 for(OrdersDetail ordersDetail : ordersDetail_list ){
			 Goods good = this.goodsDAO.loadById(ordersDetail.getGoodsId());
			 Goods_map.put(ordersDetail,good);
		 }
		 return Goods_map;
	 }
	 
	 
	 //通过订单找出该订单内的订单详情OrdersDetail
	 public Map<Orders,List<OrdersDetail>> listAll(int customerId) {
		 List<Orders> orders = listOrders(customerId);
		 List<OrdersDetail> ordersDetail_list = new ArrayList<>();
		 Map<Orders,List<OrdersDetail>> orders_map = new HashMap<>();
		 for(Orders order : orders) {
			 ordersDetail_list = listOrdersDetails(order);
			 orders_map.put(order,ordersDetail_list);
		 }
		 return orders_map;
	 }
	 
	 //查询所有订单的map
	 public Map<Orders,Map<OrdersDetail,Goods>> listGoodsInOrders(int customerId) {
		 List<Orders> orders_list = listOrders(customerId);
		 Map<Orders,Map<OrdersDetail,Goods>> map = new HashMap<>(); 
		 for(Orders o : orders_list) {
			 Map<OrdersDetail,Goods> map2 = OrderDetailListAllGoods(o);
			 map.put(o,map2);
		 }
		 return map;
	 }
	 
	 //查询包含订单状态的map
	 public Map<Orders,Map<OrdersDetail,Goods>> listGoodsInOrders(int customerId,int ordersStatusId) {
		 List<Orders> orders_list = listOrders(customerId,ordersStatusId);
		 Map<Orders,Map<OrdersDetail,Goods>> map = new HashMap<>(); 
		 for(Orders o : orders_list) {
			 Map<OrdersDetail,Goods> map2 = OrderDetailListAllGoods(o);
			 map.put(o,map2);
		 }
		 return map;
	 }
	
	 /* Map<CartDetail,Goods> Goods_map = new HashMap<>();
	 for(int cd : cds ){
		 CartDetail cartDetail = this.cartDetailDAO.loadById(cd);
		 Goods good = this.goodsDAO.loadById(cartDetail.getGoodsId());
		 Goods_map.put(cartDetail,good);
	 }
	 public Map<OrdersDetail,Goods> listGoodsInOrders(Orders order) {
	 Map<OrdersDetail,Goods> Goods_map = new HashMap<>();
	 List<OrdersDetail> ordersDetail_list = listOrdersDetails(order);
	 for(OrdersDetail ordersDetail : ordersDetail_list ){
		 Goods good = this.goodsDAO.loadById(ordersDetail.getGoodsId());
		 Goods_map.put(ordersDetail,good);
	 }
	 return Goods_map;
 	}*/
	 
}
