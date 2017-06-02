package org.bqj.shopping.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bqj.shopping.entity.Goods;
import org.bqj.shopping.entity.PageBean;
import org.bqj.shopping.service.GoodsService;
import org.json.JSONArray;

@WebServlet("/indexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodsService goodsService;
	
	public IndexServlet() {
		this.goodsService = new GoodsService();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		int currentPage = 0;
		String currentPageParam = request.getParameter("currentPage");
		
		int pageSize = 12;
		
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
		
		int totalCount = this.goodsService.goodsAmount();
		PageBean pageBean = new PageBean(currentPage, pageSize, totalCount);
		
		Set<Goods> goods = this.goodsService.getGoods(pageBean);
		List<Goods> goodsHits = this.goodsService.getHitsGoods(5);
		
		System.out.println(currentPage);
		if (currentPageParam == null || currentPageParam.trim().equals("")) {
			
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("Goods", goods);
			request.setAttribute("goodsHits", goodsHits);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			response.setContentType("application/json;charset=utf-8");		
			
			JSONArray a = new JSONArray(goods);
			response.getWriter().print(a);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
