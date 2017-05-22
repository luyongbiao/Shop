package org.bqj.shopping.dao;

import java.util.List;

import org.bqj.shopping.entity.Goods;

public interface GoodsDAO extends BaseDAO<Goods> {

	List<Goods> findByGoodsName(String name);

}

