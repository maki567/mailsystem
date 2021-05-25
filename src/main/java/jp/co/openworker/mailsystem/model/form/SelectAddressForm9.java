package jp.co.openworker.mailsystem.model.form;

import java.io.Serializable;

public class SelectAddressForm9 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int userId9;
	private String companyName9;
	private int corporation9;
	private String staffName9;
	private String staffMail9;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId9() {
		return userId9;
	}
	public void setUserId9(int userId9) {
		this.userId9 = userId9;
	}
	public String getCompanyName9() {
		return companyName9;
	}
	public void setCompanyName9(String companyName9) {
		this.companyName9 = companyName9;
	}
	public int getCorporation9() {
		return corporation9;
	}
	public void setCorporation9(int corporation9) {
		this.corporation9 = corporation9;
	}
	public String getStaffName9() {
		return staffName9;
	}
	public void setStaffName9(String staffName9) {
		this.staffName9 = staffName9;
	}
	public String getStaffMail9() {
		return staffMail9;
	}
	public void setStaffMail9(String staffMail9) {
		this.staffMail9 = staffMail9;
	}
}