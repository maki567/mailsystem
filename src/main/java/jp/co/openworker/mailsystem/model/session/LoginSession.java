package jp.co.openworker.mailsystem.model.session;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class LoginSession implements Serializable {
	private static final long serialVersionUID = -4505629762363906244L;

	private int userId;
	private int tmpUserId;
	private String mailAddress;
	private String password;
	private boolean logined;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTmpUserId() {
		return tmpUserId;
	}
	public void setTmpUserId(int tmpUserId) {
		this.tmpUserId = tmpUserId;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getLogined() {
		return this.logined;
	}
	public void setLogined(boolean logined) {
		this.logined = logined;
	}

}