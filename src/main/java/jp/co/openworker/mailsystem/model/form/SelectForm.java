package jp.co.openworker.mailsystem.model.form;

import java.io.Serializable;

public class SelectForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int userId1;
	private String companyName1;
	private int corporation1;
	private String staffName1;
	private String staffMail1;
	private String staffName2;
	private String staffMail2;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId1() {
		return userId1;
	}
	public void setUserId1(int userId1) {
		this.userId1 = userId1;
	}
	public String getCompanyName1() {
		return companyName1;
	}
	public void setCompanyName1(String companyName1) {
		this.companyName1 = companyName1;
	}
	public int getCorporation1() {
		return corporation1;
	}
	public void setCorporation1(int corporation1) {
		this.corporation1 = corporation1;
	}
	public String getStaffName1() {
		return staffName1;
	}
	public void setStaffName1(String staffName1) {
		this.staffName1 = staffName1;
	}
	public String getStaffMail1() {
		return staffMail1;
	}
	public void setStaffMail1(String staffMail1) {
		this.staffMail1 = staffMail1;
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