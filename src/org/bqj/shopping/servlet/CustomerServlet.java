package org.bqj.shopping.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bqj.shopping.entity.Customer;
import org.bqj.shopping.service.CustomerService;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/customerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerService customerService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        this.customerService = new CustomerService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String json = readJSONString(request);
		JSONObject jsonObject = null;
		String op = "";
		try {
			jsonObject = new JSONObject(json);
			op = jsonObject.getString("op");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		if (op.equals("login")) {
			String customerName = "";
			String customerPassword = "";
			try {
				customerName = jsonObject.getString("customerName");
				customerPassword = jsonObject.getString("customerPassword");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			Customer c = null;
			if (customerName != null && !customerName.equals(""))
				if (customerPassword != null && !customerPassword.equals("")) {
					Customer customer = new Customer();
					customer.setCustomerName(customerName);
					customer.setCustomerPassword(customerPassword);
					
					c = this.customerService.login(customer);
				}
			
			if (c != null) {
				request.getSession().setAttribute("customer", c);
				response.getWriter().print("indexServlet");
			} else
				response.getWriter().print("error");
		
		}  else if (op.equals("logout")) {
			request.getSession().removeAttribute("customer");
		
		} else if (op.equals("register")) {
			String customerName = "";
			String customerPassword = "";
			String comfirmPassword = "";
			String customerGender = "";
			int customerAge = 0;
			String customerMobilePhone = "";
			String customerHomePhone = "";
			
			try {
				customerName = jsonObject.getString("customerName");
				customerPassword = jsonObject.getString("customerPassword");
				comfirmPassword = jsonObject.getString("comfirmPassword");
				customerGender = jsonObject.getString("customerGender");
				customerAge = jsonObject.getInt("customerAge");
				customerMobilePhone = jsonObject.getString("customerMobilePhone");
				customerHomePhone = jsonObject.getString("customerHomePhone");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			if (!comfirmPassword.equals(customerPassword))
				return;
			
			Customer c = new Customer();
			c.setCustomerName(customerName);
			c.setCustomerPassword(customerPassword);
			c.setCustomerGender(customerGender);
			c.setCustomerAge(customerAge);
			c.setCustoemrMobilePhone(customerMobilePhone);
			c.setCustomerHomePhone(customerHomePhone);
			
			String msg = this.customerService.register(c);
			
			if (msg != null) {
				response.getWriter().print(msg);
			}
		}
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
