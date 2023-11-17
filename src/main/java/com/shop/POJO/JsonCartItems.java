package main.java.com.shop.POJO;

public class JsonCartItems {
	
	private int id;
	private String productDesc;
	private String productImg;
	private String productName;
	private int productPrice;
	private int quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "JsonCartItems [id=" + id + ", productDesc=" + productDesc + ", productImg=" + productImg
				+ ", productName=" + productName + ", productPrice=" + productPrice + ", quantity=" + quantity + "]";
	}
	
	
	

}
