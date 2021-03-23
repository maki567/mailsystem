package jp.co.openworker.mailsystem.model.form;

import java.io.Serializable;

public class MailForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String subject;
	private String toStaff;
	private String toCompany;
	private String dayTime;
	
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
	public String getDayTime() {
		return dayTime;
	}
	public void setDayTime(String dayTime) {
		this.dayTime = dayTime;
	}
}