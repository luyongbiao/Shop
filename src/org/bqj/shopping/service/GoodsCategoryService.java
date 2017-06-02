package org.bqj.shopping.service;

import java.util.List;

import org.bqj.shopping.dao.impl.*;
import org.bqj.shopping.entity.Goods;
import org.bqj.shopping.entity.GoodsCategory;


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
	public GoodsCategory findGoodsCategoryByGoodsId(int id){
		GoodsCategoryDAOImpl goodsCategoryDao = new GoodsCategoryDAOImpl();
		GoodsCategory  goodsCategory = goodsCategoryDao.getGoodsCategoryById(id);
		return goodsCategory;
	}
	public void modify(GoodsCategory goodsCategory) {
		// TODO Auto-generated method stub
		GoodsCategoryDAOImpl goodsCategoryDao = new GoodsCategoryDAOImpl();
		goodsCategoryDao.modify(goodsCategory);
	}
	public void add(GoodsCategory goodsCategory) {
		// TODO Auto-generated method stub
		GoodsCategoryDAOImpl goodsCategoryDao = new GoodsCategoryDAOImpl();
		goodsCategoryDao.save(goodsCategory);
		
	}
	public void deleteGoodsCategoryById(int goodsCategoryId) {
		// TODO Auto-generated method stub
		GoodsCategoryDAOImpl goodsCategoryDao = new GoodsCategoryDAOImpl();
		goodsCategoryDao.removeOne(goodsCategoryId);
	}
}
