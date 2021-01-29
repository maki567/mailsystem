package jp.co.openworker.mailsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import jp.co.openworker.mailsystem.model.domain.MstUser;
import jp.co.openworker.mailsystem.model.form.UserForm;
import jp.co.openworker.mailsystem.model.mapper.MstUserMapper;
import jp.co.openworker.mailsystem.model.session.LoginSession;

@RestController
@RequestMapping("/mailsystem/auth")
public class AuthController {
	
private Gson gson = new Gson();
	
	@Autowired
	private MstUserMapper userMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	@RequestMapping("/login")
	public String login(@RequestBody UserForm f) {
		MstUser user = userMapper.findByUserNameAndPassword(f.getUserName(), f.getPassword());
		
		if (user != null) {
			loginSession.setTmpUserId(0);
			loginSession.setLogined(true);
			loginSession.setUserId(user.getId());
			loginSession.setUserName(user.getUserName());
			loginSession.setPassword(user.getPassword());
		} else {
			loginSession.setLogined(false);
			loginSession.setUserId(0);
			loginSession.setUserName(null);
			loginSession.setPassword(null);
		}
		
		return gson.toJson(user);
	}
	
	@RequestMapping("/logout")
	public String logout() {
		loginSession.setTmpUserId(0);
		loginSession.setLogined(false);
		loginSession.setUserId(0);
		loginSession.setUserName(null);
		loginSession.setPassword(null);
		
		return "";
	}
	
	@RequestMapping("/resetPassword")
	public String resetPassword(@RequestBody UserForm f) {
		String message = "�p�X���[�h���Đݒ肳��܂����B";
		String newPassword = f.getNewPassword();
		String newPasswordConfirm = f.getNewPasswordConfirm();
		
		MstUser user = userMapper.findByUserNameAndPassword(f.getUserName(), f.getPassword());
		if (user == null) {
			return "���݂̃p�X���[�h������������܂���B";
		}
		
		if (user.getPassword().equals(newPassword)) {
			return "���݂̃p�X���[�h�Ɠ��ꕶ���񂪓��͂���܂����B";
		}
		
		if (!newPassword.equals(newPasswordConfirm)) {
			return "�V�p�X���[�h�Ɗm�F�p�p�X���[�h����v���܂���B";
		}
		// mst_user��loginSession�̃p�X���[�h���X�V����
		userMapper.updatePassword(user.getUserName(), f.getNewPassword());
		loginSession.setPassword(f.getNewPassword());
		
		
		return message;
	}

}