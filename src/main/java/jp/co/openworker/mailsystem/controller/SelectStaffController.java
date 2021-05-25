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
import jp.co.openworker.mailsystem.model.form.SelectAddressForm1;
import jp.co.openworker.mailsystem.model.form.SelectAddressForm10;
import jp.co.openworker.mailsystem.model.form.SelectAddressForm2;
import jp.co.openworker.mailsystem.model.form.SelectAddressForm3;
import jp.co.openworker.mailsystem.model.form.SelectAddressForm4;
import jp.co.openworker.mailsystem.model.form.SelectAddressForm5;
import jp.co.openworker.mailsystem.model.form.SelectAddressForm6;
import jp.co.openworker.mailsystem.model.form.SelectAddressForm7;
import jp.co.openworker.mailsystem.model.form.SelectAddressForm8;
import jp.co.openworker.mailsystem.model.form.SelectAddressForm9;
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
	public boolean register1(@RequestBody SelectAddressForm1 f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register2")
	@ResponseBody
	public boolean register2(@RequestBody SelectAddressForm2 f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register3")
	@ResponseBody
	public boolean register3(@RequestBody SelectAddressForm3 f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register4")
	@ResponseBody
	public boolean register4(@RequestBody SelectAddressForm4 f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register5")
	@ResponseBody
	public boolean register5(@RequestBody SelectAddressForm5 f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register6")
	@ResponseBody
	public boolean register6(@RequestBody SelectAddressForm6 f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register7")
	@ResponseBody
	public boolean register7(@RequestBody SelectAddressForm7 f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register8")
	@ResponseBody
	public boolean register8(@RequestBody SelectAddressForm8 f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register9")
	@ResponseBody
	public boolean register9(@RequestBody SelectAddressForm9 f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert(address);
		
		return count > 0;
	}
	
	@RequestMapping("/register10")
	@ResponseBody
	public boolean register10(@RequestBody SelectAddressForm10 f) {
		SelectAddress address = new SelectAddress(f);
		
		int count = selectAddressMapper.insert(address);
		
		return count > 0;
	}
}