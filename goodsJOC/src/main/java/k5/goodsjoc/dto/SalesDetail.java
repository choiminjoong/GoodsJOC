package k5.goodsjoc.dto;

public class SalesDetail {
	private String salesDetailCode;
	private String barcode;
	private String salesCode;
	private String qty;
	private String totalPrice;
	private String supplyPrice;
	private String vat;
	
	private Goods goods;

	@Override
	public String toString() {
		return "SalesDetail [salesDetailCode=" + salesDetailCode + ", barcode=" + barcode + ", salesCode=" + salesCode
				+ ", qty=" + qty + ", totalPrice=" + totalPrice + ", supplyPrice=" + supplyPrice + ", vat=" + vat
				+ ", goods=" + goods + "]";
	}

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

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
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

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
}
