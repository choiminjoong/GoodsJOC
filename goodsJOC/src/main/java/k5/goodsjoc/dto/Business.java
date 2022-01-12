package k5.goodsjoc.dto;

public class Business {
	private String businessCode;
	private String businessName;
	private String partnerName;
	private String partnerPhone;
	private String registerNum;
	private String businessType;
	private String sectors;
	private String status;
	private String callNum;
	private String address;
	private String fax;
	private String businessStaff;
	private String businessStaffPhone;
	private String businessStaffEmail;
	private String note;
	private String martCode;
	private String id;
	private String regDate;

	@Override
	public String toString() {
		return "Business [businessCode=" + businessCode + ", businessName=" + businessName + ", partnerName="
				+ partnerName + ", partnerPhone=" + partnerPhone + ", registerNum=" + registerNum + ", businessType="
				+ businessType + ", sectors=" + sectors + ", status=" + status + ", callNum=" + callNum + ", address="
				+ address + ", fax=" + fax + ", businessStaff=" + businessStaff + ", businessStaffPhone="
				+ businessStaffPhone + ", businessStaffEmail=" + businessStaffEmail + ", note=" + note + ", martCode="
				+ martCode + ", id=" + id + ", regDate=" + regDate + "]";
	}
	public String getBusinessCode() {
		return businessCode;
	}
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getPartnerPhone() {
		return partnerPhone;
	}
	public void setPartnerPhone(String partnerPhone) {
		this.partnerPhone = partnerPhone;
	}
	public String getRegisterNum() {
		return registerNum;
	}
	public void setRegisterNum(String registerNum) {
		this.registerNum = registerNum;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getSectors() {
		return sectors;
	}
	public void setSectors(String sectors) {
		this.sectors = sectors;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCallNum() {
		return callNum;
	}
	public void setCallNum(String callNum) {
		this.callNum = callNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		fax = fax;
	}
	public String getBusinessStaff() {
		return businessStaff;
	}
	public void setBusinessStaff(String businessStaff) {
		this.businessStaff = businessStaff;
	}
	public String getBusinessStaffPhone() {
		return businessStaffPhone;
	}
	public void setBusinessStaffPhone(String businessStaffPhone) {
		this.businessStaffPhone = businessStaffPhone;
	}
	public String getBusinessStaffEmail() {
		return businessStaffEmail;
	}
	public void setBusinessStaffEmail(String businessStaffEmail) {
		this.businessStaffEmail = businessStaffEmail;
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
