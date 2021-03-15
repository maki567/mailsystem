package jp.co.openworker.mailsystem.model.domain;

import java.sql.Timestamp;

import jp.co.openworker.mailsystem.model.form.AddressForm;

public class MstAddress {

	private int id;
	private String companyName;
	private String companyAddress;
	private int corporation;
	private String companyNumber;
	private String staffName1;
	private String staffMail1;
	private String staffNumber1;
	private String staffName2;
	private String staffMail2;
	private String staffNumber2;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public MstAddress() {}

	public MstAddress(AddressForm f) {
		companyName = f.getCompanyName();
		companyAddress = f.getCompanyAddress();
		corporation = f.getCorporation();
		companyNumber = f.getCompanyNumber();
		staffName1 = f.getStaffName1();
		staffMail1 = f.getStaffMail1();
		staffNumber1 = f.getStaffNumber1();
		staffName2 = f.getStaffName2();
		staffMail2 = f.getStaffMail2();
		staffNumber2 = f.getStaffNumber2();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public int getCorporation() {
		return corporation;
	}
	public void setCorporation(int corporation) {
		this.corporation = corporation;
	}
	public String getCompanyNumber() {
		return companyNumber;
	}
	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}
	public String getStaffName1() {
		return staffName1;
	}
	public void setStaffName1(String staffName1) {
		this.staffName1 = staffName1;
	}
	public String getStaffMail1() {
		return staffMail1;
	}
	public void setStaffMail1(String staffMail1) {
		this.staffMail1 = staffMail1;
	}
	public String getStaffNumber1() {
		return staffNumber1;
	}
	public void setStaffNumber1(String staffNumber1) {
		this.staffNumber1 = staffNumber1;
	}
	public String getStaffName2() {
		return staffName2;
	}
	public void setStaffName2(String staffName2) {
		this.staffName2 = staffName2;
	}
	public String getStaffMail2() {
		return staffMail2;
	}
	public void setStaffMail2(String staffMail2) {
		this.staffMail2 = staffMail2;
	}
	public String getStaffNumber2() {
		return staffNumber2;
	}
	public void setStaffNumber2(String staffNumber2) {
		this.staffNumber2 = staffNumber2;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}