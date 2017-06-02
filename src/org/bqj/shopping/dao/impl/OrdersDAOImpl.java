package org.bqj.shopping.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bqj.shopping.dao.OrdersDAO;
import org.bqj.shopping.db.DB;
import org.bqj.shopping.entity.Orders;

public class OrdersDAOImpl extends BaseDAOImpl<Orders> 
									implements OrdersDAO {

	/* (non-Javadoc)
	 * @see org.bqj.shopping.dao.OrdersDAO#findByCustomerId(int)
	 */
	@Override
	public List<Orders> findOrdersByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		List<Orders> list = new ArrayList<>();
		String sql = "select * from orders where customerId =" + customerId;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		try {
			while (rs.next()) {
				Orders o = new Orders();
				o.setOrdersId(rs.getInt(1));
				o.setOrdersNote(rs.getString(2));
				o.setOrdersCreateTime(rs.getTimestamp(3));
				o.setOrdersPayTime(rs.getTimestamp(4));
				o.setOrdersStatusId(rs.getInt(5));
				o.setCustomerId(customerId);
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return list;
	}

	@Override
	public int findOrdersByCreateTime(String createTime,int customerId) {
		// TODO Auto-generated method stub
		String sql = "SELECT ordersid from orders where ordersCreateTime = '" + createTime + "' and customerId = " + customerId ;                          
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt,sql);
		int OrdersId = 0;
		try {
			while(rs.next()){
				OrdersId = rs.getInt("OrdersId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		return OrdersId;
	}
	
}
