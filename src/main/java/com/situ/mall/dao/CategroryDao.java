package com.situ.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.mall.pojo.Categrory;
import com.situ.mall.vo.SearchCondition;

@Repository("categroryDao")
public interface CategroryDao {
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Categrory> finAll();
	/**
	 * 查询全部的父类分类
	 * @return
	 */
	public List<Categrory> findAllCategoryParent();
	/**
	 * 根据父类的id查询子类
	 * @param parenId
	 * @return
	 */
	public List<Categrory> findAllCategory(Integer parentId);
	/**
	 * 查询一共有多少条数据
	 * 
	 * @return
	 */
	public int totalSize();
	/**
	 * 没有条件的分页
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<Categrory> pageList(@Param("pageIndex")Integer pageIndex, @Param("pageSize")Integer pageSize);
	/**
	 * 根据条件查询数据的个数
	 * @param condition
	 * @return int
	 */
	public int totalSizeByCondition(SearchCondition condition);
	/**
	 * 根据条件分页
	 * @param condition
	 * @return List<Category>
	 */
	public List<Categrory> pageListByCondition(SearchCondition condition);
	/**
	 * 添加
	 * @param category
	 * @return
	 */
	public int addCategory(Categrory category);
	/**
	 * 修改分类
	 * @param id
	 * @param status
	 * @return
	 */
	public int updateStatus(@Param("id")Integer id,@Param("status")Integer status);
	/**
	 * 批量删除
	 * @param integer
	 * @return
	 */
	public int delCategory(Integer integer);
	/**
	 * 获得所有的分类
	 * @return
	 */
	public List<Categrory> findAllChildCategory();
		
}	
