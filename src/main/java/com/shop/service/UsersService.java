package main.java.com.shop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.shop.DAO.UsersDao;
import main.java.com.shop.model.UsersEntity;


@Service
public class UsersService {

	
	@Autowired
	UsersDao usersDao;
	
	
	//嘗試進行註冊，Map資料將會以POST形式由前端傳送給後端
	public Map<String, String> tryRegist(Map<String,String> data) {
		Map<String,String> status = new HashMap<>();
		Boolean accountChk=usersDao.checkAccountDuplicate(data.get("account"));
		Boolean emailChk=usersDao.checkEmailDuplicate(data.get("email"));
  		if(accountChk) {
			status.put("account", "帳號已經存在");
		}
  		if(emailChk) {
  			status.put("email","此信箱已經註冊過");
  		}
  		
  		if(accountChk || emailChk) {
  			return status;
  		}else {
  			status.put("isLogin",data.get("account"));
			UsersEntity usersEntity = new UsersEntity();
			usersEntity.setAccount(data.get("account"));
			usersEntity.setPassword(data.get("password"));
			usersEntity.setEmail(data.get("email"));
			usersDao.saveUser(usersEntity);	
		}
		return status;
		
	}
	
	public List<UsersEntity> getAllUsers(){
		List<UsersEntity> allUsers=usersDao.getAllUsers();
		return allUsers;
	}
	
	
	public Map<String, String> valiLogin(Map<String,String> data) {
		String account = data.get("account");
		String password=data.get("password");
		Map<String,String> result= new HashMap<>();
		UsersEntity user = usersDao.findByAccount(data);
		if(user != null) {
			if(user.getPassword().equals(password)) {
				result.put("isLogin",account);
				return result;
			}
		}
		return result;
	}
	
	public UsersEntity getUserByAccount(String account) {
		Map<String,String> accountMap= new HashMap<>();
		accountMap.put("account", account);
		return usersDao.findByAccount(accountMap);
	}
	
}
