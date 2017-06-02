package org.bqj.shopping.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bqj.shopping.entity.*;
import org.bqj.shopping.service.*;

/**
 * Servlet implementation class AddGoodsServlet
 */
@WebServlet("/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		int categoryId = Integer.parseInt( request.getParameter("categoryId"));
		int goodsStock = Integer.parseInt( request.getParameter("goodsStock"));
		Double goodsPrice =Double.parseDouble( request.getParameter("goodsPrice"));
		String goodsName = new String(request.getParameter("goodsName"));	
		String goodsDesc = request.getParameter("goodsDesc");
		String goodsPic = request.getParameter("goodsPic");
		
		Timestamp d = new Timestamp(System.currentTimeMillis());

		Goods goods = new Goods();
		goods.setGoodsName(goodsName);
		goods.setGoodsPrice(goodsPrice);
		goods.setGoodsStock(goodsStock);
		goods.setGoodsDesc(goodsDesc);
		goods.setGoodsPic("image/"+goodsPic);
		goods.setGoodsHits((long) 0);
		goods.setGoodsSales((long) 0);
		goods.setGoodsShelfTime(d);
		
		GoodsService goodsService = new GoodsService();
		goodsService.add(goods);		//在数据库添加新的记录

		goods = goodsService.getLastGoods();   //取得数据库中最新记录的goods对象
		
		GoodsCategoryService goodsCategoryService = new GoodsCategoryService();
		GoodsCategory goodsCategory = new GoodsCategory();
		goodsCategory.setCategoryId(categoryId);
		goodsCategory.setGoodsId(goods.getGoodsId());
		
		goodsCategoryService.add(goodsCategory);  		//在数据库添加新的记录
		
		getServletContext().getRequestDispatcher("/CommodityManageServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
