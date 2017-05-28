package org.bqj.shopping.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bqj.shopping.entity.Admin;
import org.bqj.shopping.service.AdminService;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/adminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminService adminService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
    	adminService = new AdminService();
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
		
		String json = readJSONString(request);
		JSONObject jsonObject = null;
		
		String op = "";
			try {
				jsonObject = new JSONObject(json);
				op = jsonObject.getString("op");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if (op.equals("login")) {
			String adminPassword = "";
			String adminName = "";
			
			try {
				adminPassword = jsonObject.getString("adminPassword");
				adminName = jsonObject.getString("adminName");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Admin admin = new Admin();
			admin.setAdminName(adminName);
			admin.setAdminPassword(adminPassword);
			
			boolean adminLogin = false;

			if (adminName != null && !adminName.equals("")) {
				if (adminPassword != null && !adminPassword.equals("")) {
					adminLogin = this.adminService.login(admin);
					HttpSession session = request.getSession();
					session.setAttribute(admin.getAdminName(), admin);
				}
			}
			if (adminLogin == true)
				response.getWriter().print("index.jsp");
			else
				response.getWriter().print("error");
			
		} else if (op.equals("register")) {
			String adminName = "";
			String adminPassword = "";
			String adminGender = "";
			String adminMobilePhone = "";
			String comfirmPassword = "";
			
			try {
				adminPassword = jsonObject.getString("adminPassword");
				adminName = jsonObject.getString("adminName");
				adminGender = jsonObject.getString("adminGender");
				adminMobilePhone = jsonObject.getString("adminMobilePhone");
				comfirmPassword = jsonObject.getString("comfirmPassword");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (!adminPassword.equals(comfirmPassword))
				return;
			
			Admin admin = new Admin();
			admin.setAdminName(adminName);
			admin.setAdminPassword(adminPassword);
			admin.setAdminGender(adminGender);
			admin.setAdminMobilePhone(adminMobilePhone);
			
			String msg = this.adminService.register(admin);
			
			if (msg != null) {
				response.getWriter().print(msg);
			}
			
		} else if (op.equals("delete")) {
			int id = 0;
			String adminId = request.getParameter("adminId");
			if (adminId != null && !adminId.equals(""))
				id = Integer.parseInt(adminId);
			
			this.adminService.delete(id);
			
		} else if (op.equals("update")) {
			int id = 0;
			String adminId = request.getParameter("adminId");
			if (adminId != null && !adminId.equals(""))
				id = Integer.parseInt(adminId);
			
			String adminName = request.getParameter("adminName");
			String adminPassword = request.getParameter("adminPassword");
			String adminGender = request.getParameter("adminGender");
			String adminMobilePhone = request.getParameter("adminMobilePhone");
			
			Admin admin = new Admin();
			admin.setAdminId(id);
			admin.setAdminName(adminName);
			admin.setAdminPassword(adminPassword);
			admin.setAdminGender(adminGender);
			admin.setAdminMobilePhone(adminMobilePhone);
			
			this.adminService.update(admin);
			
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