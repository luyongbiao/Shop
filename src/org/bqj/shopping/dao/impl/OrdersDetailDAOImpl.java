package org.bqj.shopping.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bqj.shopping.dao.OrdersDetailDAO;
import org.bqj.shopping.db.DB;
import org.bqj.shopping.entity.OrdersDetail;

public class OrdersDetailDAOImpl extends BaseDAOImpl<OrdersDetail> 
									implements OrdersDetailDAO {

	/* (non-Javadoc)
	 * @see org.bqj.shopping.dao.OrdersDetailDAO#findOrdersDetailByOrdersId(int)
	 */
	@Override
	public List<OrdersDetail> findOrdersDetailByOrdersId(int OrdersId) {
		// TODO Auto-generated method stub
		List<OrdersDetail> list = new ArrayList<>();
		String sql = "select * from OrdersDetail where ordersId = " +OrdersId;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		try {
			while(rs.next()) {
				OrdersDetail od = new OrdersDetail();
				od.setOrdersdetailId(rs.getInt(1));
				od.setOrdersId(rs.getInt(2));
				od.setGoodsId(rs.getInt(3));
				od.setGoodsCount(rs.getInt(4));
				od.setTotalPrice(rs.getDouble(5));
				list.add(od);
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

	@Override
	public OrdersDetail findOrdersDetailByForigenkey(int ordersId, int goodsId) {
		// TODO Auto-generated method stub
		String sql = "select * from OrdersDetail where ordersId = " + ordersId + " and goodsId =" + goodsId;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt,sql);
		OrdersDetail ordersDetail = new OrdersDetail();
		try {
			while(rs.next()) {
				ordersDetail.setOrdersdetailId(rs.getInt(1));
				ordersDetail.setOrdersId(rs.getInt(2));
				ordersDetail.setGoodsId(rs.getInt(3));
				ordersDetail.setGoodsCount(rs.getInt(4));
				ordersDetail.setTotalPrice(rs.getDouble(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return ordersDetail;
	}
}



















