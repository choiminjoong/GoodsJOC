package k5.goodsjoc.dto;

public class Sales {
	private String salesCode;
	private String receiptNum;
	private String salesTotalPrice;
	private String martCode;
	private String ID;
	private String regDate;
	private String canselCheck;
	private String casnselStaff;
	private String canselDate;
	private Goods goods;
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "Sales [salesCode=" + salesCode + ", receiptNum=" + receiptNum + ", salesTotalPrice=" + salesTotalPrice
				+ ", martCode=" + martCode + ", ID=" + ID + ", regDate=" + regDate + ", canselCheck=" + canselCheck
				+ ", casnselStaff=" + casnselStaff + ", canselDate=" + canselDate + "]";
	}
	public String getSalesCode() {
		return salesCode;
	}
	public void setSalesCode(String salesCode) {
		this.salesCode = salesCode;
	}
	public String getReceiptNum() {
		return receiptNum;
	}
	public void setReceiptNum(String receiptNum) {
		this.receiptNum = receiptNum;
	}
	public String getSalesTotalPrice() {
		return salesTotalPrice;
	}
	public void setSalesTotalPrice(String salesTotalPrice) {
		this.salesTotalPrice = salesTotalPrice;
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
	public String getCanselCheck() {
		return canselCheck;
	}
	public void setCanselCheck(String canselCheck) {
		this.canselCheck = canselCheck;
	}
	public String getCasnselStaff() {
		return casnselStaff;
	}
	public void setCasnselStaff(String casnselStaff) {
		this.casnselStaff = casnselStaff;
	}
	public String getCanselDate() {
		return canselDate;
	}
	public void setCanselDate(String canselDate) {
		this.canselDate = canselDate;
	}

}
