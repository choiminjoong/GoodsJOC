package k5.goodsjoc.dto;

public class Purchase {
	private String martCode;
	private String martName;
	private String businessName;
	private String purchaseDate;
	private String orderNum;
	private String goodsName;
	private String purchasePrice;
	private String QTY;
	private String totalPrice;
	private String supplyPrice;
	private String VAT;
	
	
	@Override
	public String toString() {
		return "Purchase [martCode=" + martCode + ", martName=" + martName + ", businessName=" + businessName
				+ ", purchaseDate=" + purchaseDate + ", orderNum=" + orderNum + ", goodsName=" + goodsName
				+ ", purchasePrice=" + purchasePrice + ", QTY=" + QTY + ", totalPrice=" + totalPrice + ", supplyPrice="
				+ supplyPrice + ", VAT=" + VAT + "]";
	}
	
	public String getMartCode() {
		return martCode;
	}
	public void setMartCode(String martCode) {
		this.martCode = martCode;
	}
	public String getMartName() {
		return martName;
	}
	public void setMartName(String martName) {
		this.martName = martName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getQTY() {
		return QTY;
	}
	public void setQTY(String QTY) {
		this.QTY = QTY;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getSupplyPrice() {
		return supplyPrice;
	}
	public void setSupplyPrice(String supplyPrice) {
		this.supplyPrice = supplyPrice;
	}
	public String getVAT() {
		return VAT;
	}
	public void setVAT(String VAT) {
		this.VAT = VAT;
	}
	
	
	

}
