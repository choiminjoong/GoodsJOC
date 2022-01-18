package k5.goodsjoc.dto;

public class Order {
	private String orderCode;
	private String businessCode;
	private String orderNum;
	private String deliveryDate;
	private String state;
	private String purchaseDate;
	private String martCode;
	private String id;
	private String regDate;
	private String totalOrderPrice;
	
	private Business business;
	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTotalOrderPrice() {
		return totalOrderPrice;
	}
	public void setTotalOrderPrice(String totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getBusinessCode() {
		return businessCode;
	}
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getMartCode() {
		return martCode;
	}
	public void setMartCode(String martCode) {
		this.martCode = martCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	@Override
	public String toString() {
		return "Order [orderCode=" + orderCode + ", businessCode=" + businessCode + ", orderNum=" + orderNum
				+ ", deliveryDate=" + deliveryDate + ", state=" + state + ", purchaseDate=" + purchaseDate
				+ ", martCode=" + martCode + ", id=" + id + ", regDate=" + regDate + ", business=" + business + "]";
	}
		
	
	

}
