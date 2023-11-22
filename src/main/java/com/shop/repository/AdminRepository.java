package main.java.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.shop.model.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity,Integer> {
	AdminEntity findByAccount(String account);
}
