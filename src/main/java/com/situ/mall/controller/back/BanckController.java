package com.situ.mall.controller.back;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.mall.pojo.User;
import com.situ.mall.service.ILoginBackService;

@Controller
@RequestMapping("/back")
public class BanckController {

	@Autowired
	private ILoginBackService loginBackService;
	
	@RequestMapping("/index")
	private String index(){
		return "index";
	}
	
	@RequestMapping("/log")
	private String login(){
		return "login";
	}
	
	//登录
/*	@RequestMapping("/login")
	private String login(User user,Model model,HttpServletRequest request){
		user.setRole(1);
		user = loginBackService.checkUser(user);
		System.out.println(user+"00000000000000000000");
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("backuser", user);
			return "redirect:/back/index.action";
		}else{
			String error = "用户名或密码错误";
			model.addAttribute("error", error);
			return "login";
		}
		
		
	}*/
	
	
	@RequestMapping(value="/login")
	public String login(User user, String checkCode,Model model, HttpServletRequest request){
		String checkCodeSession = (String) request.getSession().getAttribute("checkCodeSession");
		if (checkCode == null || checkCode.equals("")) {
			return "redirect:/back/log.action";
		}
		if (!checkCode.equalsIgnoreCase(checkCodeSession)) {
			return "redirect:/back/log.action";
		}
		user.setRole(1);
		user = loginBackService.checkUser(user);
		System.out.println(user+"00000000000000000000");
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("backuser", user);
			return "redirect:/back/index.action";
		}else{
			String error = "用户名或密码错误";
			model.addAttribute("error", error);
			return "login";
		}
		
	}
	
}
