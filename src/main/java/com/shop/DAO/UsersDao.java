package main.java.com.shop.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.shop.model.UsersEntity;
import main.java.com.shop.repository.UsersRepository;

@Repository
public class UsersDao {

	@Autowired
	UsersRepository usersRepository;
	
	
	
	//取得所有用戶資訊，以list形式回傳
	public List<UsersEntity> getAllUsers() {
		List<UsersEntity> rawData=  usersRepository.findAll();
		List<UsersEntity> allUsers = new ArrayList<UsersEntity>();
		for(UsersEntity ele :rawData) {
			ele.setPassword("");
			allUsers.add(ele);
		}
		
		return allUsers;
	}
	
	//
	public UsersEntity saveUser(UsersEntity user) {
		UsersEntity save= usersRepository.save(user);
		return save;
	}
	
	public Boolean checkAccountDuplicate(String account) {
		return usersRepository.existsByAccount(account);
	}
	
	public Boolean checkEmailDuplicate(String email) {
		return usersRepository.existsByEmail(email);
	}
	
	//用帳號找用戶
	public UsersEntity findByAccount(Map<String,String> data) {
		UsersEntity user =usersRepository.findByAccount(data.get("account"));
		return user;
	}
	
	public int getUserId(Map<String,String> data) {
		UsersEntity user= usersRepository.findByAccount(data.get("account"));
		return user.getId();
	}

	public void updateLastLoginDateByAccount(String account) {
		UsersEntity user = usersRepository.findByAccount(account);
		user.setLastLoginDate(new java.sql.Date(new Date().getTime()));
		usersRepository.save(user);
	}
	
}
