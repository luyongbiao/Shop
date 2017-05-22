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
}
