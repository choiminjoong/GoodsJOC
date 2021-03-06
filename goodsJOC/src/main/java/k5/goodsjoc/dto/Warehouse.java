package k5.goodsjoc.dto;

public class Warehouse {
	private String warehouseCode;
	private String warehouseName;
	private String warehouseType;
	private String totalStock;
	private String martCode;
	private String id;
	private String regDate;

	@Override
	public String toString() {
		return "Warehouse [warehouseCode=" + warehouseCode + ", warehouseName=" + warehouseName + ", warehouseType="
				+ warehouseType + ", totalStock=" + totalStock + ", martCode=" + martCode + ", id=" + id + ", regDate="
				+ regDate + "]";
	}
	public String getWarehouseCode() {
		return warehouseCode;
	}
	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getWarehouseType() {
		return warehouseType;
	}
	public void setWarehouseType(String warehouseType) {
		this.warehouseType = warehouseType;
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
