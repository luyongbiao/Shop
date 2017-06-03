package org.bqj.shopping.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bqj.shopping.entity.Customer;
import org.bqj.shopping.entity.Goods;
import org.bqj.shopping.entity.Orders;
import org.bqj.shopping.entity.OrdersDetail;
import org.bqj.shopping.service.OrdersService;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/ordersServlet")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrdersService ordersService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
        super();
        this.ordersService = new OrdersService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String json = readJSONString(request);
		JSONObject jsonObject = null;
		String op = "";	
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		
		if (json != null && !json.equals("")) {
			try {
				jsonObject = new JSONObject(json);
				op = jsonObject.getString("op");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (customer == null) {
				String responseJsonStr = "{message:logout}";
				JSONObject responseJson = null;
				try {
					responseJson = new JSONObject(responseJsonStr);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				response.getWriter().println(responseJson);
				return;
			}
		} else {
			response.setContentType("text/html;charset=utf-8");
			op = request.getParameter("op");
			
			if (customer == null) {
				response.sendRedirect("login.html");
				return;
			}
			
		}
		
		if(op.equals("list")) {
			Map<Orders,Map<OrdersDetail,Goods>> map = this.ordersService.listGoodsInOrders(customer.getCustomerId());
			if (map != null && map.size() != 0) {
				request.setAttribute("map", map);
//				request.setAttribute("map_goods", map_goods);
				request.getRequestDispatcher("orders.jsp").forward(request, response);
				return;
			}
			response.sendRedirect("orders.jsp");
		} else if("listNoPayed".equals(op)){
			//取出未付款的订单其OrdersStatusId为1
			Map<Orders,Map<OrdersDetail,Goods>> map = this.ordersService.listGoodsInOrders(customer.getCustomerId(),1);
			if (map != null && map.size() != 0) {
				request.setAttribute("map", map);
//				request.setAttribute("map_goods", map_goods);
				request.getRequestDispatcher("orders.jsp").forward(request, response);
				return;
			}
			response.sendRedirect("orders.jsp");
		} else if("listPayed".equals(op)){
			//取出已经付款的订单其OrdersStatusId为2
			Map<Orders,Map<OrdersDetail,Goods>> map = this.ordersService.listGoodsInOrders(customer.getCustomerId(),2);
			if (map != null && map.size() != 0) {
				request.setAttribute("map", map);
//				request.setAttribute("map_goods", map_goods);
				request.getRequestDispatcher("orders.jsp").forward(request, response);
				return;
			}
			response.sendRedirect("orders.jsp");
		}
		/*List<Map<OrdersDetail,Goods>> goods = new ArrayList<>(); 
			for(Orders order : orders) {
				map_goods = this.ordersService.listGoodsInOrders(order);
				goods.add(map_goods);
			}*/
		/*if(op.equals("comfirm")){
			int cartDetailId = 0;
			int goodsId = 0;
			int goodsCount = 0;
			double totalPrice = 0;
			try {
				cartDetailId = jsonObject.getInt("cartDetailId");
				goodsId = this.cartDetailDAO.finGoodIdByCartDetail(cartDetailId);
				goodsCount = jsonObject.getInt("goodsCount");
				totalPrice = jsonObject.getDouble("totalPrice");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			OrdersDetail ordersDetail = new OrdersDetail();
			ordersDetail.setGoodsCount(goodsCount);
			ordersDetail.setGoodsId(goodsId);
			ordersDetail.setTotalPrice(totalPrice);
			this.ordersService.saveOrders(ordersDetail, customer.getCustomerId());
			String responseJsonStr = "{message:success}";
			JSONObject responseJson = null;
			try {
				responseJson = new JSONObject(responseJsonStr);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			response.getWriter().println("i am line "+responseJson);
			response.sendRedirect("ordersServlet?op=list");
		} else
		else if(op.equals("trans")) {
			String[] cartDetaileIds = request.getParameterValues("checked");
			System.out.println(cartDetaileIds);
			Map<CartDetail, Goods> map= this.ordersService.transListAll(cartDetaileIds);
			if (map != null && map.size() != 0) {
				request.setAttribute("map", map);
				request.getRequestDispatcher("comfirm_order.jsp").forward(request, response);
				return;
			}
			response.sendRedirect("comfirm_order.jsp");
			CartDetail cd = this.cartDetailDAO.loadById(24);
			Goods good = this.goodsDAO.loadById(cd.getGoodsId());
			Map<CartDetail, Goods> map= new HashMap<>();
			map.put(cd, good);
			if (map != null && map.size() != 0) {
				request.setAttribute("map", map);
				request.getRequestDispatcher("comfirm_order.jsp").forward(request, response);
				return;
			}
			response.sendRedirect("comfirm_order.jsp");
		}*/
	}
	
	
	public String readJSONString(HttpServletRequest request) {
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json.toString();
	} 
}



























































































