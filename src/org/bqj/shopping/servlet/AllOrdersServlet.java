package org.bqj.shopping.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bqj.shopping.entity.Goods;
import org.bqj.shopping.entity.Orders;
import org.bqj.shopping.entity.OrdersDetail;
import org.bqj.shopping.service.UpdateStatusService;

/**
 * Servlet implementation class AllOrdersServlet
 */
@WebServlet("/AllOrdersServlet")
public class AllOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UpdateStatusService updateStatusService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllOrdersServlet() {
        super();
        this.updateStatusService = new UpdateStatusService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		 Map<Orders,Map<OrdersDetail,Goods>> map = this.updateStatusService.findAllList();
		 
		 request.setAttribute("map",map);
		 getServletContext().getRequestDispatcher("/ordersManage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
