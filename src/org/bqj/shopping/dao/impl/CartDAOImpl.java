package org.bqj.shopping.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bqj.shopping.dao.CartDAO;
import org.bqj.shopping.db.DB;
import org.bqj.shopping.entity.Cart;

public class CartDAOImpl extends BaseDAOImpl<Cart> 
									implements CartDAO {

	@Override
	public Cart findByCustomerId(int customerId) {
		String sql = "select * from cart where customerId = " + customerId;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		Cart cart = null;
		try {
			while (rs.next()) {
				cart = new Cart();
				cart.setCartId(rs.getInt(1));
				cart.setCartCreateTime(rs.getTimestamp(2));
				cart.setCustomerId(customerId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn) ;
		return cart;
	}

	@Override
	public void deleteMoreById(Integer[] cartDetailIds) {
		StringBuffer sql = new StringBuffer("delete from cartDetail where 1=2");
		for (int cartDetailId : cartDetailIds)
			sql.append(" or cartDetailId = " + cartDetailId);
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		DB.executeUpdate(stmt, sql.toString());
		
		DB.close(stmt);
		DB.close(conn);
	}
}
