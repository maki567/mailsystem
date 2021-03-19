package jp.co.openworker.mailsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.openworker.mailsystem.model.domain.MstAddress;
import jp.co.openworker.mailsystem.model.form.AddressForm;
import jp.co.openworker.mailsystem.model.mapper.MstAddressMapper;
import jp.co.openworker.mailsystem.model.session.LoginSession;

@Controller
@RequestMapping("/mailsystem/address")
public class AddressController {
	
	@Autowired
	private MstAddressMapper addressMapper;

	@Autowired
	private LoginSession loginSession;

	
	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("loginSession", loginSession);
		return "register_address";
	}
	
	@RequestMapping("/duplicatedCompanyName")
	@ResponseBody
	public boolean duplicatedCompanyName(@RequestParam String companyName) {
		int count = addressMapper.findCountByCompanyName(companyName);
		return count > 0;
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public boolean register(@RequestBody AddressForm f) {
		MstAddress address = new MstAddress(f);
		
		int count = addressMapper.insert(address);
		
		return count > 0;
		
		
	}
	
}