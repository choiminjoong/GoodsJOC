package k5.goodsjoc.dto;

public class OrderDetail {
	private String orderDetailCode;
	private String orderCode;
	private String barcode;
	private String purchasePrice;
	private String qty;
	private String totalPrice;
	private String supplyPrice;
	private String vat;
	
	private Order order;
	private Goods goods;

	@Override
	public String toString() {
		return "OrderDetail [orderDetailCode=" + orderDetailCode + ", orderCode=" + orderCode + ", barcode=" + barcode
				+ ", purchasePrice=" + purchasePrice + ", qty=" + qty + ", totalPrice=" + totalPrice + ", supplyPrice="
				+ supplyPrice + ", vat=" + vat + ", order=" + order + ", goods=" + goods + "]";
	}

	public String getOrderDetailCode() {
		return orderDetailCode;
	}

	public void setOrderDetailCode(String orderDetailCode) {
		this.orderDetailCode = orderDetailCode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

}
