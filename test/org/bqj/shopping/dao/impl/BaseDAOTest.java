package org.bqj.shopping.dao.impl;


import org.bqj.shopping.entity.*;


import java.util.List;

import org.bqj.shopping.entity.Customer;
import org.bqj.shopping.entity.Goods;
//>>>>>>> branch 'master' of https://github.com/luyongbiao/Shop.git
import org.junit.Before;
import org.junit.Test;

public class BaseDAOTest {
	private CustomerDAOImpl customerDAOImpl;
	private AdminDAOImpl adminDAOImpl;
	private CartDAOImpl cartDAOImpl;
	private CategoryDAOImpl categoryDAOImpl;
	private GoodsDAOImpl goodsDAOImpl;
	private CartDetailDAOImpl cartDetailDAOImpl;
	private GoodsCategoryDAOImpl goodsCategoryDAOImpl;
	private OrdersDAOImpl ordersDAOImpl;
	private OrdersDetailDAOImpl ordersDetailDAOImpl;
	 
	@Before
	public void startup() {
		this.customerDAOImpl = new CustomerDAOImpl();
		this.adminDAOImpl = new AdminDAOImpl();
		this.cartDAOImpl = new CartDAOImpl();
		this.categoryDAOImpl = new CategoryDAOImpl();
		this.goodsDAOImpl = new GoodsDAOImpl();
		this.cartDetailDAOImpl = new CartDetailDAOImpl();
		this.goodsCategoryDAOImpl = new GoodsCategoryDAOImpl();
		this.ordersDAOImpl = new OrdersDAOImpl();
		this.ordersDetailDAOImpl = new OrdersDetailDAOImpl();
	}

	/**
	 * 
	 */
	@Test
	public void testLoadById() {
//<<<<<<< HEAD
		//Customer customer = new CustomerDAOImpl().loadById(1);
		//System.out.println(customer.getCustomerName());
		
		  // 测试Custoemr
//=======
//		List<Goods> list = new GoodsDAOImpl().findByGoodsName("手");
//		for (Goods g : list)
//			System.out.println(g.getGoodsName());

		/*
		 * // 测试Custoemr
>>>>>>> branch 'master' of https://github.com/luyongbiao/Shop.git
		Customer customer = customerDAOImpl.loadById(1);
		System.out.println(customer.getCustomerName());
		
		
		 //测试Admin
		  Admin admin = this.adminDAOImpl.loadById(3);
		System.out.println(admin.getAdminName());
		
		
		
		 //测试Cart
		Cart cart = this.cartDAOImpl.loadById(1);
		System.out.println(cart.getCustomerId());
		
		
		
		 //测试Category
		Category c = this.categoryDAOImpl.loadById(4);
		System.out.println(c.getCategoryName());
		
		
		
		  //测试Goods
		Goods g = this.goodsDAOImpl.loadById(4);
		System.out.println(g.getGoodsName());
		System.out.println(g.getGoodsPrice());
		System.out.println(g.getGoodsShelfTime());
		
		
			
		  //测试CartDetail
		CartDetail c1 = this.cartDetailDAOImpl.loadById(1);
		System.out.println(c1.getCartId());
		System.out.println(c1.getGoodsId());
		
			
		 //测试GoodsCategory
		GoodsCategory gc = this.goodsCategoryDAOImpl.loadById(1);
		System.out.println(gc.getCategoryId());
		System.out.println(gc.getGoodsId());
		
			
		  //测试Orders
		Orders o = this.ordersDAOImpl.loadById(4);
		System.out.println(o.getCustomerId());
		System.out.println(o.getOrdersCreateTime());
		
			
		 //测试OrdersDetail
		OrdersDetail od = this.ordersDetailDAOImpl.loadById(3);
		System.out.println(od.getOrdersId());
		System.out.println(od.getTotalPrice());
		
	}

	@Test
	public void testFindAll() {
		/测试Custoemr
		List<Customer> list = customerDAOImpl.findAll();
		System.out.println(list.size());
		for (Customer c : list) {
			System.out.println(c.getCustomerName());
			System.out.println(c.getCustomerGendar()); 
		}
		
		/*
		 *  //测试Admin
		 * List<Admin> list = adminDAOImpl.findAll();
		System.out.println(list.size());
		for (Admin admin : list) {
			System.out.println(admin.getAdminName());
			System.out.println(admin.getAdminGendar()); 
		}*/
		
		
		/*
		 *  //测试Cart
		List<Cart> list = this.cartDAOImpl.findAll();
		System.out.println(list.size());
		for (Cart c : list) {
			System.out.println(c.getCartStatus());
			System.out.println(c.getCartCreateTime()); 
		}*/
		
		/*
		 *  //测试Category
		List<Category> list = this.categoryDAOImpl.findAll();
		System.out.println(list.size());
		for (Category c : list) {
			System.out.println(c.getCategoryName());
			System.out.println(c.getCategoryLevel());
		}*/
		
		/*
		 *  //测试Goods
		List<Goods> list = this.goodsDAOImpl.findAll();
		System.out.println(list.size());
		for (Goods g : list) {
			System.out.println(g.getGoodsName());
			System.out.println(g.getGoodsShelfTime());
			System.out.println(g.getGoodsStock());
		}*/
		
		/*	
		 * //测试CartDetail
		List<CartDetail> list = this.cartDetailDAOImpl.findAll();
		System.out.println(list.size());
		for (CartDetail c : list) {
			System.out.println(c.getGoodsCount());
			System.out.println(c.getTotalPrice()); 
		}*/
		
		/*	
		 * //测试GoodsCategory
		List<GoodsCategory> list = this.goodsCategoryDAOImpl.findAll();
		System.out.println(list.size());
		for (GoodsCategory gc : list) {
			System.out.println(gc.getGoodsId());
			System.out.println(gc.getCategoryId()); 
		}*/
		
		/*	
		 * //测试Orders
		List<Orders> list = this.ordersDAOImpl.findAll();
		System.out.println(list.size());
		for (Orders o : list) {
			System.out.println(o.getCustomerId());
			System.out.println(o.getOrdersCreateTime()); 
		}*/
		
		/*	
		 * //测试OrdersDetail
		List<OrdersDetail> list = this.ordersDetailDAOImpl.findAll();
		System.out.println(list.size());
		for (OrdersDetail od : list) {
			System.out.println(od.getOrdersId());
			System.out.println(od.getTotalPrice()); 
		}
		*/
	}
	@Test
	public void testFindAll() {
		//测试Custoemr
		List<Customer> list = customerDAOImpl.findAll();
		System.out.println(list.size());
		for (Customer c : list) {
			System.out.println(c.getCustomerName()+"aaa");
			System.out.println(c.getCustomerAge());
		}
	}
	@Test
	public void testSave() {
		/*
		 *  //测试Custoemr
		Customer c = new Customer();
		c.setCustomerName("涓嶅皯浜�");
		c.setCustomerGendar("濂�");
		c.setCustomerPassword("13233211");
		c.setCustomerAge(11);
		c.setCustomerHomePhone("54354354354");
		c.setCustoemrMobilePhone("dfdsllfsld");
		c.setCustomerAddress("骞夸笢楂樺窞");
		c.setCvipid(1);
		customerDAOImpl.save(c);*/
		
		/*
		 *  //测试Admin
		 * Admin admin = new Admin();
		admin.setAdminName("绠＄悊鍛�2");
		admin.setAdminGendar("濂�");
		admin.setAdminPassword("789987541415");
		admin.setAdminMobilePhone("45783478");
		this.adminDAOImpl.save(admin);*/
		
		
		/*
		 *  //测试Cart
		Cart c = new Cart();
		c.setCartCreateTime(new Timestamp(System.currentTimeMillis()));
		c.setCartStatus("鏄惁");
		c.setCustomerId(2);
		this.cartDAOImpl.save(c);*/
		
		/*
		 *  //测试Category
		Category c = new Category();
		c.setCategoryName("鐢靛瓙浜у搧");
		c.setCategoryLevel(1);
		c.setCategoryDesc("鐢ㄧ數鐨勪骇鍝� 鎶垫姉鍔涘畼鏂硅繘鍙ｉ噺鐨勬拻椋炴満鍝﹁鍝︽棩鍝﹁�虫俯璁″伓鐒剁湅浜嗘湭鑰冭檻鍔犲叆鍒诲綍鏈�");
		this.categoryDAOImpl.save(c);*/
		
		/*
		 *  //测试Goods
		Goods g = new Goods();
		g.setGoodsName("鑱旂郴鐢佃剳");
		g.setGoodsPrice(4000.0);
		g.setGoodsDesc("鐙珛寮�鍙戝彲鎬滀汉鐪嬭浜嗚�冭檻浜哄彛涓哄摝鏃ュ摝鎴�");
		g.setGoodsStock(100);
		g.setGoodsHits(new Long(0));
		g.setGoodsSales(new Long(0));
		g.setGoodsShelfTime(new Timestamp(new Date().getTime()));
		this.goodsDAOImpl.save(g);*/
		
		/*	
		 * //测试CartDetail
		CartDetail c = new CartDetail();
		c.setCartId(1);
		c.setGoodsId(4);
		c.setGoodsCount(10000);
		c.setTotalPrice(10000.0);
		this.cartDetailDAOImpl.save(c);*/
		
		/*	
		 * //测试GoodsCategory
		GoodsCategory gc = new GoodsCategory();
		gc.setGoodsId(4);
		gc.setCategoryId(4);
		this.goodsCategoryDAOImpl.save(gc);*/
		
		/*	
		 * //测试Orders
		Orders o = new Orders();
		o.setOrdersNote("鍦嗛�氬揩閫�");
		o.setOrdersPayTime(new Timestamp(System.currentTimeMillis()));
		o.setOrdersCreateTime(new Timestamp(System.currentTimeMillis()));
		o.setOrdersStatusId(1);
		o.setCustomerId(8);
		this.ordersDAOImpl.save(o);*/
		
		/*	
		 * //测试OrdersDetail
		OrdersDetail od = new OrdersDetail();
		od.setGoodsId(4);
		od.setOrdersId(1);
		od.setGoodsCount(2);
		od.setTotalPrice(10.0);
		this.ordersDetailDAOImpl.save(od);*/
	}

	@Test
	public void testRemoveOne() {
		/*
		 *  //测试Custoemr
		 * customerDAOImpl.removeOne(7);*/
		
		/*
		 *  //测试Admin
		 * this.adminDAOImpl.removeOne(2);*/
		
		
		/*
		 *  //测试Cart
		this.cartDAOImpl.removeOne(5);*/
		
		/*
		 *  //测试Category
		this.categoryDAOImpl.removeOne(1);*/
		
		/*
		 *  //测试Goods
		this.goodsDAOImpl.removeOne(2);*/
		
		/*	
		 * //测试CartDetail
		this.cartDetailDAOImpl.removeOne(3);*/
		
		/*	
		 * //测试GoodsCategory
		this.goodsCategoryDAOImpl.removeOne(4);*/
		
		/*	
		 * //测试Orders
		this.ordersDAOImpl.removeOne(3);*/
		
		/*	
		 * //测试OrdersDetail
		this.ordersDetailDAOImpl.removeOne(1);*/
	}

	@Test
	public void testRemoveAll() {
		/*
		 *  //测试Custoemr
		 * customerDAOImpl.removeAll();*/
		
		
		/*
		 *  //测试Admin
		 * this.adminDAOImpl.removeAll();*/
		
		/*
		 *  //测试Cart
		this.cartDAOImpl.removeAll();*/
		
		/*
		 *  //测试Category
		this.categoryDAOImpl.removeAll();*/
		
		/*
		 *  //测试Goods
		this.goodsDAOImpl.removeAll();*/
		
		/*	
		 * //测试CartDetail
		this.cartDetailDAOImpl.removeAll();*/
		
		/*	
		 * //测试GoodsCategory
		this.goodsCategoryDAOImpl.removeAll();*/
		
		/*	
		 * //测试Orders
		this.ordersDAOImpl.removeAll();*/
		
		/*	
		 * //测试OrdersDetail
		this.ordersDetailDAOImpl.removeAll();*/
	}

	@Test
	public void testModify() {
		/*
		 *  //测试Custoemr
		 * Customer c = new Customer();
		c.setCustomerId(2);
		c.setCustomerName("澶т汉");
		c.setCvipid(1);
		customerDAOImpl.modify(c);*/
		
		/*
		 *  //测试Admin
		 * Admin admin = new Admin();
		admin.setAdminId(3);
		admin.setAdminName("瓒呯骇绠＄悊鍛�");
		admin.setAdminPassword("9879898");
		this.adminDAOImpl.modify(admin);*/
		
		/*
		 *  //测试Cart
		Cart c = new Cart();       
		c.setCartCreateTime(new Timestamp(new Date().getTime()));
		c.setCartId(2);
		c.setCartStatus("鏄惁");
		c.setCustomerId(2);
		this.cartDAOImpl.modify(c);*/
		
		
		/*
		 *  //测试Category
		Category c = new Category();
		c.setCategoryId(2);
		c.setCategoryName("娲楁急鐢ㄥ搧");
		c.setCategoryLevel(3);
		this.categoryDAOImpl.modify(c);*/
		
		/*
		 *  //测试Goods
		Goods g = new Goods();
		g.setGoodsId(4);
		g.setGoodsName("鎵嬫満");
		g.setGoodsPrice(5000.0);
		g.setGoodsHits(1L);
		g.setGoodsShelfTime(new Timestamp(new Date().getTime()));
		g.setGoodsDesc("鐨勭墷鎴块噷鐨�");
		this.goodsDAOImpl.modify(g);*/
		
		/*	
		 * //测试CartDetail
		CartDetail c = new CartDetail();
		c.setCartDetailId(4);
		c.setCartId(1);
		c.setGoodsId(4);
		c.setTotalPrice(15.0);
		this.cartDetailDAOImpl.modify(c);*/
		
		/*	
		 * //测试GoodsCategory
		GoodsCategory gc = new GoodsCategory();
		gc.setGoodscategoryId(4);
		gc.setCategoryId(4);
		gc.setGoodsId(4);
		this.goodsCategoryDAOImpl.modify(gc);*/
		
		/*	
		 * //测试Orders
		Orders o = new Orders();
		o.setOrdersId(1);
		o.setOrdersNote("鍥介�氬揩閫�");
		o.setOrdersPayTime(new Timestamp(System.currentTimeMillis()));
		o.setOrdersCreateTime(new Timestamp(System.currentTimeMillis()));
		o.setOrdersStatusId(2);
		o.setCustomerId(2);
		this.ordersDAOImpl.modify(o);*/
		
		/*	
		 * //测试OrdersDetail
		OrdersDetail od = new OrdersDetail();
		od.setOrdersdetailId(3);
		od.setGoodsId(4);
		od.setOrdersId(4);
		od.setGoodsCount(200);
		od.setTotalPrice(1000.0);
		this.ordersDetailDAOImpl.modify(od);*/
	}
	
	@Test
	public void testFindCount() {
		/*
		 *  //测试Custoemr
		 * System.out.println(customerDAOImpl.findCount());*/
		
		/*
		 *  //测试Admin
		 * this.adminDAOImpl.findCount();*/
		
			
		/*
		 *  //测试Cart
		 * System.out.println(this.cartDAOImpl.findCount());*/
		
		/*
		 *  //测试Category
		System.out.println(this.categoryDAOImpl.findCount());*/
		
		/*
		 *  //测试Goods
		System.out.println(this.goodsDAOImpl.findCount());*/
		
		/*	
		 * //测试CartDetail
		System.out.println(this.cartDetailDAOImpl.findCount());*/
		
		/*	
		 * //测试GoodsCategory
		System.out.println(this.goodsCategoryDAOImpl.findCount());*/
		
		/*	
		 * //测试Orders
		System.out.println(this.ordersDAOImpl.findCount());*/
		
		/*	
		 * //测试OrdersDetail
		System.out.println(this.ordersDetailDAOImpl.findCount());*/
	}

}
