package main.java.com.shop.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import main.java.com.shop.model.AdminEntity;
import main.java.com.shop.service.AdminService;

@Controller
@CrossOrigin(origins="*")
public class AdminController {
	
	
	@Autowired
	AdminService adminService;
	
	
	
	@ResponseBody
	@PostMapping("/adminlogin")
	public Map<String,String> adminLogin(@RequestBody AdminEntity admin){
		System.out.println(admin);
		return adminService.adminLoginVali(admin);
		
	}

}
