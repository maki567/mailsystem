package jp.co.openworker.mailsystem.model.form;

import java.io.Serializable;

public class SelectForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int userId;
	private String companyName;
	private int corporation;
	private String staffName;
	private String staffMail;
	
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
}