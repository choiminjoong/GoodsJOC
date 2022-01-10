package k5.goodsjoc.dto;

public class Order {
	private String orderCode;
	private String businessCode;
	private String orderNum;
	private String deliveryDate;
	private String state;
	private String purchaseDate;
	private String martCode;
	private String ID;
	private String regDate;
	private Business business;
		
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
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
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Order [orderCode=" + orderCode + ", businessCode=" + businessCode + ", orderNum=" + orderNum
				+ ", deliveryDate=" + deliveryDate + ", state=" + state + ", purchaseDate=" + purchaseDate
				+ ", martCode=" + martCode + ", ID=" + ID + ", regDate=" + regDate + "]";
	}
	

}
