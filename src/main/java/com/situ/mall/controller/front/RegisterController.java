package com.situ.mall.controller.front;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.pojo.User;
import com.situ.mall.service.front.IRegisterService;
import com.situ.mall.util.MailUtils;

@Controller
@RequestMapping("register")
public class RegisterController {

	@Autowired
	private IRegisterService registerService;
	
	@RequestMapping("/register.shtml")
	private String register(){
		return "register";
		
	}
	
	@RequestMapping("/checkUsername.shtml")
	@ResponseBody
	private Map<String,Object> checkUsername(String username){
		System.out.println("RegisterController.checkUsername()");
		boolean result = registerService.checkUsername(username);
		Map<String,Object> map = new HashMap<String,Object>();
		
		if (result) {
			map.put("isExist", true);
		}else{
			map.put("isExist", false);
		}
		return map;
		
	}     
	@RequestMapping("registerUser.shtml")
	private String registerUser(User user, HttpServletRequest request) {
		System.out.println("----------");
		user.setRole(0);
		user.setStatus(0);
		String activeCode = UUID.randomUUID().toString().replace("-", "");
		user.setActiveCode(activeCode);
		boolean result = registerService.registerUser(user);
		
		if (result) {
			String emailMsg = "恭喜您已经注册成功请点击此链接，激活账户"
					+ "<a href='http://187w0358v7.iok.la:23211/mall07/login/login.shtml?activeCode="+activeCode+"'>"
					+ "http://187w0358v7.iok.la:23211/mall07/login/login.shtml?activeCode="+activeCode+"</a>";

				try {
					MailUtils.sendMail(user.getEmail(), emailMsg);
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return "register_success";
		}
		return "redirect:register.shtml";
	}
	
	//激活用户状态
	@RequestMapping("active")
	private String active(String activeCode) {
		
		boolean b = registerService.setStatus(activeCode);
		return "login";
	}
	
}
