package main.java.com.shop.POJO;

public class JsonDeliveryInfo {
	
	private int customId;
	private String deliAddress;
	private String deliFullName;
	private String deliPhoneNumber;
	private String deliEmail;
	private int totalAmount;
	private String payMethod;
	private String deliveryMethod;
	private Integer deliveryStatus;
	
	
	
	
	
	public Integer getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(Integer deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getDeliEmail() {
		return deliEmail;
	}
	public void setDeliEmail(String deliEmail) {
		this.deliEmail = deliEmail;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getCustomId() {
		return customId;
	}
	public void setCustomId(int customId) {
		this.customId = customId;
	}
	public String getDeliAddress() {
		return deliAddress;
	}
	public void setDeliAddress(String deliAddress) {
		this.deliAddress = deliAddress;
	}
	public String getDeliFullName() {
		return deliFullName;
	}
	public void setDeliFullName(String deliFullName) {
		this.deliFullName = deliFullName;
	}
	public String getDeliPhoneNumber() {
		return deliPhoneNumber;
	}
	public void setDeliPhoneNumber(String deliPhoneNumber) {
		this.deliPhoneNumber = deliPhoneNumber;
	}
	@Override
	public String toString() {
		return "JsonDeliveryInfo [customId=" + customId + ", deliAddress=" + deliAddress + ", deliFullName="
				+ deliFullName + ", deliPhoneNumber=" + deliPhoneNumber + "]";
	}
	
	
	

}
