package org.bqj.shopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bqj.shopping.entity.*;
import org.bqj.shopping.service.*;

@WebServlet("/CommoditySaveServlet")
public class CommoditySaveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//获取修改参数
		int id =Integer.parseInt( request.getParameter("goodsId"));
		int categoryId = Integer.parseInt( request.getParameter("categoryId"));
		int goodsStock = Integer.parseInt( request.getParameter("goodsStock"));
		Double goodsPrice =Double.parseDouble( request.getParameter("goodsPrice"));
		String goodsName = new String(request.getParameter("goodsName"));	
		String goodsDesc = request.getParameter("goodsDesc");
		
		GoodsCategoryService goodsCategoryService = new GoodsCategoryService();
		GoodsCategory goodsCategory = goodsCategoryService.findGoodsCategoryByGoodsId(id);
		
		GoodsService goodsService = new GoodsService();
		Goods goods = goodsService.findGoodsById(id); 
		
		goodsCategory.setCategoryId(categoryId);
		
		goods.setGoodsName(goodsName);
		goods.setGoodsPrice(goodsPrice);
		goods.setGoodsStock(goodsStock);
		goods.setGoodsDesc(goodsDesc);
		
		goodsCategoryService.modify(goodsCategory);
		goodsService.modify(goods);
		
		getServletContext().getRequestDispatcher("/CommodityManageServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
