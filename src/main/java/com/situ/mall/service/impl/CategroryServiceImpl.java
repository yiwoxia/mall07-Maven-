package com.situ.mall.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.mall.dao.CategroryDao;
import com.situ.mall.pojo.Categrory;
import com.situ.mall.service.ICategroryService;
import com.situ.mall.vo.PageBean;
import com.situ.mall.vo.SearchCondition;

@Service("categroryService")
public class CategroryServiceImpl implements ICategroryService {

	@Resource(name="categroryDao")
	private CategroryDao categroryDao;
	//获取所有信息
	@Override
	public List<Categrory> finAll() {
		
		return categroryDao.finAll();
	}
	//查询全部的父类分类
	@Override
	public List<Categrory> fingAllCategoryParent() {
		return categroryDao.findAllCategoryParent();
	}
	//根据父类的id查询子类
	@Override
	public List<Categrory> findAllCategory(Integer parentId) {
		return categroryDao.findAllCategory(parentId);
	}
	//无条件分页
	@Override
	public PageBean<Categrory> pageList(Integer pageIndex, Integer pageSize) {
		
		PageBean<Categrory> pageBean = new PageBean<Categrory>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		//查询一共有多少条数据
		int totalSize = categroryDao.totalSize();
		//一共有多页
		int totalPage = (int) Math.ceil(1.0 * totalSize / pageSize);
		pageBean.setTotalpage(totalPage);
		pageBean.setTotalCount(totalSize);
		pageIndex = (pageIndex - 1) * pageSize;
		List<Categrory>list = categroryDao.pageList(pageIndex,pageSize);
		pageBean.setList(list);
	
		return pageBean;
	}
	//有条件分页
	@Override
	public PageBean<Categrory> pageListByCondition(SearchCondition condition) {
		PageBean<Categrory> pageBean = new PageBean<Categrory>();
		pageBean.setPageIndex(condition.getPageIndex());//当前页
		pageBean.setPageSize(condition.getPageSzie());//一页有多少数据
		//查询一共有多少条数据
		int totalSize = categroryDao.totalSizeByCondition(condition);
		//一共有多少页
		int totalPage = (int) Math.ceil(1.0 * totalSize / condition.getPageSzie());
		pageBean.setTotalCount(totalSize);
		pageBean.setTotalpage(totalPage);
		condition.setPageIndex((condition.getPageIndex()-1) * condition.getPageSzie());
		List<Categrory> list = categroryDao.pageListByCondition(condition);
		pageBean.setList(list);
		return pageBean;
	}
	//添加
	@Override
	public boolean addCategory(Categrory category) {
		int result = categroryDao.addCategory(category);
		return result>0 ? true : false;
		
	}
	//修改分类
	@Override
	public boolean  updateStatus(Integer id, Integer status) {
		if(status == 1){
			status = 2;
		}else if(status == 2){
			status = 1;
		}
		int result = categroryDao.updateStatus(id,status);
		return result > 0 ? true : false;
		
	}
	//删除
	@Override
	public boolean delCategory(Integer id) {
		int result = categroryDao.delCategory(id);
		return result > 0 ? true : false;
	}
	//批量修改
	@Override
	public boolean updateAllStatus(Map<Integer, Integer> map) {
		
		int result = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int status = entry.getValue();
			
			if(status == 1){
				status = 2;
			}else if(status == 2){
				status = 1;
			}
			result = categroryDao.updateStatus(entry.getKey(),status);
		}
		
		return result > 0 ? true : false;
	}
	//批量删除
	@Override
	public boolean delAll(Integer[] selectIds) {
		
		int result = 0;
		for (int i = 0; i < selectIds.length; i++) {
			result = categroryDao.delCategory(selectIds[i]);
		}
		return  result > 0 ? true : false;
	}
	@Override
	public List<Categrory> findAllChildCategory() {
		
		return categroryDao.findAllChildCategory();
	}
}
