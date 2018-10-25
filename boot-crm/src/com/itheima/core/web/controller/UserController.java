package com.itheima.core.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itheima.core.po.User;
import com.itheima.core.service.UserService;

@Controller
@Component(value="user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public String login(String usercode,String password,Model model,HttpSession session) {
		User user = userService.findUser(usercode, password);
		if(user!=null) {
			session.setAttribute("USER_SESSION", user);
			return "customer";
		}
		model.addAttribute("msg", "�˺Ŵ���");
		return "login";
	}
	@RequestMapping(value="/toCustome.action")
	public String toCustomer() {
		return "customer";
	}
	@RequestMapping(value="/logout.action")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	@RequestMapping(value="/login.action",method= RequestMethod.GET )
	public String toLogin() {
		return "login";
	}
	
	
	
}
