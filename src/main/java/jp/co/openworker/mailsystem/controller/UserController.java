package jp.co.openworker.mailsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.openworker.mailsystem.model.domain.MstUser;
import jp.co.openworker.mailsystem.model.domain.SelectMail;
import jp.co.openworker.mailsystem.model.form.SelectMailForm;
import jp.co.openworker.mailsystem.model.form.UserForm;
import jp.co.openworker.mailsystem.model.mapper.MstUserMapper;
import jp.co.openworker.mailsystem.model.mapper.SelectMailMapper;
import jp.co.openworker.mailsystem.model.session.LoginSession;

@Controller
@RequestMapping("/mailsystem/user")
public class UserController {
	
	@Autowired
	private MstUserMapper userMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private SelectMailMapper selectMailMapper;
	
	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("loginSession", loginSession);
		return "register_user";
	}
	
	@RequestMapping("/duplicatedUserName")
	@ResponseBody
	public boolean duplicatedUserName(@RequestParam String userName) {
		int count = userMapper.findCountByUserName(userName);
		return count > 0;
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public boolean register(@RequestBody UserForm f) {
		MstUser user = new MstUser(f);
		
		int count = userMapper.insert(user);
		
		return count > 0;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public boolean retention(@RequestBody SelectMailForm f) {
		SelectMail mail = new SelectMail(f);
		
		int count = selectMailMapper.insert(mail);
		
		return count > 0;
	}
	
}