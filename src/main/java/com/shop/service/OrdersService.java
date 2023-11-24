package main.java.com.shop.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.shop.DAO.OrdersDao;
import main.java.com.shop.POJO.CartDetails;
import main.java.com.shop.POJO.DailyTotalAmount;
import main.java.com.shop.model.OrdersEntity;

@Service
public class OrdersService {
	
	@Autowired
	OrdersDao ordersDao;
	
	
	public OrdersEntity saveOrder(CartDetails cartDetails) {
		return ordersDao.saveOrder(cartDetails);
		
	}
	
	public List<OrdersEntity> getAllHistoryOrdersByCustomerId(int customerId){
		return ordersDao.getAllHistoryOrdersByCustomerId(customerId);
	}
	
	public OrdersEntity  getOrderDetailByOrderId(int orderId) {
		return ordersDao.getOrderDetailByOrderId(orderId);
	}
	
	public List<OrdersEntity> getOrdersByStatus(Map<String,Integer> data){
		Integer status =data.get("deliveryStatus");
		if(status==9) {
			return ordersDao.getAllOrders();
		}
		
		return ordersDao.getOrdersByDeliveryStatus(status);
	}
	
	public List<DailyTotalAmount> getWeeklyOrders(){
		LocalDate startDate=LocalDate.now();
		LocalDate endDate=startDate.minusDays(7);
		java.sql.Date sqlStartDate =java.sql.Date.valueOf(startDate);
		java.sql.Date sqlEndDate=java.sql.Date.valueOf(endDate);
		List<DailyTotalAmount> list= ordersDao.getWeeklySalesAmount(sqlEndDate,sqlStartDate);
		
		return list;
	}
	
}
