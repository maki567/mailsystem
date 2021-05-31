package jp.co.openworker.mailsystem.model.form;

import java.io.Serializable;

public class MailForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String subject;
	private String toStaff;
	private String toCompany;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getToStaff() {
		return toStaff;
	}
	public void setToStaff(String toStaff) {
		this.toStaff = toStaff;
	}
	public String getToCompany() {
		return toCompany;
	}
	public void setToCompany(String toCompany) {
		this.toCompany = toCompany;
	}
}