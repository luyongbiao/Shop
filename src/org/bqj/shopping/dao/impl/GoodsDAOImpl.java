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
	public List<Goods> findByGoodsInfo(String info, int begin, int pageSize) {
		info = "'%"+ info + "%'";
		String sql = "select * from goods where goodsName like " + info 
				+ " or goodsDesc like " + info + " or goodsDesc like " + info + " limit " + begin + "," + pageSize;
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
				goods.setGoodsPic(rs.getString(9));
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
    
    public List<Goods> findByCategoryId(int categoryId){
        
        String sql = "select * from goods where goodsId in (select goodsId from goodscategory"
                + " where categoryId="+categoryId + ")";
        Connection conn = DB.getConn();
        Statement stmt = DB.createStatement(conn);
        ResultSet rs = DB.executeQuery(stmt, sql);
        List<Goods> list = new ArrayList<>();
        try {
            while(rs.next()){        
                Goods goods = new Goods();
                goods.setGoodsId(rs.getInt(1));
                goods.setGoodsName(rs.getString(2));
                goods.setGoodsPrice(rs.getDouble(3));
                goods.setGoodsStock(rs.getInt(4));
                goods.setGoodsDesc(rs.getString(5));
                goods.setGoodsShelfTime(rs.getTimestamp(6));
                goods.setGoodsHits(rs.getLong(7));
                goods.setGoodsSales(rs.getLong(8));
                goods.setGoodsPic(rs.getString(9));
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
	
	public List<Goods> findByCategoryId(int categoryId, int begin, int pageSize){
		
		String sql = "select * from goods where goodsId in (select goodsId from goodscategory"
				+ " where categoryId="+categoryId + ") limit " 
											+ begin + "," + pageSize;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<Goods> list = new ArrayList<>();
 		try {
			while(rs.next()){        
				Goods goods = new Goods();
				goods.setGoodsId(rs.getInt(1));
				goods.setGoodsName(rs.getString(2));
				goods.setGoodsPrice(rs.getDouble(3));
				goods.setGoodsStock(rs.getInt(4));
				goods.setGoodsDesc(rs.getString(5));
				goods.setGoodsShelfTime(rs.getTimestamp(6));
				goods.setGoodsHits(rs.getLong(7));
				goods.setGoodsSales(rs.getLong(8));
				goods.setGoodsPic(rs.getString(9));
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
    
	@Override
	public int findCountByInfo(String info) {
		info = "'%"+ info + "%'";
		String sql = "select count(*) from goods where goodsName like " + info 
				+ " or goodsDesc like " + info;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		int count = 0;
		
		try {
			if(rs.next())
				count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		
		return count;
	}

	@Override
	public int findCountByCategory(int categoryId) {
		String sql = "select count(*) from goodscategory where categoryId = " + categoryId;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		int count = 0;
		
		try {
			if(rs.next())
				count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DB.close(rs);
		DB.close(stmt);
		DB.close(conn);
		
		return count;
	}

	@Override
	public List<Goods> findByHits(int amount) {
		String sql = "select * from goods order by goodsHits desc limit 0," + amount;
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		List<Goods> list = new ArrayList<>();
 		try {
			while(rs.next()){        
				Goods goods = new Goods();
				goods.setGoodsId(rs.getInt(1));
				goods.setGoodsName(rs.getString(2));
				goods.setGoodsPrice(rs.getDouble(3));
				goods.setGoodsStock(rs.getInt(4));
				goods.setGoodsDesc(rs.getString(5));
				goods.setGoodsShelfTime(rs.getTimestamp(6));
				goods.setGoodsHits(rs.getLong(7));
				goods.setGoodsSales(rs.getLong(8));
				goods.setGoodsPic(rs.getString(9));
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
	public Goods getLastGoods() {
		// TODO Auto-generated method stub
		String sql  ="select * from  goods order by goodsShelfTime desc limit 0,1";
		Connection conn = DB.getConn();
		Statement stmt = DB.createStatement(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		Goods goods = new Goods();
		try {
			while(rs.next()){
				goods.setGoodsId(rs.getInt(1));
				goods.setGoodsName(rs.getString(2));
				goods.setGoodsPrice(rs.getDouble(3));
				goods.setGoodsStock(rs.getInt(4));
				goods.setGoodsDesc(rs.getString(5));
				goods.setGoodsShelfTime(rs.getTimestamp(6));
				goods.setGoodsHits(rs.getLong(7));
				goods.setGoodsSales(rs.getLong(8));
				goods.setGoodsPic(rs.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}
}
