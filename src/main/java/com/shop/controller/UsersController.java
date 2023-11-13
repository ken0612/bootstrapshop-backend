package main.java.com.shop.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import main.java.com.shop.model.UsersEntity;
import main.java.com.shop.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	UsersService usersService;
	
	
	@ResponseBody
	@GetMapping("/")
	public String sayHello() {
		return "helloworld";
	}
	
	@PostMapping("/regist")
	public ResponseEntity<Map<String,String>> tryRegist(@RequestBody Map<String,String> data ) {
		System.out.println("後端收到請求了，參數為："+data );
		Map<String, String> CheckResult = usersService.tryRegist(data);
		System.out.println(CheckResult.containsKey("isLogin"));
		if(CheckResult.containsKey("isLogin")) {
			System.out.println("true被執行了");
			return ResponseEntity.status(HttpStatus.OK).body(CheckResult);						
		}else {
			System.out.println("else被執行了");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(CheckResult);			
		}
	}
	
	@PostMapping("/loginvali")
	public ResponseEntity<Map<String,String>> tryLogin(@RequestBody Map<String, String> data){
		Map<String,String> resMap = usersService.valiLogin(data);
		System.out.println(data.get("account")+" "+data.get("password"));
		if(!resMap.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(resMap);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resMap);
	}
	
	@ResponseBody
	@GetMapping("/userinfo")
	public UsersEntity getUserInfoByAccount(@RequestParam("account") String account) {
		System.out.println("/userinfo被呼叫了");
		System.out.println(account);
		return usersService.getUserByAccount(account);
	}
}
