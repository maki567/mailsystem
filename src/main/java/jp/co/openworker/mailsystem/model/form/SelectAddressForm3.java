package jp.co.openworker.mailsystem.model.form;

import java.io.Serializable;

public class SelectAddressForm3 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int userId3;
	private String companyName3;
	private int corporation3;
	private String staffName3;
	private String staffMail3;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId3() {
		return userId3;
	}
	public void setUserId3(int userId3) {
		this.userId3 = userId3;
	}
	public String getCompanyName3() {
		return companyName3;
	}
	public void setCompanyName3(String companyName3) {
		this.companyName3 = companyName3;
	}
	public int getCorporation3() {
		return corporation3;
	}
	public void setCorporation3(int corporation3) {
		this.corporation3 = corporation3;
	}
	public String getStaffName3() {
		return staffName3;
	}
	public void setStaffName3(String staffName3) {
		this.staffName3 = staffName3;
	}
	public String getStaffMail3() {
		return staffMail3;
	}
	public void setStaffMail3(String staffMail3) {
		this.staffMail3 = staffMail3;
	}
}