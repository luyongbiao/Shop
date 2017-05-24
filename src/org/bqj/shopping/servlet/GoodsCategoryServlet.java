package org.bqj.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bqj.shopping.entity.Goods;
import org.bqj.shopping.service.*;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/goodsCategoryServlet")
public class GoodsCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int categoryId = Integer.parseInt(request.getParameter("categoryId")); //取得商品分类的id
		//System.out.println(categoryId);
		String msg = "抱歉,找不到该类商品";
		GoodsCategoryService goodsService = new GoodsCategoryService();
		List<Goods> goods = goodsService.findByCategoryIdResult(categoryId);
		if(goods!=null){
			request.setAttribute("goods", goods);
			getServletContext().getRequestDispatcher("/goods.jsp").forward(request, response);
		}else{
			request.setAttribute("MSG", msg);
			getServletContext().getRequestDispatcher("/goodsNotFind.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
