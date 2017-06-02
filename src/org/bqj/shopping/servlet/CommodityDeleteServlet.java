package org.bqj.shopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bqj.shopping.entity.*;
import org.bqj.shopping.service.*;
@WebServlet("/CommodityDeleteServlet")
public class CommodityDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		int id =Integer.parseInt( request.getParameter("goodsId"));
		
		GoodsService goodsService = new GoodsService();
		GoodsCategoryService goodsCategoryService = new GoodsCategoryService();
		
		GoodsCategory goodsCategory=  goodsCategoryService.findGoodsCategoryByGoodsId(id);
		int goodsCategoryId = goodsCategory.getGoodscategoryId();
		
		goodsCategoryService.deleteGoodsCategoryById(goodsCategoryId);
		goodsService.deleteGoodsById(id);
		getServletContext().getRequestDispatcher("/CommodityManageServlet").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
