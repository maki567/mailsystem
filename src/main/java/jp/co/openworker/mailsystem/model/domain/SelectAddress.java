package jp.co.openworker.mailsystem.model.domain;

import java.sql.Timestamp;

import jp.co.openworker.mailsystem.model.form.SelectForm;

public class SelectAddress {

	private int id;
	private int userId;
	private String companyName;
	private int corporation;
	private String staffName;
	private String staffMail;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public SelectAddress() {}

	public SelectAddress(SelectForm f) {
		id = f.getId();
		userId = f.getUserId();
		companyName = f.getCompanyName();
		corporation = f.getCorporation();
		staffName = f.getStaffName();
		staffMail = f.getStaffMail();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getCorporation() {
		return corporation;
	}
	public void setCorporation(int corporation) {
		this.corporation = corporation;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffMail() {
		return staffMail;
	}
	public void setStaffMail(String staffMail) {
		this.staffMail = staffMail;
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