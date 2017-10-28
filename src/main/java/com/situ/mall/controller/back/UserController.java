package com.situ.mall.controller.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.mall.pojo.User;
import com.situ.mall.service.IUserService;
import com.situ.mall.vo.PageBean;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	//分页
	@RequestMapping(value="/findUser")
	public ModelAndView  pageList(String pageIndex, String pageSize,ModelAndView modelAndView) {
		int pageIndex1 = 1;
		if (pageIndex!= null && !pageIndex.equals("")) {
			pageIndex1 = Integer.parseInt(pageIndex);
		}
		int pageSize1 = 3;
		if (pageSize != null && !pageSize.equals("")) {
			pageSize1 = Integer.parseInt(pageSize);
		}
		PageBean pageBean = userService.pageList(pageIndex1,pageSize1);
		System.out.println(pageBean);
		modelAndView.addObject("pageBean", pageBean);
		modelAndView.setViewName("user_show");
		return modelAndView;	
	}
	
	//检测用户名
	@ResponseBody
	@RequestMapping(value="/checkUsername")
	public boolean checkStudentName(String username){
		return userService.checkUsername(username);
	}
	//修改
	@RequestMapping(value="/update")
	public String update(User user){
		userService.updateUser(user);
		return "redirect:/user/findUser.action";
	}
	
	@RequestMapping(value="/updateUser")
	public String updateUser(Integer id, Model model){
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "user_update";
	}
	//删除
	@RequestMapping(value="/deleteUser")
	public String deleteUser(Integer id){
		userService.deleteUser(id);
		return "redirect:/user/findUser.action";
	}
	//添加
	@RequestMapping(value="/add")
	public String add(User user){
		userService.addUser(user);
		return "redirect:/user/findUser.action";
	}
	
	@RequestMapping(value="/addUser")
	public String addUser(){
		return "user_add";
	}
}
