package com.situ.mall.controller.back;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.pojo.Categrory;
import com.situ.mall.service.ICategroryService;
import com.situ.mall.vo.PageBean;
import com.situ.mall.vo.SearchCondition;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private ICategroryService categoryService;
	//查询所有的分类的父类
	@RequestMapping("/categoryParent")
	@ResponseBody
	private List<Categrory> categoryParent(){
		List<Categrory> cplist = categoryService.fingAllCategoryParent();
		for(Categrory categrory : cplist){
			System.out.println(categrory);
		}
		return cplist;
	}
	//查找所有的子类
	@RequestMapping("/category")
	@ResponseBody
	private List<Categrory> category (Integer parentId){
		List<Categrory> clist = categoryService.findAllCategory(parentId);
		System.err.println(clist);
		return clist;
		
	}
	//无条件分页
	@RequestMapping("pageList")
	private String pageList(Integer pageIndex, Integer pageSize, Model model) {
		
		if (pageIndex == null) {
			pageIndex = 1;
		}
		
		pageSize = 10;
		List<Categrory> cplist = categoryService.fingAllCategoryParent();
		model.addAttribute("cplist", cplist);
		PageBean<Categrory> pageBean = categoryService.pageList(pageIndex, pageSize);
		model.addAttribute("pageBean", pageBean);
		return "category_show";
	}
	//根据条件查询分页
	@RequestMapping("/pageListByCondition")
	private String pageListByCondition(SearchCondition condition,Model model){
		if(condition.getPageIndex()==null){
			condition.setPageIndex(1);
		}
		condition.setPageSzie(3);
		List<Categrory>cplist = categoryService.fingAllCategoryParent();
		model.addAttribute("cplist",cplist);
		PageBean<Categrory>pageBean = categoryService.pageListByCondition(condition);
		model.addAttribute("condition",condition);
		model.addAttribute("pageBean",pageBean);
		return "category_show";
	}
	//添加分类页面
	@RequestMapping("/addCategory")
	private String addCategopry(Categrory category){
		categoryService.addCategory(category);
		return "redirect:pageList.action";
	}
	//跳转到添加分类页面
	@RequestMapping("/toAddCategory")
	private String toAddCategory(Model model){
		
		List<Categrory> cplist = categoryService.fingAllCategoryParent();
		model.addAttribute("cplist",cplist);
		return "category_add";
		
	}
	//修改状态
	@RequestMapping("/updateStatus")
	private String updateStatus(Integer id,Integer status){
		categoryService.updateStatus(id,status);
		return "redirect:pageList.action";
		
	}
	//删除分类
	@RequestMapping("/delCategory")
	private String delCategory(Integer id){
		categoryService.delCategory(id);
		return "redirect:pageList.action";
	}
	//批量修改
	@RequestMapping("/updateAllStatus")
	private String updateAllStatus(int[] selectIds,int[] statusId){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < statusId.length; i++) {
			map.put(selectIds[i], statusId[i]);	
		}
		categoryService.updateAllStatus(map);
		return "redirect:pageList.action";
		
	}
	//批量删除
	@RequestMapping("/delAll")
	private String delAll(Integer[] selectIds){
		categoryService.delAll(selectIds);
		return "redirect:pageList.action";
		
	}
}
