package k5.goodsjoc.dto;

public class Showcase {
	private String showcaseCode;
	private String showcasePlace;
	private String stock;
	private String martCode;
	private String id;
	private String regDate;

	@Override
	public String toString() {
		return "Showcase [showcaseCode=" + showcaseCode + ", showcasePlace=" + showcasePlace + ", stock=" + stock
				+ ", martCode=" + martCode + ", id=" + id + ", regDate=" + regDate + "]";
	}
	public String getShowcaseCode() {
		return showcaseCode;
	}
	public void setShowcaseCode(String showcaseCode) {
		this.showcaseCode = showcaseCode;
	}
	public String getShowcasePlace() {
		return showcasePlace;
	}
	public void setShowcasePlace(String showcasePlace) {
		this.showcasePlace = showcasePlace;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
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
}
