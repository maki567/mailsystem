package jp.co.openworker.mailsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.openworker.mailsystem.model.domain.MailHistory;
import jp.co.openworker.mailsystem.model.domain.MstUser;
import jp.co.openworker.mailsystem.model.domain.SelectAddress;
import jp.co.openworker.mailsystem.model.domain.SelectMail;
import jp.co.openworker.mailsystem.model.form.MailForm;
import jp.co.openworker.mailsystem.model.form.SelectMailForm;
import jp.co.openworker.mailsystem.model.mapper.MailHistoryMapper;
import jp.co.openworker.mailsystem.model.mapper.MstUserMapper;
import jp.co.openworker.mailsystem.model.mapper.SelectAddressMapper;
import jp.co.openworker.mailsystem.model.mapper.SelectMailMapper;
import jp.co.openworker.mailsystem.model.session.LoginSession;

@Controller
@RequestMapping("/mailsystem/mail")
public class MailController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	SelectAddressMapper selectAddressMapper;
	
	@Autowired
	SelectMailMapper selectMailMapper;
	
	@Autowired
	MstUserMapper userMapper;
	
	@Autowired
	MailHistoryMapper mailHistoryMapper;
	
	@RequestMapping("/")
	public String index(Model m) {
		
		List<SelectAddress> select = selectAddressMapper.select(loginSession.getUserId());
		MstUser user = userMapper.findBySignature(loginSession.getUserId());
		SelectMail mail = selectMailMapper.select(loginSession.getUserId());
		
		m.addAttribute("loginSession", loginSession);
		m.addAttribute("select", select);
		m.addAttribute("user", user);
		m.addAttribute("mail", mail);
		return "create_mail";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public boolean delete() {
		int userId = loginSession.getUserId();
		int result = selectMailMapper.delete(userId);
		return result > 0;
	}
	
	@RequestMapping("/retention")
	@ResponseBody
	public boolean retention(@RequestBody SelectMailForm f) {
		SelectMail mail = new SelectMail(f);
		
		int count = selectMailMapper.insert(mail);
		
		return count > 0;
	}
	
	@RequestMapping("/release")
	@ResponseBody
	public boolean release() {
		int userId = loginSession.getUserId();
		int result = selectAddressMapper.release(userId);
		return result > 0;
	}
	
	@RequestMapping("/record")
	@ResponseBody
	public boolean record(@RequestBody MailForm f) {
		MailHistory history = new MailHistory(f);
		
		int count = mailHistoryMapper.insert(history);
		
		return count > 0;
	}
}

