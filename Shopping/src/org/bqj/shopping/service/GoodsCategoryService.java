package org.bqj.shopping.service;

import java.util.List;

import org.bqj.shopping.dao.impl.*;
import org.bqj.shopping.entity.Goods;


public class GoodsCategoryService {
	public List<Goods> findByCategoryIdResult(int categoryId){
		GoodsDAOImpl goodsDao = new GoodsDAOImpl();
		List<Goods> list = null;
		List<Goods> judge = goodsDao.findByCategoryId(categoryId);
		if(judge.size()!=0){
			list = judge;
			return list;
		}else{
			return list;
		}
		
	}
}
