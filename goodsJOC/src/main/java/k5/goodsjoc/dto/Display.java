package k5.goodsjoc.dto;

public class Display {
	private String displayCode;
	private String barcode;
	private String shelfCode;
	private String showcaseCode;
	private String displayQTY;
	private String martCode;
	private String ID;
	private String regDate;
	
	private Goods goods;
	private Warehouse warehouse;
	private Shelf shelf;
	private Showcase showcase;
	private User user;
	
	
	@Override
	public String toString() {
		return "Display [displayCode=" + displayCode + ", barcode=" + barcode + ", shelfCode=" + shelfCode
				+ ", showcaseCode=" + showcaseCode + ", displayQTY=" + displayQTY + ", martCode=" + martCode + ", ID="
				+ ID + ", regDate=" + regDate + ", goods=" + goods + ", warehouse=" + warehouse + ", shelf=" + shelf
				+ ", showcase=" + showcase + ", user=" + user + "]";
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	public Shelf getShelf() {
		return shelf;
	}
	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}
	public Showcase getShowcase() {
		return showcase;
	}
	public void setShowcase(Showcase showcase) {
		this.showcase = showcase;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDisplayCode() {
		return displayCode;
	}
	public void setDisplayCode(String displayCode) {
		this.displayCode = displayCode;
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
	public String getShowcaseCode() {
		return showcaseCode;
	}
	public void setShowcaseCode(String showcaseCode) {
		this.showcaseCode = showcaseCode;
	}
	public String getDisplayQTY() {
		return displayQTY;
	}
	public void setDisplayQTY(String displayQTY) {
		this.displayQTY = displayQTY;
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
