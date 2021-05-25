package jp.co.openworker.mailsystem.model.form;

import java.io.Serializable;

public class SelectAddressForm5 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int userId5;
	private String companyName5;
	private int corporation5;
	private String staffName5;
	private String staffMail5;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId5() {
		return userId5;
	}
	public void setUserId5(int userId5) {
		this.userId5 = userId5;
	}
	public String getCompanyName5() {
		return companyName5;
	}
	public void setCompanyName5(String companyName5) {
		this.companyName5 = companyName5;
	}
	public int getCorporation5() {
		return corporation5;
	}
	public void setCorporation5(int corporation5) {
		this.corporation5 = corporation5;
	}
	public String getStaffName5() {
		return staffName5;
	}
	public void setStaffName5(String staffName5) {
		this.staffName5 = staffName5;
	}
	public String getStaffMail5() {
		return staffMail5;
	}
	public void setStaffMail5(String staffMail5) {
		this.staffMail5 = staffMail5;
	}
}