package main.java.com.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import main.java.com.shop.model.AdminEntity;
import main.java.com.shop.repository.AdminRepository;

@Component
public class Dataloader implements CommandLineRunner {
	
	
	private final AdminRepository adminRepository;
	
	@Autowired
	public Dataloader(AdminRepository adminRepository) {
		this.adminRepository=adminRepository;
	}
	
	 @Override
	    public void run(String... args) throws Exception {
	        // 在这里添加你的初始化数据逻辑
	        AdminEntity entity = new AdminEntity();
	        entity.setAccount("admin");
	        entity.setPassword("password");
	        entity.setId(1);
	        adminRepository.save(entity);
	    }

}
