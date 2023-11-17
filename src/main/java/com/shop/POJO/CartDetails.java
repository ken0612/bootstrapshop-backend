package main.java.com.shop.POJO;

import java.util.List;

public class CartDetails {
	
	private List<JsonCartItems> jsonCartItems;
	private JsonDeliveryInfo jsonDeliveryInfo;
	
	public List<JsonCartItems> getJsonCartItems() {
		return jsonCartItems;
	}
	public void setJsonCartItems(List<JsonCartItems> jsonCartItems) {
		this.jsonCartItems = jsonCartItems;
	}
	public JsonDeliveryInfo getJsonDeliveryInfo() {
		return jsonDeliveryInfo;
	}
	public void setJsonDeliveryInfo(JsonDeliveryInfo jsonDeliveryInfo) {
		this.jsonDeliveryInfo = jsonDeliveryInfo;
	}
	@Override
	public String toString() {
		return "CartDetails [jsonCartItems=" + jsonCartItems + ", jsonDeliveryInfo=" + jsonDeliveryInfo + "]";
	}

	
	
	
}
