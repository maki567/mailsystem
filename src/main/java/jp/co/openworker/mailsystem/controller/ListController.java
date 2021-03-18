package jp.co.openworker.mailsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.openworker.mailsystem.model.domain.MstAddress;
import jp.co.openworker.mailsystem.model.form.SearchForm;
import jp.co.openworker.mailsystem.model.mapper.MstAddressMapper;
import jp.co.openworker.mailsystem.model.session.LoginSession;

@Controller
@RequestMapping("/mailsystem/list")
public class ListController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	MstAddressMapper addressMapper;
	
	@RequestMapping("/")
	public String index(Model m) {
		if (!loginSession.getLogined() && loginSession.getTmpUserId() == 0) {
			int tmpUserId = (int)(Math.random() * 1000000000 * -1);
			while (tmpUserId > -100000000) {
				tmpUserId *= 10;
			}
			loginSession.setTmpUserId(tmpUserId);
		}
		
		List<MstAddress> companyName = addressMapper.find();
		
		m.addAttribute("selected", 0);
		m.addAttribute("companyName", companyName); 
		m.addAttribute("loginSession", loginSession);
		return "address_list";
	}
	
	@RequestMapping("/search")
	public String index(SearchForm f, Model m) {
		List<MstAddress> companyName;

		String keywords = f.getKeywords().replaceAll("Å@", " ").replaceAll("\\s{2,}", " ").trim();

		return "index";
		
	}
	
}