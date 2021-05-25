package jp.co.openworker.mailsystem.model.form;

import java.io.Serializable;

public class SelectAddressForm8 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int userId8;
	private String companyName8;
	private int corporation8;
	private String staffName8;
	private String staffMail8;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId8() {
		return userId8;
	}
	public void setUserId8(int userId8) {
		this.userId8 = userId8;
	}
	public String getCompanyName8() {
		return companyName8;
	}
	public void setCompanyName8(String companyName8) {
		this.companyName8 = companyName8;
	}
	public int getCorporation8() {
		return corporation8;
	}
	public void setCorporation8(int corporation8) {
		this.corporation8 = corporation8;
	}
	public String getStaffName8() {
		return staffName8;
	}
	public void setStaffName8(String staffName8) {
		this.staffName8 = staffName8;
	}
	public String getStaffMail8() {
		return staffMail8;
	}
	public void setStaffMail8(String staffMail8) {
		this.staffMail8 = staffMail8;
	}
}