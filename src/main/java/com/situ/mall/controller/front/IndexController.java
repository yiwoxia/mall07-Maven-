package com.situ.mall.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.mall.pojo.Banner;
import com.situ.mall.pojo.Categrory;
import com.situ.mall.service.ICategroryService;
import com.situ.mall.service.front.IBannerServiceFront;

@Controller
public class IndexController {

	@Autowired
	private ICategroryService categoryService;
	@Autowired
	private IBannerServiceFront bannerService;
	@RequestMapping("/index.shtml")
	public String index(Integer id, Model model){
		
		List<Categrory> parentList = categoryService.fingAllCategoryParent();
		model.addAttribute("parentList",parentList);
		System.out.println("6666666666"+parentList);
		List<Categrory> chilbList = categoryService.findAllChildCategory();
		model.addAttribute("chilbList",chilbList);
		System.out.println("8888888888888"+chilbList);
		Banner banner = bannerService.findBanner();
		model.addAttribute("banner", banner);
		System.out.println("&&&&&&&&&&&&&"+banner);
		return"index";
	}
}
