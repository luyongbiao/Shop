package org.bqj.shopping.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bqj.shopping.dao.CartDetailDAO;
import org.bqj.shopping.db.DB;
import org.bqj.shopping.entity.CartDetail;

public class CartDetailDAOImpl extends BaseDAOImpl<CartDetail> 
									implements CartDetailDAO {

	@Override
	public CartDetail findByForeignKey(int goodsId, int cartId) {
		String sql = "select * from cartDetail where goodsId=" + goodsId + " and cartId=" + cartId;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		CartDetail cd = null;
		try {
			while (rs.next()) {
				cd = new CartDetail();
				cd.setCartDetailId(rs.getInt(1));
				cd.setCartId(cartId);
				cd.setGoodsId(goodsId);
				cd.setGoodsCount(rs.getInt(4));
				cd.setTotalPrice(rs.getDouble(5));
				cd.setGoodsStatus(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cd;
	}

	@Override
	public List<CartDetail> findByCartId(int cartId) {
		List<CartDetail> list = new ArrayList<>();
		
		String sql = "select * from cartdetail where cartId =" + cartId;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);

		try {
			while (rs.next()) {
				CartDetail cd = new CartDetail();
				cd.setCartDetailId(rs.getInt(1));
				cd.setGoodsId(rs.getInt(2));
				cd.setCartId(rs.getInt(3));
				cd.setGoodsCount(rs.getInt(4));
				cd.setTotalPrice(rs.getDouble(5));
				cd.setGoodsStatus(rs.getInt(6));
				list.add(cd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
}
