package jp.co.openworker.mailsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.openworker.mailsystem.model.domain.MstAddress;
import jp.co.openworker.mailsystem.model.form.AddressForm;
import jp.co.openworker.mailsystem.model.mapper.MstAddressMapper;

@Controller
@RequestMapping("/mailsystem/edit")
public class EditController {
	
	@Autowired
	MstAddressMapper addressMapper;
	
	@RequestMapping("/{id}")
	public String index(@PathVariable("id") int id, Model m) {
		MstAddress address = addressMapper.findById(id);
		m.addAttribute("address", address);
		
		return "edit_address";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public boolean update(@RequestBody AddressForm f) {
		MstAddress address = new MstAddress(f);
		
		int result = addressMapper.updata(address, address);
		
		return result > 0;
	}
}