package jp.co.openworker.mailsystem.model.form;

import java.io.Serializable;

public class SelectMailForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String subject;
	private String text;

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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}