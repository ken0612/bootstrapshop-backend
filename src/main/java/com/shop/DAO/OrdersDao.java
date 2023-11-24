package main.java.com.shop.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.shop.POJO.CartDetails;
import main.java.com.shop.POJO.DailyTotalAmount;
import main.java.com.shop.POJO.JsonCartItems;
import main.java.com.shop.POJO.JsonDeliveryInfo;
import main.java.com.shop.model.OrderDetails;
import main.java.com.shop.model.OrdersEntity;
import main.java.com.shop.repository.OrdersRepository;

@Repository
public class OrdersDao {
	
	@Autowired
	OrdersRepository ordersRepository;
	
	public OrdersEntity saveOrder(CartDetails cartDetails) {
		List<JsonCartItems> jsonCartItems = cartDetails.getJsonCartItems();
		JsonDeliveryInfo jsondeliveryInfo= cartDetails.getJsonDeliveryInfo();
		List<OrderDetails> orderDetailsArr = new ArrayList<OrderDetails>();
		OrdersEntity ordersEntity = new OrdersEntity();
		//設定個人資料
		ordersEntity.setCustomerId(jsondeliveryInfo.getCustomId());
		ordersEntity.setCustomerName(jsondeliveryInfo.getDeliFullName());
		ordersEntity.setOrderDate(new java.sql.Date(new Date().getTime()));
		ordersEntity.setTotalAmount(jsondeliveryInfo.getTotalAmount());
		ordersEntity.setPayMethod(jsondeliveryInfo.getPayMethod());
		ordersEntity.setDeliveryMethod(jsondeliveryInfo.getDeliveryMethod());
		ordersEntity.setAddress(jsondeliveryInfo.getDeliAddress());
		ordersEntity.setDeliveryStatus(jsondeliveryInfo.getDeliveryStatus());
		ordersEntity.setPhoneNumber(Integer.parseInt(jsondeliveryInfo.getDeliPhoneNumber()));
		ordersEntity.setEmail(jsondeliveryInfo.getDeliEmail());
		System.out.println(jsondeliveryInfo.getDeliEmail());
		
		//填充購物車內容
		for(JsonCartItems ele  : jsonCartItems) {
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setOrder(ordersEntity);
			orderDetails.setPrice(ele.getProductPrice());
			orderDetails.setProductId(ele.getId());
			orderDetails.setQuantity(ele.getQuantity());
			orderDetails.setProductName(ele.getProductName());
			orderDetails.setProductImg(ele.getProductImg());
			orderDetailsArr.add(orderDetails);
		}
		ordersEntity.setOrderDetails(orderDetailsArr);
		
		
		OrdersEntity result=ordersRepository.save(ordersEntity);
		return result;
	}
	
	public List<OrdersEntity> getAllHistoryOrdersByCustomerId(int customerId){
		return ordersRepository.getOrdersEntityByCustomerId(customerId);
	}
	
	
	public OrdersEntity getOrderDetailByOrderId(int orderId) {
		return ordersRepository.getOrderDetailByOrderId(orderId);
	}
	
	public List<OrdersEntity> getOrdersByDeliveryStatus(Integer status){
		return ordersRepository.getOrdersEntityByDeliveryStatus(status);
	}

	public List<OrdersEntity> getAllOrders(){
		return ordersRepository.findAll();
	}
	
	public List<DailyTotalAmount> getWeeklySalesAmount(java.sql.Date endDate,java.sql.Date startDate){
		
		return ordersRepository.getWeeklySalesAmount(endDate,startDate);
	}
}
