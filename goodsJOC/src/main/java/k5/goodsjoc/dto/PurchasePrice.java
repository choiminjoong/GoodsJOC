package k5.goodsjoc.dto;

public class PurchasePrice {
	private String idx ;
	private String barcode;
	private String purchasePrice;
	private String martCode;
	private String id;
	private String regDate;
	
	private Goods goods;
	private User user;
	private Mart mart;

	@Override
	public String toString() {
		return "PurchasePrice [idx=" + idx + ", barcode=" + barcode + ", purchasePrice=" + purchasePrice + ", martCode="
				+ martCode + ", id=" + id + ", regDate=" + regDate + ", goods=" + goods + ", user=" + user + ", mart="
				+ mart + "]";
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
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
	public Mart getMart() {
		return mart;
	}
	public void setMart(Mart mart) {
		this.mart = mart;
	}
}
