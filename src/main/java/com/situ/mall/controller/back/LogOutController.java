package com.situ.mall.controller.back;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.mall.pojo.User;

@Controller
@RequestMapping("/logOut")
public class LogOutController {

	/*@RequestMapping("/log")
	private String login(){
		return "login1";
	}
	*/
	@RequestMapping("/logOut")
	private String loginOut(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("backuser");
		System.out.println(user);
		if (null != user) {
			session.removeAttribute("backuser");
			return "redirect:/back/login.action";
		}
		return "";
	}
	
}
