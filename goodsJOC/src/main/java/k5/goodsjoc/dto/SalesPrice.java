package k5.goodsjoc.dto;

public class SalesPrice {
	private String IDX ;
	private String barcode;
	private String salesPrice;
	private String martCode;
	private String ID;
	private String regDate;
	
	private Goods goods;
	private User user;
	private Mart mart;
	
	
	
	public Mart getMart() {
		return mart;
	}



	public void setMart(Mart mart) {
		this.mart = mart;
	}



	public String getIDX() {
		return IDX;
	}



	public void setIDX(String iDX) {
		IDX = iDX;
	}



	public String getBarcode() {
		return barcode;
	}



	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}



	public String getSalesPrice() {
		return salesPrice;
	}



	public void setSalesPrice(String salesPrice) {
		this.salesPrice = salesPrice;
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



	@Override
	public String toString() {
		return "SalesPrice [IDX=" + IDX + ", barcode=" + barcode + ", salesPrice=" + salesPrice + ", martCode="
				+ martCode + ", ID=" + ID + ", regDate=" + regDate + "]";
	}
	

}
