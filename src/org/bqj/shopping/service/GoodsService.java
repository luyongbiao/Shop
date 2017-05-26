package org.bqj.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bqj.shopping.dao.GoodsDAO;
import org.bqj.shopping.dao.impl.GoodsDAOImpl;
import org.bqj.shopping.entity.Goods;
import org.bqj.shopping.entity.PageBean;

public class GoodsService {
		private GoodsDAO goodsDao;
		
		public GoodsService() {
			this.goodsDao = new GoodsDAOImpl();
		}
	
		public List<Goods> findGoodsByNameResult(String goodsInfo, PageBean pageBean){
			List<Goods> list = new ArrayList<>();
			List<Goods> judge = new ArrayList<>();
			judge = goodsDao.findByGoodsInfo(goodsInfo, pageBean.getBegin(), pageBean.getPageSize());
			if(judge.size()!=0){
				list = judge;
				return list;
			}else{
				return null;
			}
			
		}
		
		public Set<Goods> getGoods() {
			int begin = (int)(Math.random() * (this.goodsDao.findCount() - 11));
			Set<Goods> goods = this.goodsDao.find(begin, 12);
			return goods;
		}
		
		public Set<Goods> getGoods(PageBean pageBean) {
			return this.goodsDao.find(pageBean.getBegin(), pageBean.getPageSize());
		}
		
		public int goodsAmount() {
			return this.goodsDao.findCount();
		}
		
		public Goods findByGoodsId(Integer goodsId) {
			return this.goodsDao.loadById(goodsId);
		}

		public int findCount(String info) {
			return this.goodsDao.findCountByInfo(info);
		}
}
