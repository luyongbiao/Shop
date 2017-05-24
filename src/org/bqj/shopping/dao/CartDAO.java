package org.bqj.shopping.dao;


import org.bqj.shopping.entity.Cart;

public interface CartDAO extends BaseDAO<Cart> {
	Cart findByCustomerId(int customerId);
}
