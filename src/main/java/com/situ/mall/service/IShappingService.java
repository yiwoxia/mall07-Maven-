package com.situ.mall.service;

import com.situ.mall.pojo.Shipping;
import com.situ.mall.vo.PageBean;

public interface IShappingService {

	/**
	 * 分页查询
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public PageBean<Shipping> pageList(Integer pageIndex1, Integer pageSize1);
	/**
	 * 添加
	 * @param shipping
	 */
	public boolean addShipping(Shipping shipping);
	/**
	 * 修改
	 * @param shipping
	 */
	public boolean update(Shipping shipping);
	/**
	 * 根据Id查找
	 * @param id
	 * @return
	 */
	public Shipping findById(Integer id);
	/**
	 * 根据ID删除
	 * @param id
	 */
	public boolean delShippingById(Integer id);
	

}
