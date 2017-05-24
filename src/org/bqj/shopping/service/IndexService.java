package org.bqj.shopping.service;

import java.util.List;

import org.bqj.shopping.dao.impl.GoodsDAOImpl;
import org.bqj.shopping.entity.Goods;

public class IndexService {

	public List<Goods> getGoods() {
		// TODO Auto-generated method stub
		GoodsDAOImpl goodDAO = new GoodsDAOImpl();
		List<Goods> goods = goodDAO.findGoods();
		return goods;
	}

}
