package main.java.com.shop.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import main.java.com.shop.POJO.CartDetails;
import main.java.com.shop.POJO.DailyTotalAmount;
import main.java.com.shop.model.OrdersEntity;
import main.java.com.shop.model.UsersEntity;
import main.java.com.shop.service.OrdersService;
import main.java.com.shop.service.UsersService;

@Controller
@CrossOrigin(origins="*")
public class OrdersController {
	
	@Autowired
	OrdersService ordersService;
	@Autowired 
	UsersService usersService;
	
	@ResponseBody
	@PostMapping("/submitorder")
	public ResponseEntity<OrdersEntity>  sendbackOrderResult(@RequestBody CartDetails data){
		OrdersEntity result= ordersService.saveOrder(data);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	
	}
	
	@ResponseBody
	@PostMapping("/historyorders")
	public ResponseEntity<List<OrdersEntity>> getHistoryOrders(@RequestBody Map<String,String> data){
		String isLogin = data.get("isLogin");
		System.out.println(isLogin);
		UsersEntity user= usersService.getUserByAccount(isLogin);
		int id= user.getId();
		List<OrdersEntity> result = ordersService.getAllHistoryOrdersByCustomerId(id);
		for(OrdersEntity ele:result) {
			System.out.println(ele);
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@ResponseBody
	@PostMapping("/gethistoryorder")
	public ResponseEntity<OrdersEntity> getHistoryOrderDetail(@RequestBody Map<String,String> data){
		int orderId=Integer.parseInt(data.get("orderid"));
		
		return ResponseEntity.status(HttpStatus.OK).body(ordersService.getOrderDetailByOrderId(orderId));
		
	}
	
	
	@ResponseBody
	@PostMapping("/getorders")
	public ResponseEntity<List<OrdersEntity>> getOrdersByStatus(@RequestBody Map<String, Integer> data){
		return ResponseEntity.status(HttpStatus.OK).body(ordersService.getOrdersByStatus(data));
	}
	
	
	@ResponseBody
	@GetMapping("/getweeklysalesamount")
	public ResponseEntity<List<DailyTotalAmount>> getWeeklyTotalAmount(){
		return ResponseEntity.status(HttpStatus.OK).body(ordersService.getWeeklyOrders());
	}
	
}
