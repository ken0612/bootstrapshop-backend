package main.java.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.shop.model.OrdersEntity;



public interface OrdersRepository extends JpaRepository<OrdersEntity,Integer> {
	List<OrdersEntity> getOrdersEntityByCustomerId(int customerId);
	OrdersEntity getOrderDetailByOrderId(int orderId);
}
