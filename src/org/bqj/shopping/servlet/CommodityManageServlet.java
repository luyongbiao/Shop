package org.bqj.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bqj.shopping.entity.*;
import org.bqj.shopping.service.*;
@WebServlet("/CommodityManageServlet")
public class CommodityManageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("categoryId");
		if(id == null){
			GoodsService goodsService = new GoodsService();
			List<Goods> goods = goodsService.findAllGoods();
			request.setAttribute("Goods", goods);
			getServletContext().getRequestDispatcher("/commodityManage.jsp").forward(request, response);
		}else{
			int categoryId = Integer.parseInt(id);
			GoodsCategoryService goodsCategoryService = new GoodsCategoryService();
			List<Goods> goods = goodsCategoryService.findByCategoryIdResult(categoryId);
			request.setAttribute("Goods", goods);
			getServletContext().getRequestDispatcher("/commodityManage.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
