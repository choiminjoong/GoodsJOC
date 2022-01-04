package k5.goodsjoc.dto;

public class GoodsCate {
	private String categoryCode;
	private String categoryName;
	private String martCode;
	private String ID;
	private String regDate;
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	@Override
	public String toString() {
		return "GoodsCate [categoryCode=" + categoryCode + ", categoryName=" + categoryName + ", martCode=" + martCode
				+ ", ID=" + ID + ", regDate=" + regDate + "]";
	}
	
	
}
