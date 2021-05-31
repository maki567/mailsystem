package jp.co.openworker.mailsystem.model.domain;

import java.sql.Timestamp;

//import jp.co.openworker.mailsystem.model.form.AddressForm;
import jp.co.openworker.mailsystem.model.form.MailForm;
//import jp.co.openworker.mailsystem.model.form.UserForm;

public class MailHistory {

	private int id;
	private int userId;
	private String subject;
	private String toStaff;
	private String toCompany;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public MailHistory() {}

	public MailHistory(MailForm f) {
		userId = f.getUserId();
		subject = f.getSubject();
		toStaff = f.getToStaff();
		toCompany = f.getToCompany();
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
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}