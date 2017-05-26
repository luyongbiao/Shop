package org.bqj.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bqj.shopping.entity.Goods;
import org.bqj.shopping.entity.PageBean;
import org.bqj.shopping.service.*;
import org.json.JSONArray;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/goodsCategoryServlet")
public class GoodsCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GoodsCategoryService goodCategoryService;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsCategoryServlet() {
    	goodCategoryService = new GoodsCategoryService();
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
		String currentPageParam = request.getParameter("currentPage");
		
		int pageSize = 10;
		int currentPage = 0;
		
		if (currentPageParam == null || currentPageParam.trim().equals(""))
			currentPage = 1;
		else {
			try {
				currentPage = Integer.parseInt(currentPageParam);
				
				if (currentPage < 1 || currentPage > pageSize) {
					currentPage = 1;
				}
			} catch (NumberFormatException e) {
				currentPage = 1;
				e.printStackTrace();
			}
		}
		
		
		int totalCount = this.goodCategoryService.findCountById(categoryId);

		PageBean pageBean = new PageBean(currentPage, pageSize, totalCount);
		
		
		//System.out.println(categoryId);
		String msg = "抱歉,找不到该类商品";
		List<Goods> goods = goodCategoryService.findByCategoryIdResult(categoryId, pageBean);
		if(goods!=null){
			if (currentPageParam == null || currentPageParam.trim().equals("")) {
				request.setAttribute("goods", goods);
				request.setAttribute("pageBean", pageBean);
				getServletContext().getRequestDispatcher("/goods.jsp").forward(request, response);
			} else {
				response.setContentType("application/json;charset=utf-8");
				
				JSONArray a = new JSONArray(goods);
				response.getWriter().print(a);
			}
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
