package org.bqj.shopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bqj.shopping.entity.Goods;
import org.bqj.shopping.service.GoodsService;
@WebServlet("/CommodityModifyServletServlet")
public class CommodityModifyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		int goodsId =Integer.parseInt( request.getParameter("goodsId"));
		GoodsService goodsService = new GoodsService();
		Goods goods = goodsService.findGoodsById(goodsId);
		request.setAttribute("Goods", goods);
		getServletContext().getRequestDispatcher("/commodityModify.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
