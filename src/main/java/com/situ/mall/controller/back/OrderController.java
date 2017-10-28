package com.situ.mall.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.situ.mall.pojo.OrderItem;
import com.situ.mall.service.IOrderItemService;
import com.situ.mall.service.IOrderServiceBack;
import com.situ.mall.vo.PageBean;

@Controller
@RequestMapping("/orderBack")
public class OrderController {
	
	@Autowired
	private IOrderServiceBack orderService;
	@Autowired
	private IOrderItemService orderItemService;
	//查询
	@RequestMapping(value="/findOrderItem")
	public String findOrderItem(Long orderNo, Model model){
		List<OrderItem> list = orderItemService.findOrderItemByorder_no(orderNo);
		model.addAttribute("list", list);
		System.out.println("------------------"+list);
		return "order_show";
	}
	//分页查询
	@RequestMapping(value="/findBackOrder")
	public ModelAndView findBackOrder(String pageIndex, String pageSize,ModelAndView modelAndView) {
		int pageIndex1 = 1;
		if (pageIndex!= null && !pageIndex.equals("")) {
			pageIndex1 = Integer.parseInt(pageIndex);
		}
		int pageSize1 = 3;
		if (pageSize != null && !pageSize.equals("")) {
			pageSize1 = Integer.parseInt(pageSize);
		}
		PageBean pageBean = orderService.pageList(pageIndex1,pageSize1);
		System.out.println(pageBean);
		modelAndView.addObject("pageBean", pageBean);
		modelAndView.setViewName("orderItem_show");
		return modelAndView;
	}
}
