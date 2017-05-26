package org.bqj.shopping.dao;

import java.util.List;

import org.bqj.shopping.entity.Goods;

public interface GoodsDAO extends BaseDAO<Goods> {

	List<Goods> findByGoodsInfo(String info, int begin, int pageSize);

	int findCountByInfo(String info);
	
	List<Goods> findByCategoryId(int categoryId, int begin, int pageSize);

	int findCountByCategory(int categoryId);

}

