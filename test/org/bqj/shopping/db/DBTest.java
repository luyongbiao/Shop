package org.bqj.shopping.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;


public class DBTest {

	@Test
	public void testPstmtQuery() throws SQLException {
		Connection conn = DB.getConn();
		String sql = "select * from customer where "
						+ "customerId=? and customerName=?";
		PreparedStatement pstmt = DB.preparedStatement(conn, sql);
		pstmt.setInt(1, 1);
		pstmt.setString(2, "小小人");
		ResultSet rs = DB.executeQuery(pstmt);
		while (rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(9));
		}
		DB.close(rs);
		DB.close(pstmt);
		DB.close(conn);
	}
	
	@Test
	public void testStmtQuery() throws SQLException {
		Connection conn = DB.getConn();
		String sql = "select * from customer where "
						+ "customerId=1 and customerName=" + "'澶у鏁�'";
		/*Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);*/
		ResultSet rs = DB.executeQuery(conn, sql);
		while (rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(9));
		}
		DB.close(rs);
		/*DB.close(stmt);*/
		DB.close(conn);
	}
	
	@Test
	public void testPstmtUpdate() throws SQLException {
		Connection conn = DB.getConn();
		String sql = "update customer set customerName=? where "
						+ "customerId=? and customerName=?";
		PreparedStatement pstmt = DB.preparedStatement(conn, sql);
		pstmt.setString(1, "解放军");
		pstmt.setInt(2, 1);
		pstmt.setString(3, "乱");
		DB.executeUpdate(pstmt);
		DB.close(pstmt);
		DB.close(conn);
	}
	
	@Test
	public void testStmtUpdate() throws SQLException {
		Connection conn = DB.getConn();
		String sql = "update customer set customerName='澶у鏁�' where "
						+ "customerId=1 and customerName='澶у'";
		Statement stmt = DB.createStatement(conn);
		stmt.executeUpdate(sql);
		DB.close(stmt);
		DB.close(conn);
	}
}
