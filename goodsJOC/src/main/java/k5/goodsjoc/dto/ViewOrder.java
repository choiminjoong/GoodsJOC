package k5.goodsjoc.dto;

public class ViewOrder {
	private String martCode;
	private String martName;
	private String businessName;
	private String regDate;
	private String partnerPhone;
	private String businessStaffEmail;
	private String orderNum;
	private String barcode;
	private String goodsName;
	private String purchasePrice;
	private String QTY;
	private String totalPrice;
	private String supplyPrice;
	private String VAT;
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getPartnerPhone() {
		return partnerPhone;
	}
	public void setPartnerPhone(String partnerPhone) {
		this.partnerPhone = partnerPhone;
	}
	public String getBusinessStaffEmail() {
		return businessStaffEmail;
	}
	public void setBusinessStaffEmail(String businessStaffEmail) {
		this.businessStaffEmail = businessStaffEmail;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
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
	public void setQTY(String qTY) {
		QTY = qTY;
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
	public void setVAT(String vAT) {
		VAT = vAT;
	}
	@Override
	public String toString() {
		return "ViewOrder [martCode=" + martCode + ", martName=" + martName + ", businessName=" + businessName
				+ ", regDate=" + regDate + ", partnerPhone=" + partnerPhone + ", businessStaffEmail="
				+ businessStaffEmail + ", orderNum=" + orderNum + ", barcode=" + barcode + ", goodsName=" + goodsName
				+ ", purchasePrice=" + purchasePrice + ", QTY=" + QTY + ", totalPrice=" + totalPrice + ", supplyPrice="
				+ supplyPrice + ", VAT=" + VAT + "]";
	}
	
}