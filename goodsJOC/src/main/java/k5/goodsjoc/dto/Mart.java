package k5.goodsjoc.dto;

public class Mart {

	private String martCode;
	private String martName;
	private String partnerName;
	private String partnerPhone;
	private String registerNum;
	private String martType;
	private String sectors;
	private String status;
	private String callNum;
	private String address;
	private String FAX;
	private String martStaff;
	private String martStaffPhone;
	private String martStaffEmail;
	private String note;
	private String regDate;
	private String editDate;
	
	@Override
	public String toString() {
		return "Mart [martCode=" + martCode + ", martName=" + martName + ", partnerName=" + partnerName
				+ ", partnerPhone=" + partnerPhone + ", registerNum=" + registerNum + ", martType=" + martType
				+ ", sectors=" + sectors + ", status=" + status + ", callNum=" + callNum + ", address=" + address
				+ ", FAX=" + FAX + ", martStaff=" + martStaff + ", martStaffPhone=" + martStaffPhone
				+ ", martStaffEmail=" + martStaffEmail + ", note=" + note + ", regDate=" + regDate + ", editDate="
				+ editDate + "]";
	}
	public String getMartCode() {
		return martCode;
	}
	public void setMartCode(String martCode) {
		this.martCode = martCode;
	}
	public String getMartName() {
		return martName;
	}
	public void setMartName(String martName) {
		this.martName = martName;
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
	public String getMartType() {
		return martType;
	}
	public void setMartType(String martType) {
		this.martType = martType;
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
	public String getFAX() {
		return FAX;
	}
	public void setFAX(String fAX) {
		FAX = fAX;
	}
	public String getMartStaff() {
		return martStaff;
	}
	public void setMartStaff(String martStaff) {
		this.martStaff = martStaff;
	}
	public String getMartStaffPhone() {
		return martStaffPhone;
	}
	public void setMartStaffPhone(String martStaffPhone) {
		this.martStaffPhone = martStaffPhone;
	}
	public String getMartStaffEmail() {
		return martStaffEmail;
	}
	public void setMartStaffEmail(String martStaffEmail) {
		this.martStaffEmail = martStaffEmail;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getEditDate() {
		return editDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	
}
