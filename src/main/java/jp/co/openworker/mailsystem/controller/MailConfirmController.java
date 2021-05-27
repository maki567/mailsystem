package jp.co.openworker.mailsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.openworker.mailsystem.model.domain.SelectAddress;
import jp.co.openworker.mailsystem.model.domain.SelectMail;
import jp.co.openworker.mailsystem.model.mapper.SelectAddressMapper;
import jp.co.openworker.mailsystem.model.mapper.SelectMailMapper;
import jp.co.openworker.mailsystem.model.session.LoginSession;

@Controller
@RequestMapping("/mailsystem/mail/confirm")
public class MailConfirmController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	SelectAddressMapper selectMapper;
	
	@Autowired
	SelectMailMapper selectMailMapper;
	
	@RequestMapping("/")
	public String index(Model m) {
		
		List<SelectAddress> select = selectMapper.select(loginSession.getUserId());
		SelectMail mail = selectMailMapper.select(loginSession.getUserId());
		
		m.addAttribute("loginSession", loginSession);
		m.addAttribute("select", select);
		m.addAttribute("mail", mail);
		return "mail_confirm";
	}
}

//この下からメール作成　送信先選択に遷移//







