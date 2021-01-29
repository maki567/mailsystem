package jp.co.openworker.mailsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.openworker.mailsystem.model.domain.MstUser;
import jp.co.openworker.mailsystem.model.form.UserForm;
import jp.co.openworker.mailsystem.model.mapper.MstUserMapper;
import jp.co.openworker.mailsystem.model.session.LoginSession;

@Controller
public class IndexController {
	@RequestMapping("/mailsystem")
	public String index() {
		return "index";
	}
}