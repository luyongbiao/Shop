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
	 * @see org.bqj.shopping.dao.OrdersDAO#findOrdersByCustomerId(int)
	 */
	@Override
	//find  Orders by customerId and then we can find the OrdersDetail
	public List<Orders> findOrdersByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		String sql = "select * from Orders where customerif = " +customerId;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<Orders> list = new ArrayList<Orders>();
		Orders order = null;
		try {
			while(rs.next()) {
				order = new Orders();
				order.setOrdersId(rs.getInt(1));
				order.setOrdersNote(rs.getString(2));
				order.setOrdersCreateTime(rs.getTimestamp(3));
				order.setOrdersPayTime(rs.getTimestamp(4));
				order.setOrdersStatusId(rs.getInt(5));
				order.setCustomerId(customerId);
				list.add(order);
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
















