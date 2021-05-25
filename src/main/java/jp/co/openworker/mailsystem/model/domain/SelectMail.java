package jp.co.openworker.mailsystem.model.domain;

import jp.co.openworker.mailsystem.model.form.SelectMailForm;

public class SelectMail {

	private String subject;
	private String text;

	public SelectMail() {}

	public SelectMail(SelectMailForm f) {
		subject = f.getSubject();
		text = f.getText();
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