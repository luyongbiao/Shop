package org.bqj.shopping.service;

import java.util.*;

import org.bqj.shopping.dao.impl.*;
import org.bqj.shopping.entity.Goods;

public class GoodsService {
		public List<Goods> findGoodsByNameResult(String name){
			GoodsDAOImpl goodsDao = new GoodsDAOImpl();
			List<Goods> list = new ArrayList<>();
			List<Goods> judge = new ArrayList<>();
			judge = goodsDao.findByGoodsName(name);
			if(judge.size()!=0){
				list = judge;
				return list;
			}else{
				return null;
			}
			
		}
		public Goods findGoodsById(int id){
			GoodsDAOImpl goodsDao = new GoodsDAOImpl();
			Goods goods = goodsDao.loadById(id);
			return goods;
		}
		public List<Goods> findAllGoods(){
			GoodsDAOImpl goodsDao = new GoodsDAOImpl();
			List<Goods> goods = goodsDao.findAll();
			return goods;
		}
		public void deleteGoodsById(int id ){
			GoodsDAOImpl goodsDao = new GoodsDAOImpl();
			goodsDao.removeOne(id);
		}
		public void modify(Goods goods) {
			// TODO Auto-generated method stub
			GoodsDAOImpl goodsDao = new GoodsDAOImpl();
			goodsDao.modify(goods);
		}
		
		public void add(Goods goods){
			GoodsDAOImpl goodsDao = new GoodsDAOImpl();
			goodsDao.save(goods);
		}
		public Goods getLastGoods() {
			// TODO Auto-generated method stub
			GoodsDAOImpl goodsDao = new GoodsDAOImpl();
			Goods goods = null;
			goods = goodsDao.getLastGoods();
			return goods;
		}
}
