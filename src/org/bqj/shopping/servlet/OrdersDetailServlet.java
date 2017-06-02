package org.bqj.shopping.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< .mine
import org.bqj.shopping.entity.CartDetail;
import org.bqj.shopping.entity.Customer;
import org.bqj.shopping.entity.CustomerAddress;
import org.bqj.shopping.entity.Goods;
import org.bqj.shopping.entity.Orders;
import org.bqj.shopping.service.CustomerAddressService;
import org.bqj.shopping.service.OrdersService;

=======
import org.bqj.shopping.entity.CartDetail;
import org.bqj.shopping.entity.Customer;
import org.bqj.shopping.entity.Goods;
import org.bqj.shopping.entity.Orders;
import org.bqj.shopping.entity.OrdersDetail;
import org.bqj.shopping.service.OrdersService;


>>>>>>> .theirs
/**
 * Servlet implementation class Cart
 */
@WebServlet("/ordersDetailServlet")
public class OrdersDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
<<<<<<< .mine
	private OrdersService ordersService;
	private CustomerAddressService customerAddressService;
=======
	private OrdersService ordersService;

>>>>>>> .theirs
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersDetailServlet() {
        super();
<<<<<<< .mine
        this.ordersService = new OrdersService();
        this.customerAddressService = new CustomerAddressService();
=======
        this.ordersService = new OrdersService();

>>>>>>> .theirs
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
<<<<<<< .mine
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.getParameterValues("checked");
		String[] cartDetaileIds = request.getParameterValues("checked");
		String op = request.getParameter("op");
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		//String[] cartDetaileIds = {"24","25","26"};
		/*System.out.println(cartDetaileIds.length);
		for (String s : cartDetaileIds) {
			System.out.println(s);
		}*/
		if (customer == null) {
			response.sendRedirect("login.html");
			return ;
		}
		if (op == null && cartDetaileIds != null) {
			Map<CartDetail, Goods> map= this.ordersService.transListAll(cartDetaileIds);
			List<CustomerAddress> address = this.customerAddressService.findByCustoemrId(customer.getCustomerId());
			
			if (map != null && map.size() != 0) {
				request.setAttribute("map", map);
				request.setAttribute("address", address);
				request.getRequestDispatcher("comfirm_order.jsp").forward(request, response);
				return;
			}
			response.sendRedirect("comfirm_order.jsp");
		} else if("save".equals(op) && cartDetaileIds != null ) {
			int[] cds = this.ordersService.transcartDetaileIdsStringtoId(cartDetaileIds);
			Orders orders = this.ordersService.saveOrders(customer.getCustomerId(), cds);
			request.setAttribute("orders",orders);
			System.out.println(orders);
			Map<CartDetail, Goods> map= this.ordersService.transListAll(cartDetaileIds);
			if (map != null && map.size() != 0) {
				request.setAttribute("map", map);
				request.getRequestDispatcher("ordersDetail.jsp").forward(request, response);
				return;
			}
		}
		
		

















=======
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.getParameterValues("checked");
		String[] cartDetaileIds = request.getParameterValues("checked");
		String[] ordersDetailIds = request.getParameterValues("ordersDetailId");
		String op = request.getParameter("op");
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		//String[] cartDetaileIds = {"24","25","26"};
		/*System.out.println(cartDetaileIds.length);
		for (String s : cartDetaileIds) {
			System.out.println(s);
		}*/
		if (customer == null) {
			response.sendRedirect("login.html");
			return ;
		}
		if (op == null && cartDetaileIds != null) {
			Map<CartDetail, Goods> map= this.ordersService.transListAllByCartDetailId(cartDetaileIds);
			if (map != null && map.size() != 0) {
				request.setAttribute("map", map);
				request.getRequestDispatcher("comfirm_order.jsp").forward(request, response);
				return;
			}
			response.sendRedirect("comfirm_order.jsp");
		} else if (op == null && ordersDetailIds != null) {
			Map<OrdersDetail, Goods> map= this.ordersService.transListAllByOrdersDetailId(ordersDetailIds);
			int ordersId = Integer.parseInt(request.getParameter("ordersId"));
			System.out.println(ordersId);
			Orders orders = this.ordersService.changetoOrders(ordersId);
			if (map != null && map.size() != 0) {
				request.setAttribute("map", map);
				request.setAttribute("orders", orders);
				request.getRequestDispatcher("ordersDetail.jsp").forward(request, response);
				return;
			}
			response.sendRedirect("comfirm_order.jsp");
		} else if("save".equals(op) && cartDetaileIds != null ) {
			int[] cds = this.ordersService.transcartDetaileIdsStringtoId(cartDetaileIds);
			Orders orders = this.ordersService.saveOrders(customer.getCustomerId(), cds);
			request.setAttribute("orders",orders);
			System.out.println(orders);
			Map<CartDetail,Goods> m= this.ordersService.transListAllByCartDetailId(cartDetaileIds);
			Map<OrdersDetail,Goods> map = this.ordersService.cartDetailToOrdersDetail(m,orders.getOrdersId());
			
			/*
				此处删除Cart detail的代码
			*/
			
			
			if (map != null && map.size() != 0) {
				request.setAttribute("map", map);
				request.getRequestDispatcher("ordersDetail.jsp").forward(request, response);
				return;
			}
		}
		
		
>>>>>>> .theirs
	}
	
	
	

}
