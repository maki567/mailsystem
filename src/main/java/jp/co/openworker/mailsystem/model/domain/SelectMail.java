package jp.co.openworker.mailsystem.model.domain;

import jp.co.openworker.mailsystem.model.form.SelectMailForm;

public class SelectMail {

	private int userId;
	private String subject;
	private String text;

	public SelectMail() {}

	public SelectMail(SelectMailForm f) {
		userId = f.getUserId();
		subject = f.getSubject();
		text = f.getText();
	}

	public int getUserId() {
		return userId;
	}
	public void userId(int userId) {
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