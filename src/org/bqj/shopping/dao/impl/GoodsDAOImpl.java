package org.bqj.shopping.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bqj.shopping.dao.GoodsDAO;
import org.bqj.shopping.db.DB;
import org.bqj.shopping.entity.Goods;

public class GoodsDAOImpl extends BaseDAOImpl<Goods> 
									implements GoodsDAO {

	@Override
	public List<Goods> findByGoodsName(String goodsName) {
		String sql = "select * from goods where goodsName like '%" + goodsName + "%'";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<Goods> list = new ArrayList<>();
		try {
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setGoodsId(rs.getInt(1));
				goods.setGoodsName(rs.getString(2));
				goods.setGoodsPrice(rs.getDouble(3));
				goods.setGoodsStock(rs.getInt(4));
				goods.setGoodsDesc(rs.getString(5));
				goods.setGoodsShelfTime(rs.getTimestamp(6));
				goods.setGoodsHits(rs.getLong(7));
				goods.setGoodsSales(rs.getLong(8));
				list.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return list;
	}
}
