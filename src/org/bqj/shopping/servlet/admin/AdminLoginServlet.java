package org.bqj.shopping.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bqj.shopping.entity.Admin;
import org.bqj.shopping.service.AdminService;

@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		Admin admin = new Admin();
		admin.setAdminName(name);
		admin.setAdminPassword(password);
		boolean adminLogin = false;
		if (name != null && !name.equals("")) {
			adminLogin = new AdminService().login(admin);
				HttpSession session = req.getSession();
				session.setAttribute(admin.getAdminName(), admin);
		}
		if (adminLogin == true)
			resp.sendRedirect("index.jsp");
		else
			resp.sendRedirect("loginError.jsp");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		Admin admin = new Admin();
		admin.setAdminName(name);
		admin.setAdminPassword(password);
		boolean adminLogin = false;
		if (name != null && !name.equals("")) {
			adminLogin = new AdminService().login(admin);
		}
		if (adminLogin == true)
			resp.sendRedirect("index.jsp");
		resp.sendRedirect("loginError.jsp");
	}

}