package jp.co.openworker.mailsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.google.gson.Gson;

import jp.co.openworker.mailsystem.model.domain.MailHistory;
import jp.co.openworker.mailsystem.model.domain.MstAddress;
import jp.co.openworker.mailsystem.model.domain.MstUser;
//import jp.co.openworker.mailsystem.model.domain.MstAddress;
import jp.co.openworker.mailsystem.model.mapper.MailHistoryMapper;
import jp.co.openworker.mailsystem.model.mapper.MstUserMapper;
//import jp.co.openworker.mailsystem.model.mapper.MstAddressMapper;
import jp.co.openworker.mailsystem.model.session.LoginSession;
import jp.co.openworker.mailsystem.model.form.AddressForm;
import jp.co.openworker.mailsystem.model.form.UserForm;

@Controller
@RequestMapping("/mailsystem/home")
public class HomeController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	MailHistoryMapper mailMapper;
	
	@Autowired
	MstUserMapper userMapper;
	
	@RequestMapping("/")
	public String index(Model m) {
		
		List<MailHistory> mail = mailMapper.select(loginSession.getUserId());
		MstUser user = userMapper.findBySignature(loginSession.getUserId());
		
		m.addAttribute("loginSession", loginSession);
		m.addAttribute("mail", mail);
		m.addAttribute("user", user);
		return "home";
	}

	@RequestMapping("/update")
	@ResponseBody
	public boolean update(@RequestBody UserForm f) {
		MstUser user = new MstUser(f);
		
		int result = userMapper.update(user);
		
		return result > 0;
	}

}