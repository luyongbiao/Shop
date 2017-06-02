package org.bqj.shopping.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bqj.shopping.dao.GoodsCategoryDAO;
import org.bqj.shopping.db.DB;
import org.bqj.shopping.entity.GoodsCategory;

public class GoodsCategoryDAOImpl extends BaseDAOImpl<GoodsCategory> 
									implements GoodsCategoryDAO {

	public GoodsCategory getGoodsCategoryById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from goodscategory where goodsId =" + id;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		GoodsCategory goodsCategory = new GoodsCategory();
		try {
			while(rs.next()){
				goodsCategory.setGoodscategoryId(rs.getInt(1));
				goodsCategory.setCategoryId(rs.getInt(2));
				goodsCategory.setGoodsId(rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return goodsCategory;
	}
}
