package org.bqj.shopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bqj.shopping.entity.Admin;
import org.bqj.shopping.service.AdminService;

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
		String op = request.getParameter("op");
		if (op.equals("login")) {
			String adminPassword = request.getParameter("adminPassword");
			String adminName = request.getParameter("adminName");
			Admin admin = new Admin();
			admin.setAdminName(adminName);
			admin.setAdminPassword(adminPassword);
			boolean adminLogin = false;
			if (adminName != null && !adminName.equals("")) {
				adminLogin = this.adminService.login(admin);
				HttpSession session = request.getSession();
				session.setAttribute(admin.getAdminName(), admin);
			}
			if (adminLogin == true)
				response.sendRedirect("index.jsp");
			else
				response.sendRedirect("loginError.jsp");
		} else if (op.equals("register")) {
			String adminName = request.getParameter("adminName");
			String adminPassword = request.getParameter("adminPassword");
			String adminGender = request.getParameter("adminGender");
			String adminMobilePhone = request.getParameter("adminMobilePhone");
			Admin admin = new Admin();
			admin.setAdminName(adminName);
			admin.setAdminPassword(adminPassword);
			admin.setAdminGender(adminGender);
			admin.setAdminMobilePhone(adminMobilePhone);
			this.adminService.register(admin);
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
	
	/**
	 * @see HttpServlet#doPost(HttpServletrequest request, HttpServletresponseonse responseonse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}