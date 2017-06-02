package org.bqj.shopping.service;

import java.util.List;

import org.bqj.shopping.dao.GoodsDAO;
import org.bqj.shopping.dao.impl.GoodsDAOImpl;
import org.bqj.shopping.entity.Goods;
import org.bqj.shopping.entity.PageBean;


public class GoodsCategoryService {
	private GoodsDAO goodsDao;
	
	public GoodsCategoryService() {
		this.goodsDao = new GoodsDAOImpl();
	}
	
	public List<Goods> findByCategoryIdResult(int categoryId, PageBean pageBean){
		
		List<Goods> list = null;
		List<Goods> judge = goodsDao.findByCategoryId(categoryId
							, pageBean.getBegin(), pageBean.getPageSize());
		if(judge.size()!=0){
			list = judge;
			return list;
		}else{
			return list;
		}
		
	}

	public int findCountById(int categoryId) {
		return this.goodsDao.findCountByCategory(categoryId);
	}
}
