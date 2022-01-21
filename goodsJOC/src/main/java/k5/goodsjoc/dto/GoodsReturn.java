package k5.goodsjoc.dto;

public class GoodsReturn {
	private String returnCode;
	private String barcode;
	private String returnQTY;
	private String returnPrice;
	private String note;
	private String martCode;
	private String ID;
	private String regDate;
	
	private Business business;
	private Goods goods;
	private User user;
	
	@Override
	public String toString() {
		return "GoodsReturn [returnCode=" + returnCode + ", barcode=" + barcode + ", returnQTY=" + returnQTY
				+ ", returnPrice=" + returnPrice + ", note=" + note + ", martCode=" + martCode + ", ID=" + ID
				+ ", regDate=" + regDate + ", business=" + business + ", goods=" + goods + ", user=" + user + "]";
	}
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getReturnQTY() {
		return returnQTY;
	}
	public void setReturnQTY(String returnQTY) {
		this.returnQTY = returnQTY;
	}
	public String getReturnPrice() {
		return returnPrice;
	}
	public void setReturnPrice(String returnPrice) {
		this.returnPrice = returnPrice;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
	
	
	
	
	
	
	

}
