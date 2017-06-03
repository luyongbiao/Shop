package org.bqj.shopping.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bqj.shopping.entity.CartDetail;
import org.bqj.shopping.entity.Customer;
import org.bqj.shopping.entity.CustomerAddress;
import org.bqj.shopping.entity.Goods;
import org.bqj.shopping.entity.Orders;
import org.bqj.shopping.entity.OrdersDetail;
import org.bqj.shopping.service.CartService;
import org.bqj.shopping.service.CustomerAddressService;
import org.bqj.shopping.service.OrdersService;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/ordersDetailServlet")
public class OrdersDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrdersService ordersService;
	private CustomerAddressService customerAddressService;
    private CartService cartService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersDetailServlet() {
        super();
        this.ordersService = new OrdersService();
        this.customerAddressService = new CustomerAddressService();
        this.cartService = new CartService();
        
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
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.getParameterValues("checked");
		String[] cartDetaileIds = request.getParameterValues("checked");
		String op = request.getParameter("op");
		String[] ordersDetailIds = request.getParameterValues("ordersDetailId");
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
			List<CustomerAddress> address = this.customerAddressService.findByCustoemrId(customer.getCustomerId());
			
			if (map != null && map.size() != 0) {
				request.setAttribute("map", map);
				request.setAttribute("address", address);
				request.getRequestDispatcher("comfirm_order.jsp").forward(request, response);
				return;
			}
			response.sendRedirect("comfirm_order.jsp");
		} else if("save".equals(op) && cartDetaileIds != null ) {
			String status = request.getParameter("status");
			
			int OrdersStatus = Integer.parseInt(status);
			
			int[] cds = this.ordersService.transcartDetaileIdsStringtoId(cartDetaileIds);
			Orders orders = this.ordersService.saveOrders(customer.getCustomerId(), cds, OrdersStatus);
			request.setAttribute("orders",orders);
			Map<CartDetail,Goods> m= this.ordersService.transListAllByCartDetailId(cartDetaileIds);
			Map<OrdersDetail,Goods> map = this.ordersService.cartDetailToOrdersDetail(m,orders.getOrdersId());
			
			List<CustomerAddress> ca = this.customerAddressService.findByCustoemrId(customer.getCustomerId());
			
			for (CustomerAddress customerAddress : ca) {
				if (customerAddress.getAddressChecked() == 1)
					request.setAttribute("myAddress", customerAddress);
			}
			
			for(String idStr : cartDetaileIds) {
				int id = Integer.parseInt(idStr);
				this.cartService.deleteCartDetail(id);
			}
			
			if (map != null && map.size() != 0) {
				request.setAttribute("map", map);
				request.getRequestDispatcher("ordersDetail.jsp").forward(request, response);
				return;
			}
		} else if (op == null && ordersDetailIds != null) {
			Map<OrdersDetail, Goods> map= this.ordersService.transListAllByOrdersDetailId(ordersDetailIds);
			int ordersId = Integer.parseInt(request.getParameter("ordersId"));
			Orders orders = this.ordersService.changetoOrders(ordersId);
			List<CustomerAddress> ca = this.customerAddressService.findByCustoemrId(customer.getCustomerId());
			
			for (CustomerAddress customerAddress : ca) {
				if (customerAddress.getAddressChecked() == 1)
					request.setAttribute("myAddress", customerAddress);
			}
			if (map != null && map.size() != 0) {
				request.setAttribute("map", map);
				request.setAttribute("orders", orders);
				request.getRequestDispatcher("ordersDetail.jsp").forward(request, response);
				return;
			}
			response.sendRedirect("comfirm_order.jsp");
		}
	}
}
