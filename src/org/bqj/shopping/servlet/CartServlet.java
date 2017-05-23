package org.bqj.shopping.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bqj.shopping.entity.Cart;
import org.bqj.shopping.entity.CartDetail;
import org.bqj.shopping.entity.Goods;
import org.bqj.shopping.service.CartService;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CartService cartService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        this.cartService = new CartService();
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
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String json = readJSONString(request);
		System.out.print(json);
		JSONObject jsonObject = null;
		String op = "";
		Integer customerId = (Integer) request.getSession().getAttribute("customer");
		
		if (json != null && !json.equals("")) {
			try {
				jsonObject = new JSONObject(json);
				op = jsonObject.getString("op");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if (customerId == null) {
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
			
			if (customerId == null) {
				response.sendRedirect("login.html");
				return;
			}
		}
		
		if (op.equals("save")) {
			
			int goodsId = 0;
			int goodsCount = 0;
			double totalPrice = 0;
			
			try {
				goodsId = jsonObject.getInt("goodsId");
				goodsCount = jsonObject.getInt("goodsCount");
				totalPrice = jsonObject.getDouble("totalPrice");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			CartDetail cd = new CartDetail();
			cd.setGoodsCount(goodsCount);
			cd.setGoodsId(goodsId);
			cd.setTotalPrice(totalPrice);
			cd.setGoodsStatus(1);
			
			this.cartService.insert(cd, customerId);
			
			String responseJsonStr = "{message:success}";
			JSONObject responseJson = null;
			try {
				responseJson = new JSONObject(responseJsonStr);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			response.getWriter().println(responseJson);
			
		} else if (op.equals("list")) {
			
			Cart cart = this.cartService.myCart(customerId);
			
			if (cart != null) {
				Map<Goods, CartDetail> map = this.cartService.list(customerId);
				
				if (map != null && map.size() != 0) {
					request.setAttribute("map", map);
					request.setAttribute("cart", cart);
					request.getRequestDispatcher("cart.jsp").forward(request, response);
					return;
				}
			}
			response.sendRedirect("cart.jsp");
			
		} else if (op.equals("delete")) {
			int cartDetailId = 0;
			String cdStr = request.getParameter("cartDetailId");
			
			try {
				cartDetailId = Integer.parseInt(cdStr);
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
			
			this.cartService.deleteCartDetail(cartDetailId);
			
			response.sendRedirect("cartServlet?op=list");
			
		} else if (op.equals("deleteMore")) {
			String cdIdsStr = "";
			
			try {
				cdIdsStr = jsonObject.getString("cartDetailId");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (cdIdsStr == null || cdIdsStr.trim().equals(""))
				return;
			
			String[] arr = cdIdsStr.split(",");
			
			for (String cartDetailIdStr : arr) {
				int cartDetailId = 0;
				try {
					cartDetailId = Integer.parseInt(cartDetailIdStr);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}

				response.getWriter().print("cartServlet?op=list");
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
