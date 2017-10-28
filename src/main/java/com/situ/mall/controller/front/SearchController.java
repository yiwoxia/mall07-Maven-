package com.situ.mall.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.mall.pojo.Categrory;
import com.situ.mall.pojo.Product;
import com.situ.mall.service.ICategroryService;
import com.situ.mall.service.front.ISearchService;
import com.situ.mall.vo.PageBean;
import com.situ.mall.vo.SearchCondition;

@Controller
@RequestMapping("search")
public class SearchController {

	@Autowired
	private ISearchService  searchService;
	@Autowired
	private ICategroryService categoryService;
	@RequestMapping("search.shtml")
	private String search(String name, Integer categoryId,Integer pageIndex, Integer pageSize, Model model) {
		System.out.println(name);
		if (pageIndex == null) {
			pageIndex = 1;
		}
		pageSize = 9; 
		List<Categrory> parentList = categoryService.fingAllCategoryParent();
		model.addAttribute("parentList",parentList);
		List<Categrory> chilbList = categoryService.findAllChildCategory();
		model.addAttribute("chilbList",chilbList);
		PageBean<Product> pageBean = searchService.findByCategory(categoryId, pageIndex, pageSize);
		model.addAttribute("pageBean", pageBean);
		System.out.println("999999999999999999999999"+pageBean);
		model.addAttribute("name", name);
		return "search";
	}
	
	//分页查询
	@RequestMapping("SearchCondition.shtml")
	private String SearchCondition(SearchCondition condition,Model model){
		if (condition.getPageIndex() ==  null ) {
			condition.setPageIndex(1);
		}
		condition.setPageSzie(3);
		PageBean<Product> pageBean = searchService.pageListByCondition(condition);
		model.addAttribute("pageBean",pageBean);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("yyyyyyyyyyyyyyyyyyyy"+pageBean);
		List<Categrory> parentList = categoryService.fingAllCategoryParent();
		model.addAttribute("parentList",parentList);
		List<Categrory> chilbList = categoryService.findAllChildCategory();
		model.addAttribute("chilbList",chilbList);
		Integer categoryId = condition.getProduct().getCategoryId();
		model.addAttribute("categoryId", categoryId);
		String name = condition.getProduct().getName();
		System.out.println("name: " + name);
		model.addAttribute("name", name);
		
		return "search";
		
	}
	
}