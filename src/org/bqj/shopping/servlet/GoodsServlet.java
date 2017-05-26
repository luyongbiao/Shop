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
import org.bqj.shopping.service.GoodsService;
import org.json.JSONArray;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/goodsServlet")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GoodsService goodsService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsServlet() {
        this.goodsService = new GoodsService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("utf-8");
		
		
		String goodsIdStr = request.getParameter("goodsId");	
		
		if (goodsIdStr == null || goodsIdStr.equals("")) {
			String goodsInfo = request.getParameter("searchName");
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
			
			
			int totalCount = this.goodsService.findCount(goodsInfo);
			
			PageBean pageBean = new PageBean(currentPage, pageSize, totalCount);
			
			List<Goods> goods = goodsService.findGoodsByNameResult(goodsInfo, pageBean);
			String msg = "抱歉,没找到该类商品";
			
			if(goods!=null){
				if (currentPageParam == null || currentPageParam.equals("")) {
					request.setAttribute("goods", goods);
					request.setAttribute("pageBean", pageBean);
					request.getRequestDispatcher("/goods.jsp").forward(request, response);
				} else {
					response.setContentType("apolication/json;charset=utf-8");
					
					JSONArray a = new JSONArray(goods);
					response.getWriter().print(a);
				}
			}else{
				request.setAttribute("MSG", msg);
				request.getRequestDispatcher("/goodsNotFind.jsp").forward(request, response);
			}
		} else {
			int goodsId = 0;
			
			try {
				goodsId = Integer.parseInt(goodsIdStr);
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
			
			Goods goods = this.goodsService.findByGoodsId(goodsId);
			request.setAttribute("goods", goods);
			request.getRequestDispatcher("/goodsDetail.jsp").forward(request, response);
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
