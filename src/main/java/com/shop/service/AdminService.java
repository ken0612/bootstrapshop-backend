package main.java.com.shop.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.shop.DAO.AdminDao;
import main.java.com.shop.model.AdminEntity;

@Service
public class AdminService {
	
	@Autowired
	AdminDao adminDao;
	
	
	public Map<String,String> adminLoginVali(AdminEntity admin){
		Map<String,String> token = new HashMap<>();
		AdminEntity adminInfo= adminDao.findAdminByAccount(admin.getAccount());
		
		if(adminInfo==null){
			token.put("isAdminLogin","loginFailure");
			return token;
		}
		
		if(adminInfo.getPassword().equals(admin.getPassword())) {
			System.out.println("hahaworld");
			token.put("isAdminLogin",adminInfo.getAccount());
		}
		return token;
	}
	
	
}
