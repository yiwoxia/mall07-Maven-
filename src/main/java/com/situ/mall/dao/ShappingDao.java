package com.situ.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.mall.pojo.Shipping;
@Repository("ShappingDao")
public interface ShappingDao {

	/**
	 * 查询一共有多少条数据
	 * 
	 * @return
	 */
	public int totalSize();
	/**
	 * 根据条件查询数据的个数
	 * @param condition
	 * @return int
	 */
	public List<Shipping> pageList(@Param(value="pageIndex1")int pageIndex1, @Param(value="pageSize1")Integer pageSize1);
	/**
	 * 添加
	 * @param shipping
	 * @return
	 */
	public int addShipping(Shipping shipping);
	/**
	 * 修改
	 * @param shipping
	 * @return
	 */
	public int update(Shipping shipping);
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 */
	public Shipping findById(Integer id);
	/**
	 * 删除 
	 * @param id
	 * @return
	 */
	public int delShippingById(Integer id);

}
