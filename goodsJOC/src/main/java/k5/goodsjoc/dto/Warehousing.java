package k5.goodsjoc.dto;

public class Warehousing {
	private String warehousingCode;
	private String barcode;
	private String shelfCode;
	private String warehousingQTY;
	private String warehousingType;
	private String note;
	private String martCode;
	private String id;
	private String regDate;
	
	private Goods goods;
	private Warehouse warehouse;
	private Shelf shelf;
	private User user;
	
	@Override
	public String toString() {
		return "Warehousing [warehousingCode=" + warehousingCode + ", barcode=" + barcode + ", shelfCode=" + shelfCode
				+ ", warehousingQTY=" + warehousingQTY + ", warehousingType=" + warehousingType + ", note=" + note
				+ ", martCode=" + martCode + ", id=" + id + ", regDate=" + regDate + ", goods=" + goods + ", warehouse="
				+ warehouse + ", shelf=" + shelf + ", user=" + user + "]";
	}
	public String getWarehousingCode() {
		return warehousingCode;
	}
	public void setWarehousingCode(String warehousingCode) {
		this.warehousingCode = warehousingCode;
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
	public String getWarehousingQTY() {
		return warehousingQTY;
	}
	public void setWarehousingQTY(String warehousingQTY) {
		this.warehousingQTY = warehousingQTY;
	}
	public String getWarehousingType() {
		return warehousingType;
	}
	public void setWarehousingType(String warehousingType) {
		this.warehousingType = warehousingType;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
}
