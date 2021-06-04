package jp.co.openworker.mailsystem.model.domain;

import java.sql.Timestamp;

import jp.co.openworker.mailsystem.model.form.UserForm;

public class MstUser {

	private int id;
	private String userName;
	private String clientId;
	private String password;
	private String signature;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public MstUser() {}

	public MstUser(UserForm f) {
		id = f.getId();
		userName = f.getUserName();
		clientId = f.getClientId();
		password = f.getPassword();
		signature = f.getSignature();
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
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
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