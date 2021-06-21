package jp.co.openworker.mailsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.openworker.mailsystem.model.domain.MailHistory;
import jp.co.openworker.mailsystem.model.domain.MstAddress;
import jp.co.openworker.mailsystem.model.domain.MstUser;
import jp.co.openworker.mailsystem.model.domain.SelectAddress;
import jp.co.openworker.mailsystem.model.domain.SelectMail;
import jp.co.openworker.mailsystem.model.form.MailForm;
import jp.co.openworker.mailsystem.model.mapper.MailHistoryMapper;
import jp.co.openworker.mailsystem.model.mapper.MstAddressMapper;
import jp.co.openworker.mailsystem.model.mapper.MstUserMapper;
import jp.co.openworker.mailsystem.model.mapper.SelectAddressMapper;
import jp.co.openworker.mailsystem.model.mapper.SelectMailMapper;
import jp.co.openworker.mailsystem.model.session.LoginSession;

@Controller
@RequestMapping("/mailsystem/test")
public class TestController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	SelectAddressMapper selectAddressMapper;
	
	@Autowired
	SelectMailMapper selectMailMapper;
	
	@Autowired
	MailHistoryMapper mailHistoryMapper;
	
	@Autowired
	MstUserMapper userMapper;
	
	@Autowired
	MstAddressMapper addressMapper;
	
	@RequestMapping("/")
	public String index(Model m) {
		
		List<SelectAddress> select = selectAddressMapper.select(loginSession.getUserId());
		SelectMail mail = selectMailMapper.select(loginSession.getUserId());
		MstUser user = userMapper.findBySignature(loginSession.getUserId());
		List<MstAddress> address = addressMapper.select(loginSession.getUserId());
		
		m.addAttribute("address", address);
		m.addAttribute("loginSession", loginSession);
		m.addAttribute("select", select);
		m.addAttribute("mail", mail);
		m.addAttribute("user", user);
		return "test";
	}
	
	@RequestMapping("/record")
	@ResponseBody
	public boolean record(@RequestBody MailForm f) {
		MailHistory history = new MailHistory(f);
		
		int count = mailHistoryMapper.insert(history);
		
		return count > 0;
	}
}