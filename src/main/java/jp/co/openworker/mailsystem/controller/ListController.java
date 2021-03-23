package jp.co.openworker.mailsystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.openworker.mailsystem.model.domain.MstAddress;
import jp.co.openworker.mailsystem.model.mapper.MstAddressMapper;
import jp.co.openworker.mailsystem.model.session.LoginSession;

@Controller
@RequestMapping("/mailsystem/list")
public class ListController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	MstAddressMapper addressMapper;
	
	private Gson gson = new Gson();
	
	@RequestMapping("/")
	public String index(Model m) {
		
		List<MstAddress> address = addressMapper.select();
		
		m.addAttribute("loginSession", loginSession);
		m.addAttribute("address", address);
		return "address_list";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/delete")
	@ResponseBody
	public boolean deleteAddress(@RequestBody String checkedIdList) {
		int result = 0;
																				
		Map<String, List<String>> map = gson.fromJson(checkedIdList, Map.class);
		List<String> checkedIds = map.get("checkedIdList"); 
		for (String id : checkedIds) {
			result += addressMapper.deleteById(Integer.parseInt(id));
		}
		return result > 0;
	}
	
}