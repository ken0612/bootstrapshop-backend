package main.java.com.shop.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.shop.model.AdminEntity;
import main.java.com.shop.repository.AdminRepository;

@Repository
public class AdminDao {
	
	
	@Autowired
	AdminRepository adminRepository;
	
	public AdminEntity findAdminByAccount(String account) {
		return adminRepository.findByAccount(account);
	}
}
