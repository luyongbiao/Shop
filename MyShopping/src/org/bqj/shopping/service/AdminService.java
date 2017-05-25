package org.bqj.shopping.service;

import java.util.List;

import org.bqj.shopping.dao.AdminDAO;
import org.bqj.shopping.dao.impl.AdminDAOImpl;
import org.bqj.shopping.entity.Admin;

public class AdminService {
	private AdminDAO adminDAO;
	
	public AdminService() {
		this.adminDAO = new AdminDAOImpl();
	}
	
	
	public boolean login(Admin admin) {
		List<Admin> admins = this.adminDAO.findAll();
		for (Admin a : admins) {
			if (a.getAdminName().equals(admin.getAdminName())
					&& a.getAdminPassword().equals(admin.getAdminPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public void register(Admin admin) {
		this.adminDAO.save(admin);
	}
	
	public void delete(Integer id) {
		this.adminDAO.removeOne(id);
	}
	
	public void update(Admin admin) {
		this.adminDAO.modify(admin);
	}
}
