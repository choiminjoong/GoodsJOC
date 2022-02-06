package k5.goodsjoc.dto;

public class Sales {
	private String salesCode;
	private String receiptNum;
	private String salesTotalPrice;
	private String martCode;
	private String id;
	private String regDate;
	private String canselCheck;
	private String canselStaff;
	private String canselDate;

	private User user;
	private Mart mart;

	@Override
	public String toString() {
		return "Sales [salesCode=" + salesCode + ", receiptNum=" + receiptNum + ", salesTotalPrice=" + salesTotalPrice
				+ ", martCode=" + martCode + ", id=" + id + ", regDate=" + regDate + ", canselCheck=" + canselCheck
				+ ", casnselStaff=" + canselStaff + ", canselDate=" + canselDate + ", goods=" + ", user="
				+ user + "]";
	}

	public Mart getMart() {
		return mart;
	}
	
	public void setMart(Mart mart) {
		this.mart = mart;
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

	public String getCanselCheck() {
		return canselCheck;
	}

	public void setCanselCheck(String canselCheck) {
		this.canselCheck = canselCheck;
	}

	public String getCasnselStaff() {
		return canselStaff;
	}

	public void setCasnselStaff(String casnselStaff) {
		this.canselStaff = casnselStaff;
	}

	public String getCanselDate() {
		return canselDate;
	}

	public void setCanselDate(String canselDate) {
		this.canselDate = canselDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
