package jp.co.openworker.mailsystem.model.domain;

import jp.co.openworker.mailsystem.model.form.SelectForm;

public class SelectAddress {

	private int id;
	private int userId;
	private String companyName;
	private int corporation;
	private String staffName;
	private String staffMail;

	public SelectAddress() {}

	public SelectAddress(SelectForm f) {
		id = f.getId();
		userId = f.getUserId1();
		companyName = f.getCompanyName1();
		corporation = f.getCorporation1();
		staffName = f.getStaffName1();
		staffMail = f.getStaffMail1();
		userId = f.getUserId2();
		companyName = f.getCompanyName2();
		corporation = f.getCorporation2();
		staffName = f.getStaffName2();
		staffMail = f.getStaffMail2();
		userId = f.getUserId3();
		companyName = f.getCompanyName3();
		corporation = f.getCorporation3();
		staffName = f.getStaffName3();
		staffMail = f.getStaffMail3();
		userId = f.getUserId4();
		companyName = f.getCompanyName4();
		corporation = f.getCorporation4();
		staffName = f.getStaffName4();
		staffMail = f.getStaffMail4();
		userId = f.getUserId5();
		companyName = f.getCompanyName5();
		corporation = f.getCorporation5();
		staffName = f.getStaffName5();
		staffMail = f.getStaffMail5();
		userId = f.getUserId6();
		companyName = f.getCompanyName6();
		corporation = f.getCorporation6();
		staffName = f.getStaffName6();
		staffMail = f.getStaffMail6();
		userId = f.getUserId7();
		companyName = f.getCompanyName7();
		corporation = f.getCorporation7();
		staffName = f.getStaffName7();
		staffMail = f.getStaffMail7();
		userId = f.getUserId8();
		companyName = f.getCompanyName8();
		corporation = f.getCorporation8();
		staffName = f.getStaffName8();
		staffMail = f.getStaffMail8();
		userId = f.getUserId9();
		companyName = f.getCompanyName9();
		corporation = f.getCorporation9();
		staffName = f.getStaffName9();
		staffMail = f.getStaffMail9();
		userId = f.getUserId10();
		companyName = f.getCompanyName10();
		corporation = f.getCorporation10();
		staffName = f.getStaffName10();
		staffMail = f.getStaffMail10();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getCorporation() {
		return corporation;
	}
	public void setCorporation(int corporation) {
		this.corporation = corporation;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffMail() {
		return staffMail;
	}
	public void setStaffMail(String staffMail) {
		this.staffMail = staffMail;
	}
	
}