package k5.goodsjoc.dto;

public class Disposal {
	private String disposalCode;
	private String barcode;
	private String shelfCode;
	private String disposalQTY;
	private String martCode;
	private String ID;
	private String regDate;
	
	private Goods goods;
	private User user;
	private Business business;
	
	
	@Override
	public String toString() {
		return "Disposal [disposalCode=" + disposalCode + ", barcode=" + barcode + ", shelfCode=" + shelfCode
				+ ", disposalQTY=" + disposalQTY + ", martCode=" + martCode + ", ID=" + ID + ", regDate=" + regDate
				+ ", goods=" + goods + ", user=" + user + ", business=" + business + "]";
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
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	public String getDisposalCode() {
		return disposalCode;
	}
	public void setDisposalCode(String disposalCode) {
		this.disposalCode = disposalCode;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getShelfCode() {
		return shelfCode;
	}
	public void setShelfCode(String shelfCode) {
		this.shelfCode = shelfCode;
	}
	public String getDisposalQTY() {
		return disposalQTY;
	}
	public void setDisposalQTY(String disposalQTY) {
		this.disposalQTY = disposalQTY;
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
