package jp.co.openworker.mailsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.openworker.mailsystem.model.domain.MstAddress;
import jp.co.openworker.mailsystem.model.domain.SelectAddress;
import jp.co.openworker.mailsystem.model.form.SelectForm;
import jp.co.openworker.mailsystem.model.mapper.MstAddressMapper;
import jp.co.openworker.mailsystem.model.mapper.SelectAddressMapper;
import jp.co.openworker.mailsystem.model.session.LoginSession;

@Controller
@RequestMapping("/mailsystem/selectStaff")
public class SelectStaffController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	MstAddressMapper addressMapper;
	
	@Autowired
	SelectAddressMapper selectAddressMapper;
	
	@RequestMapping("/{id}")
	public String index(@PathVariable("id") int id, Model m) {
		MstAddress address = addressMapper.findById(id);
		
		m.addAttribute("loginSession", loginSession);
		m.addAttribute("address", address);
		
		return "select_staff";
	}
	
	@RequestMapping("/register1")
	@ResponseBody
	public boolean register1(@RequestBody SelectForm f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert1(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register2")
	@ResponseBody
	public boolean register2(@RequestBody SelectForm f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert2(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register3")
	@ResponseBody
	public boolean register3(@RequestBody SelectForm f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert3(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register4")
	@ResponseBody
	public boolean register4(@RequestBody SelectForm f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert4(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register5")
	@ResponseBody
	public boolean register5(@RequestBody SelectForm f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert5(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register6")
	@ResponseBody
	public boolean register6(@RequestBody SelectForm f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert6(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register7")
	@ResponseBody
	public boolean register7(@RequestBody SelectForm f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert7(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register8")
	@ResponseBody
	public boolean register8(@RequestBody SelectForm f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert8(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register9")
	@ResponseBody
	public boolean register9(@RequestBody SelectForm f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert9(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register10")
	@ResponseBody
	public boolean register10(@RequestBody SelectForm f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert10(address);
		
		return count > 0;
	}
}