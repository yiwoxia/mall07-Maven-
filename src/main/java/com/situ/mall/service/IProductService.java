package com.situ.mall.service;

import java.util.List;
import java.util.Map;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.pojo.Product;
import com.situ.mall.vo.PageBean;
import com.situ.mall.vo.SearchCondition;

public interface IProductService {

	/**
	 * 获取所有信息
	 * @return
	 */
	public List<Product> finAll();
	/**
	 * 分页无条件
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public PageBean<Product> pageList(Integer pageIndex, Integer pageSize);
	/**
	 * 添加商品
	 * @param product
	 */
	public ServerResponse addProduct(Product product);
	/**
	 * 分页有条件
	 * @param pageIndex
	 * @param pageSzie
	 * @return
	 */
	public PageBean<Product> pageListByCondition(SearchCondition condition);
	/**
	 * 修改商品
	 * @param product
	 * @return
	 */
	public boolean updateProduct(Product product);
	/**
	 * 修改商品的状态
	 * @param id
	 * @param status
	 * @return boolean
	 */
	public boolean updateStatus(Product product);
	/**
	 * 根据id查找商品
	 * @param id
	 * @return
	 */
	public Product findById(Integer id);
	/**
	 * 根据id删除商品
	 * @param id
	 * @return
	 */
	public ServerResponse deleteById(int id);
	/**
	 * 全部删除
	 * @param selectIds
	 * @return
	 */
	public boolean delAll(int[] selectIds);
	/**
	 * 批量修改
	 * @param map
	 * @return
	 */
	public boolean updateAll(Map<Integer, Integer> map);
	/**
	 * 修改商品的状态ajax
	 * @param id
	 * @param status
	 * @return
	 */
	public ServerResponse updateStatusByAjax(Integer id, Integer status);

}
