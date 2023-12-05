package main.java.com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import main.java.com.shop.POJO.DailyTotalAmount;
import main.java.com.shop.model.OrdersEntity;



public interface OrdersRepository extends JpaRepository<OrdersEntity,Integer> {
	List<OrdersEntity> getOrdersEntityByCustomerId(int customerId);
	OrdersEntity getOrderDetailByOrderId(int orderId);
	List<OrdersEntity> getOrdersEntityByDeliveryStatus(Integer status);
	
	
	
	@Query(value = "SELECT DATE(order_date) AS orderDay, SUM(total_amount) AS dailySalesTotal " +
	        "FROM orders_entity " +
	        "WHERE order_date BETWEEN :endDate AND :startDate " +
	        "GROUP BY orderDay " +
	        "ORDER BY orderDay", nativeQuery = true)
	List<Object[]> getWeeklySalesAmount(@Param("endDate") java.sql.Date endDate, @Param("startDate") java.sql.Date startDate);
}
