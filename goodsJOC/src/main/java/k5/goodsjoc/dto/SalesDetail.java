package k5.goodsjoc.dto;

public class SalesDetail {
	private String salesDetailCode;
	private String barcode;
	private String salesCode;
	private String QTY;
	private String totalPrice;
	private String supplyPrice;
	private String VAT;
	
	public String getSalesDetailCode() {
		return salesDetailCode;
	}

	public void setSalesDetailCode(String salesDetailCode) {
		this.salesDetailCode = salesDetailCode;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getSalesCode() {
		return salesCode;
	}

	public void setSalesCode(String salesCode) {
		this.salesCode = salesCode;
	}

	public String getQTY() {
		return QTY;
	}

	public void setQTY(String qTY) {
		QTY = qTY;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getSupplyPrice() {
		return supplyPrice;
	}

	public void setSupplyPrice(String supplyPrice) {
		this.supplyPrice = supplyPrice;
	}

	public String getVAT() {
		return VAT;
	}

	public void setVAT(String vAT) {
		VAT = vAT;
	}

	@Override
	public String toString() {
		return "SalesDetail [salesDetailCode=" + salesDetailCode + ", barcode=" + barcode + ", salesCode=" + salesCode
				+ ", QTY=" + QTY + ", totalPrice=" + totalPrice + ", supplyPrice=" + supplyPrice + ", VAT=" + VAT + "]";
	}
	
}
