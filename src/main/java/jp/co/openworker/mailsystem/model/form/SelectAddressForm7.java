package jp.co.openworker.mailsystem.model.form;

import java.io.Serializable;

public class SelectAddressForm7 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int userId7;
	private String companyName7;
	private int corporation7;
	private String staffName7;
	private String staffMail7;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId7() {
		return userId7;
	}
	public void setUserId7(int userId7) {
		this.userId7 = userId7;
	}
	public String getCompanyName7() {
		return companyName7;
	}
	public void setCompanyName7(String companyName7) {
		this.companyName7 = companyName7;
	}
	public int getCorporation7() {
		return corporation7;
	}
	public void setCorporation7(int corporation7) {
		this.corporation7 = corporation7;
	}
	public String getStaffName7() {
		return staffName7;
	}
	public void setStaffName7(String staffName7) {
		this.staffName7 = staffName7;
	}
	public String getStaffMail7() {
		return staffMail7;
	}
	public void setStaffMail7(String staffMail7) {
		this.staffMail7 = staffMail7;
	}
}