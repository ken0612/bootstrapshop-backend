package main.java.com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.shop.model.UsersEntity;



//繼承Jparepository來完成對資料庫的操作，泛型後面需要添加要操控的實體類，以及該類的主鍵資料類型
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
	Boolean existsByAccount(String account);
	Boolean existsByEmail(String email);
	UsersEntity findByAccount(String account);
	
}
