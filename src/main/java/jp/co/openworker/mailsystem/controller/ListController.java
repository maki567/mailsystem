package jp.co.openworker.mailsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String index(Model m, String companyName) {
		
		List<String> address = addressMapper.selectCompanyName(companyName);
		
		m.addAttribute("loginSession", loginSession);
		m.addAttribute("address", address);
		return "address_list";
	}
	
}