package jp.co.openworker.mailsystem.model.domain;

import java.sql.Timestamp;

import jp.co.openworker.mailsystem.model.form.UserForm;

public class MstUser {

	private int id;
	private String userName;
	private String password;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public MstUser() {}

	public MstUser(UserForm f) {
		userName = f.getUserName();
		password = f.getPassword();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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