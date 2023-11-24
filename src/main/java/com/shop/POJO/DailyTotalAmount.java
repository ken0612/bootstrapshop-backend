package main.java.com.shop.POJO;

import java.sql.Date;





public class DailyTotalAmount {

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
