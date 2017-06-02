package org.bqj.shopping.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bqj.shopping.dao.CartDAO;
import org.bqj.shopping.dao.CartDetailDAO;
import org.bqj.shopping.dao.GoodsDAO;
import org.bqj.shopping.dao.impl.CartDAOImpl;
import org.bqj.shopping.dao.impl.CartDetailDAOImpl;
import org.bqj.shopping.dao.impl.GoodsDAOImpl;
import org.bqj.shopping.entity.Cart;
import org.bqj.shopping.entity.CartDetail;
import org.bqj.shopping.entity.Goods;

public class CartService {
	private CartDAO cartDAO;
	private CartDetailDAO cartDetailDAO;
	private GoodsDAO goodsDAO;
	
	public CartService() {
		cartDAO = new CartDAOImpl();
		cartDetailDAO = new CartDetailDAOImpl();
		goodsDAO = new GoodsDAOImpl();
	}
	
	public void insert(CartDetail cd, int customerId) {
		Cart cart = this.cartDAO.findByCustomerId(customerId);
		
		if (cart == null) {
			Cart c = new Cart();
			c.setCustomerId(customerId);
			c.setCartCreateTime(new Timestamp(new Date().getTime()));
			
			this.cartDAO.save(c);

			cd.setCartId(this.cartDAO.findByCustomerId(customerId).getCartId());
			this.cartDetailDAO.save(cd);
		} else {
			cd.setCartId(cart.getCartId());
			
			CartDetail cartDetail = this.cartDetailDAO.findByForeignKey(cd.getGoodsId(), cd.getCartId());
			
			if (cartDetail == null)
				this.cartDetailDAO.save(cd);
			else if (cartDetail.getGoodsStatus() == 1){
				int goodsCount = cd.getGoodsCount() + cartDetail.getGoodsCount();
				cartDetail.setGoodsCount(goodsCount);
				
				this.cartDetailDAO.modify(cartDetail);
			} else {
				this.cartDetailDAO.removeOne(cartDetail.getCartDetailId());
				this.cartDetailDAO.save(cd);
			}
		}
	}
	
	public void update(int cartDetailId,int goodsCount,double totalPrice){
		CartDetail cartDetail = this.cartDetailDAO.loadById(cartDetailId);
		cartDetail.setGoodsCount(goodsCount);
		cartDetail.setTotalPrice(totalPrice);
		this.cartDetailDAO.modify(cartDetail);
	}
	
	
	public Cart myCart(int customerId) {
		Cart cart = this.cartDAO.findByCustomerId(customerId);
		return cart;
	}
	
	public Map<Goods, CartDetail> list(Integer customerId) {
		Cart cart = this.cartDAO.findByCustomerId(customerId);
		Map<Goods, CartDetail> map = new HashMap<>();
		
		if (cart != null) {
			List<CartDetail> cds = this.cartDetailDAO.findByCartId(cart.getCartId());
			
			if (cds != null && cds.size() != 0) {
				for (CartDetail cd:cds) {
					Goods goods = this.goodsDAO.loadById(cd.getGoodsId());
					map.put(goods, cd);
				}
			}
		}
		
		if (map != null && map.size() != 0)
			return map;
		return null;
	}
	
	public void deleteCartDetail(Integer cartDetailId) {
		CartDetail cd = this.cartDetailDAO.loadById(cartDetailId);
		
		if (cd == null)
			return;

		this.cartDetailDAO.removeOne(cartDetailId);
		
		List<CartDetail> cartDetails = this.cartDetailDAO.findByCartId(cd.getCartId());
		
		if (cartDetails == null || cartDetails.size() == 0) {
			this.cartDAO.removeOne(cd.getCartId());			
		}
	}
	
	public void deleteMore(Integer[] cartDetailIds) {
		this.cartDAO.deleteMoreById(cartDetailIds);
	}

}
