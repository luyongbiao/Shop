package org.bqj.shopping.service;

import java.util.List;

import org.bqj.shopping.dao.GoodsDAO;
import org.bqj.shopping.dao.impl.GoodsDAOImpl;
import org.bqj.shopping.entity.Goods;


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
    
    public List<Goods> findByCategoryIdResult(int categoryId) {
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

	public int findCountById(int categoryId) {
		return this.goodsDao.findCountByCategory(categoryId);
	}
}}
