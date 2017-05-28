package org.bqj.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bqj.shopping.entity.Customer;
import org.bqj.shopping.entity.CustomerAddress;
import org.bqj.shopping.service.CustomerAddressService;
import org.json.JSONArray;

@WebServlet("/addressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerAddressService customerAddressService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
    	customerAddressService = new CustomerAddressService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletrequest request, HttpServletresponseonse responseonse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletrequest request, HttpServletresponseonse responseonse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String op = request.getParameter("op");
		
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		
		if (customer == null) {
			response.sendRedirect("login.html");
			return;
		}
		
		if (op.equals("save")) {
			String addressProvince = request.getParameter("addressProvince");
			String addressCity = request.getParameter("addressCity");
			String addressArea = request.getParameter("addressArea");
			String addressDetail = request.getParameter("addressDetail");
			String addressCheckedStr = request.getParameter("addressChecked");
			int addressChecked = 0;
			
			try {
				addressChecked = Integer.parseInt(addressCheckedStr);
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
			
			CustomerAddress customerAddress = new CustomerAddress();
			customerAddress.setAddressProvince(addressProvince);
			customerAddress.setAddressCity(addressCity);
			customerAddress.setAddressArea(addressArea);
			customerAddress.setAddressDetail(addressDetail);
			customerAddress.setCustomerId(customer.getCustomerId());
			customerAddress.setAddressChecked(addressChecked);
			
			this.customerAddressService.saveOne(customerAddress);
		} else if(op.equals("list")) {
			List<CustomerAddress> customerAddresses = 
					this.customerAddressService.findByCustoemrId(customer.getCustomerId());
			
			JSONArray jsonarr = new JSONArray(customerAddresses);
			response.getWriter().print(jsonarr);
		} else if (op.equals("update")) {
			String customerAddressIdStr = request.getParameter("customerAddressId");
			String addressProvince = request.getParameter("addressProvince");
			String addressCity = request.getParameter("addressCity");
			String addressArea = request.getParameter("addressArea");
			String addressDetail = request.getParameter("addressDetail");
			String addressCheckedStr = request.getParameter("addressChecked");
			int addressChecked = 0;
			int customerAddressId = 0;
			
			try {
				addressChecked = Integer.parseInt(addressCheckedStr);
				customerAddressId = Integer.parseInt(customerAddressIdStr);
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
			
			CustomerAddress customerAddress = new CustomerAddress();
			customerAddress.setCustomerAddressId(customerAddressId);
			customerAddress.setAddressProvince(addressProvince);
			customerAddress.setAddressCity(addressCity);
			customerAddress.setAddressArea(addressArea);
			customerAddress.setAddressDetail(addressDetail);
			customerAddress.setCustomerId(customer.getCustomerId());
			customerAddress.setAddressChecked(addressChecked);
			System.out.println(addressProvince + addressCity + addressArea + addressDetail);
			this.customerAddressService.update(customerAddress);
		} else if (op.equals("findById")) {
			String customerAddressIdStr = request.getParameter("customerAddressId");
			int customerAddressId = 0;
			
			try {
				customerAddressId = Integer.parseInt(customerAddressIdStr);
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
			CustomerAddress customerAddress = this.customerAddressService.findById(customerAddressId);
			request.setAttribute("customerAddress", customerAddress);
			request.getRequestDispatcher("addressUpdate.jsp").forward(request, response);
		}
	}
}