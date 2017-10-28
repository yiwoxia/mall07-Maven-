package com.situ.mall.controller.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.situ.mall.pojo.Shipping;
import com.situ.mall.service.IShappingService;
import com.situ.mall.vo.PageBean;
@Controller
@RequestMapping("/shipping")
public class ShappingController {

	@Autowired
	private IShappingService shappingService;
	
	//分页查询
	@RequestMapping(value="/pageLists")
	public ModelAndView  pageList(String pageIndex, String pageSize,ModelAndView modelAndView) {
		int pageIndex1 = 1;
		if (pageIndex!= null && !pageIndex.equals("")) {
			pageIndex1 = Integer.parseInt(pageIndex);
		}
		int pageSize1 = 3;
		if (pageSize != null && !pageSize.equals("")) {
			pageSize1 = Integer.parseInt(pageSize);
		}
		PageBean pageBean = shappingService.pageList(pageIndex1,pageSize1);
		System.out.println(pageBean);
		modelAndView.addObject("pageBean", pageBean);
		modelAndView.setViewName("shipping_show");
		return modelAndView;	
	}
	//添加
	@RequestMapping(value="/add")
	public String add(Shipping shipping){
		shappingService.addShipping(shipping);
		return "redirect:pageLists.action";
		
	}
	@RequestMapping(value="/addShipping")
	public String addShipping(){
		return "shipping_add";
		
	}
	//修改
	@RequestMapping(value="update")
	private String update(Shipping shipping){
		shappingService.update(shipping);
		return "redirect:/shippping/updateShipping";
		
	}
	@RequestMapping(value="updateShipping")
	public String updateShipping(Integer id , Model model){
		Shipping shipping = shappingService.findById(id);
		model.addAttribute("shipping",shipping);
		return "shipping_update";
		
	}
	//删除
	@RequestMapping(value="/deleteShipping")
	private String deletShipping(Integer id){
		shappingService.delShippingById(id);
		return "redirect:/shipping/pageLists.action";
		
	}
}
