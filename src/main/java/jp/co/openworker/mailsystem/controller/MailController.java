package jp.co.openworker.mailsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.openworker.mailsystem.model.domain.SelectAddress;
import jp.co.openworker.mailsystem.model.domain.SelectMail;
import jp.co.openworker.mailsystem.model.form.SelectMailForm;
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
	
	@RequestMapping("/")
	public String index(Model m) {
		
		List<SelectAddress> select = selectAddressMapper.select(loginSession.getUserId());
		SelectMail mail = selectMailMapper.select(loginSession.getUserId());
		
		m.addAttribute("loginSession", loginSession);
		m.addAttribute("select", select);
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
	
	@RequestMapping("/send_confirm")
	@ResponseBody
	public boolean send(@RequestBody SelectMailForm f) {
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
	
}

//この下からメール作成　送信先選択に遷移//







