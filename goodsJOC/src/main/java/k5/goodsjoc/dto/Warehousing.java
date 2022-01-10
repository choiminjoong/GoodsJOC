package k5.goodsjoc.dto;

public class Warehousing {
	private String warehousingCode;
	private String barcode;
	private String shelfCode;
	private String warehousingQTY;
	private String warehousingType;
	private String note;
	private String martCode;
	private String ID;
	private String regDate;
	
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
		return "Warehousing [warehousingCode=" + warehousingCode + ", barcode=" + barcode + ", shelfCode=" + shelfCode
				+ ", warehousingQTY=" + warehousingQTY + ", warehousingType=" + warehousingType + ", note=" + note
				+ ", martCode=" + martCode + ", ID=" + ID + ", regDate=" + regDate + "]";
	}
	
	
	
}
