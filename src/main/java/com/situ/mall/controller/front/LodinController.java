package com.situ.mall.controller.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.pojo.User;
import com.situ.mall.service.front.ILoginService;

@Controller
@RequestMapping("login")
public class LodinController {

	@Autowired
	private ILoginService loginService;
	
	@RequestMapping("login.shtml")	
	private String login(String returnUrl,Model model){
		model.addAttribute("returnUrl",returnUrl);
		return "login";
	}
	@RequestMapping("loginIn.shtml")
	private String loginIn(User user,String returnUrl, Model model,HttpServletRequest request){
		
		String newUrl = "index.shtml";
		System.out.println("aa"+returnUrl+"aa");
		if (null != returnUrl && !"".equals(returnUrl)) {
			String contextPath = request.getContextPath();
			newUrl = returnUrl.substring(contextPath.length() + 1, returnUrl.length());
		}
		user = loginService.checkUser(user);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			System.out.println(user);
			return "redirect:/"+newUrl;
		} else {
			model.addAttribute("error", "用户名或密码错误");
			return "login";
		}
		
	}
	
	@RequestMapping("log.shtml")
	@ResponseBody
	public ServerResponse login(User user,HttpServletRequest request) {
		System.out.println(user);
		user = loginService.checkUser(user);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			System.out.println("111111111111111111111111"+user);
			return ServerResponse.createSuccess("登录成功");
		}else{
			return ServerResponse.createError("登录失败");
		}
	}
}
