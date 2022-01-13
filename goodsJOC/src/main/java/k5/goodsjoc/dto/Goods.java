package k5.goodsjoc.dto;

public class Goods {
	private String barcode;
	private String businessCode;
	private String categoryCode;
	private String goodsName;
	private String weight;
	private String unit;
	private String maker;
	private String taxType;
	private String purchasePrice;
	private String salesPrice;
	private String margin;
	private String uncheckedQTY;
	private String warehouseStock;
	private String showcaseStock;
	private String goodsTotalStock;
	private String martCode;
	private String id;
	private String regDate;
	private String deleteStatus;

	private Business business;
	private GoodsCate goodsCate;
	private User user;

	public String getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	@Override
	public String toString() {
		return "Goods [barcode=" + barcode + ", businessCode=" + businessCode + ", categoryCode=" + categoryCode
				+ ", goodsName=" + goodsName + ", weight=" + weight + ", unit=" + unit + ", maker=" + maker
				+ ", taxType=" + taxType + ", purchasePrice=" + purchasePrice + ", salesPrice=" + salesPrice
				+ ", margin=" + margin + ", uncheckedQTY=" + uncheckedQTY + ", warehouseStock=" + warehouseStock
				+ ", showcaseStock=" + showcaseStock + ", goodsTotalStock=" + goodsTotalStock + ", martCode=" + martCode
				+ ", id=" + id + ", regDate=" + regDate + ", business=" + business + ", goodsCate=" + goodsCate
				+ ", user=" + user + "]";
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getBusinessCode() {
		return businessCode;
	}
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getTaxType() {
		return taxType;
	}
	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}
	public String getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(String salesPrice) {
		this.salesPrice = salesPrice;
	}
	public String getMargin() {
		return margin;
	}
	public void setMargin(String margin) {
		this.margin = margin;
	}
	public String getUncheckedQTY() {
		return uncheckedQTY;
	}
	public void setUncheckedQTY(String uncheckedQTY) {
		this.uncheckedQTY = uncheckedQTY;
	}
	public String getWarehouseStock() {
		return warehouseStock;
	}
	public void setWarehouseStock(String warehouseStock) {
		this.warehouseStock = warehouseStock;
	}
	public String getShowcaseStock() {
		return showcaseStock;
	}
	public void setShowcaseStock(String showcaseStock) {
		this.showcaseStock = showcaseStock;
	}
	public String getGoodsTotalStock() {
		return goodsTotalStock;
	}
	public void setGoodsTotalStock(String goodsTotalStock) {
		this.goodsTotalStock = goodsTotalStock;
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
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	public GoodsCate getGoodsCate() {
		return goodsCate;
	}
	public void setGoodsCate(GoodsCate goodsCate) {
		this.goodsCate = goodsCate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
