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
	//find OrdersDetails by OrdersId and then we find the customer who ordered this order.
	public List<OrdersDetail> findOrdersDetailByOrdersId(int ordersid) {
		// TODO Auto-generated method stub
		String sql = "select * from OrdersDetail where OrdersId = " +ordersid;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<OrdersDetail> list = new ArrayList<OrdersDetail>();
		OrdersDetail od = null;
		try {
			od = new OrdersDetail();
			while(rs.next()) {		
				od.setOrdersdetailId(rs.getInt(1));
				od.setOrdersId(rs.getInt(2));
				od.setGoodsId(rs.getInt(3));   //so we can find the goodId and show something by goodsId
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
}
