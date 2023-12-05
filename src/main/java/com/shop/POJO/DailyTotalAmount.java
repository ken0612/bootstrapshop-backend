package main.java.com.shop.POJO;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class DailyTotalAmount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date orderDay;
	private Long dailySalesTotal;
	
	public Date getOrderDay() {
		return orderDay;
	}
	public void setOrderDay(Date orderDay) {
		this.orderDay = orderDay;
	}
	public Long getDailySalesTotal() {
		return dailySalesTotal;
	}
	public void setDailySalesTotal(Long dailySalesTotal) {
		this.dailySalesTotal = dailySalesTotal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
