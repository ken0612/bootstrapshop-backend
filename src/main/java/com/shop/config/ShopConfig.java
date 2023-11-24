package main.java.com.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import main.java.com.shop.DAO.UsersDao;


@Configuration
public class ShopConfig {
	
//	@Bean
//	public UsersEntity addUsersEntity() {
//		System.out.println("將UsersEntity加入組件");
//		return new UsersEntity();
//	}
//	
//	@Bean
//	public UsersService addUsersService() {
//		System.out.println("將UsersService加入組件");
//		return new UsersService();
//	}
	@Bean 
	public UsersDao addUsersDao() {
		return new UsersDao();
	}

	

}
