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
	
	
	
	@Query("SELECT \n"
			+ "new main.java.com.shop.POJO.DailyTotalAmount(   DATE(orderDate) AS orderDay,\n"
			+ "    SUM(totalAmount) AS dailySalesTotal)\n"
			+ "FROM\n"
			+ "    OrdersEntity \n"
			+ "WHERE\n"
			+ "    orderDate BETWEEN :endDate AND :startDate \n"
			+ "GROUP BY\n"
			+ "    orderDay\n"
			+ "ORDER BY\n"
			+ "    orderDay")
	List<DailyTotalAmount> getWeeklySalesAmount(@Param("endDate") java.sql.Date endDate,@Param("startDate") java.sql.Date startDate);
}
