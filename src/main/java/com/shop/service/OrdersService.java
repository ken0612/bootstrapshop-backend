package main.java.com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.shop.DAO.OrdersDao;
import main.java.com.shop.POJO.CartDetails;
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
	
}
