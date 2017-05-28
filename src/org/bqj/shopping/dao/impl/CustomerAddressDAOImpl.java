package org.bqj.shopping.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bqj.shopping.dao.CustomerAddressDAO;
import org.bqj.shopping.db.DB;
import org.bqj.shopping.entity.CustomerAddress;

public class CustomerAddressDAOImpl extends BaseDAOImpl<CustomerAddress> implements CustomerAddressDAO {

	@Override
	public List<CustomerAddress> findByCustomerId(int customerId) {
		String sql = "select * from customeraddress where customerId=" + customerId;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<CustomerAddress> list = new ArrayList<>();
		try {
			while (rs.next()) {
				CustomerAddress customerAddress = new CustomerAddress();
				customerAddress.setCustomerAddressId(rs.getInt(1));
				customerAddress.setAddressProvince((rs.getString(2)));
				customerAddress.setAddressCity((rs.getString(3)));
				customerAddress.setAddressArea((rs.getString(4)));
				customerAddress.setAddressDetail((rs.getString(5)));
				customerAddress.setCustomerId(customerId);
				customerAddress.setAddressChecked(rs.getInt(7));
				list.add(customerAddress);
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
