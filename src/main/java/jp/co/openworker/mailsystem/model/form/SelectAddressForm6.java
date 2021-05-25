package jp.co.openworker.mailsystem.model.form;

import java.io.Serializable;

public class SelectAddressForm6 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int userId6;
	private String companyName6;
	private int corporation6;
	private String staffName6;
	private String staffMail6;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId6() {
		return userId6;
	}
	public void setUserId6(int userId6) {
		this.userId6 = userId6;
	}
	public String getCompanyName6() {
		return companyName6;
	}
	public void setCompanyName6(String companyName6) {
		this.companyName6 = companyName6;
	}
	public int getCorporation6() {
		return corporation6;
	}
	public void setCorporation6(int corporation6) {
		this.corporation6 = corporation6;
	}
	public String getStaffName6() {
		return staffName6;
	}
	public void setStaffName6(String staffName6) {
		this.staffName6 = staffName6;
	}
	public String getStaffMail6() {
		return staffMail6;
	}
	public void setStaffMail6(String staffMail6) {
		this.staffMail6 = staffMail6;
	}
}