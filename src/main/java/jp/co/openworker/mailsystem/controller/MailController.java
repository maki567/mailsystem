package jp.co.openworker.mailsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.openworker.mailsystem.model.domain.SelectAddress;
import jp.co.openworker.mailsystem.model.mapper.SelectAddressMapper;
import jp.co.openworker.mailsystem.model.session.LoginSession;

@Controller
@RequestMapping("/mailsystem/mail")
public class MailController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	SelectAddressMapper selectMapper;
	
	@RequestMapping("/")
	public String index(Model m) {
		
		List<SelectAddress> select = selectMapper.select(loginSession.getUserId());
		
		m.addAttribute("loginSession", loginSession);
		m.addAttribute("select", select);
		return "create_mail";
	}
}

//この下からメール作成　送信先選択に遷移//







