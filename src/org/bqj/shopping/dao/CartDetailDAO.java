package org.bqj.shopping.dao;

import java.util.List;

import org.bqj.shopping.entity.CartDetail;

public interface CartDetailDAO extends BaseDAO<CartDetail> {
	CartDetail findByForeignKey(int goodsId, int cartId);
	int finGoodIdByCartDetail(int cartDetailId);
	List<CartDetail> findByCartId(int cartId);
}
