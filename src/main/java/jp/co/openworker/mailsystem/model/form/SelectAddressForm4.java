package jp.co.openworker.mailsystem.model.form;

import java.io.Serializable;

public class SelectAddressForm4 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int userId4;
	private String companyName4;
	private int corporation4;
	private String staffName4;
	private String staffMail4;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId4() {
		return userId4;
	}
	public void setUserId4(int userId4) {
		this.userId4 = userId4;
	}
	public String getCompanyName4() {
		return companyName4;
	}
	public void setCompanyName4(String companyName4) {
		this.companyName4 = companyName4;
	}
	public int getCorporation4() {
		return corporation4;
	}
	public void setCorporation4(int corporation4) {
		this.corporation4 = corporation4;
	}
	public String getStaffName4() {
		return staffName4;
	}
	public void setStaffName4(String staffName4) {
		this.staffName4 = staffName4;
	}
	public String getStaffMail4() {
		return staffMail4;
	}
	public void setStaffMail4(String staffMail4) {
		this.staffMail4 = staffMail4;
	}
}