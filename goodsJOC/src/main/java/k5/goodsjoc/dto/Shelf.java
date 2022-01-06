package k5.goodsjoc.dto;

public class Shelf {
	private String shelfCode;
	private String warehouseCode;
	private String shelfName;
	private String totalStock;
	private String martCode;
	private String ID;
	private String regDate;
	
	@Override
	public String toString() {
		return "Shelf [shelfCode=" + shelfCode + ", warehouseCode=" + warehouseCode + ", shelfName=" + shelfName
				+ ", totalStock=" + totalStock + ", martCode=" + martCode + ", ID=" + ID + ", regDate=" + regDate + "]";
	}
	public String getShelfCode() {
		return shelfCode;
	}
	public void setShelfCode(String shelfCode) {
		this.shelfCode = shelfCode;
	}
	public String getWarehouseCode() {
		return warehouseCode;
	}
	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
	public String getShelfName() {
		return shelfName;
	}
	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}
	public String getTotalStock() {
		return totalStock;
	}
	public void setTotalStock(String totalStock) {
		this.totalStock = totalStock;
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
