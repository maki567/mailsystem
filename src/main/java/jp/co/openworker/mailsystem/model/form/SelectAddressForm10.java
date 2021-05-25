package jp.co.openworker.mailsystem.model.form;

import java.io.Serializable;

public class SelectAddressForm10 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int userId10;
	private String companyName10;
	private int corporation10;
	private String staffName10;
	private String staffMail10;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId10() {
		return userId10;
	}
	public void setUserId10(int userId10) {
		this.userId10 = userId10;
	}
	public String getCompanyName10() {
		return companyName10;
	}
	public void setCompanyName10(String companyName10) {
		this.companyName10 = companyName10;
	}
	public int getCorporation10() {
		return corporation10;
	}
	public void setCorporation10(int corporation10) {
		this.corporation10 = corporation10;
	}
	public String getStaffName10() {
		return staffName10;
	}
	public void setStaffName10(String staffName10) {
		this.staffName10 = staffName10;
	}
	public String getStaffMail10() {
		return staffMail10;
	}
	public void setStaffMail10(String staffMail10) {
		this.staffMail10 = staffMail10;
	}
}