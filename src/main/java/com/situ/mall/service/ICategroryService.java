package com.situ.mall.service;

import java.util.List;
import java.util.Map;

import com.situ.mall.pojo.Categrory;
import com.situ.mall.vo.PageBean;
import com.situ.mall.vo.SearchCondition;

public interface ICategroryService {
	/**
	 * 查询所有
	 * @return
	 */
	public List<Categrory> finAll();
	/**
	 * 查询全部的父类分类
	 * @return
	 */
	public List<Categrory> fingAllCategoryParent();
	/**
	 * 根据父类的id查询子类
	 * @param parenId
	 * @return
	 */
	public List<Categrory> findAllCategory(Integer parenId);
	/**
	 * 分页查询
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public PageBean<Categrory> pageList(Integer pageIndex, Integer pageSize);
	/**
	 * 有条件的分页查询
	 * @param condition
	 * @return
	 */
	public PageBean<Categrory> pageListByCondition(SearchCondition condition);
	/**
	 * 添加
	 * @param category
	 */
	public boolean addCategory(Categrory category);
	/**
	 * 修改分类
	 * @param id
	 * @param status
	 */
	public boolean  updateStatus(Integer id, Integer status);
	/***
	 * 删除
	 * @param id
	 */
	public boolean delCategory(Integer id);
	/**
	 * 批量修改
	 * @param map
	 */
	public boolean updateAllStatus(Map<Integer, Integer> map);
	/**
	 * 批量删除
	 * @param selectIds
	 */
	public boolean delAll(Integer[] selectIds);
	/**
	 * 获得所有的分类
	 * @return List<Category>
	 */
	public List<Categrory> findAllChildCategory();
}
