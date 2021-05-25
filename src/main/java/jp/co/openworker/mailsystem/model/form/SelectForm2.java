package jp.co.openworker.mailsystem.model.form;

import java.io.Serializable;

public class SelectForm2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int userId2;
	private String companyName2;
	private int corporation2;
	private String staffName2;
	private String staffMail2;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId2() {
		return userId2;
	}
	public void setUserId2(int userId2) {
		this.userId2 = userId2;
	}
	public String getCompanyName2() {
		return companyName2;
	}
	public void setCompanyName2(String companyName2) {
		this.companyName2 = companyName2;
	}
	public int getCorporation2() {
		return corporation2;
	}
	public void setCorporation2(int corporation2) {
		this.corporation2 = corporation2;
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
}