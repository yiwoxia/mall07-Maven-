package com.situ.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.mall.pojo.Product;
import com.situ.mall.vo.PageBean;
import com.situ.mall.vo.SearchCondition;
@Repository("productDao")
public interface ProductDao {

	/**
	 * 获取所有信息 
	 * @return
	 */
	public List<Product> finAll();
	/**
	 * 分页
	 * @return
	 */
	public List<Product> pageList(@Param("pageIndex")Integer pageIndex, @Param("pageSize")Integer pageSize);
	/**
	 * 获得数据库中数量的数量
	 * @return int
	 */
	public int totalSize();
	/**
	 * 添加添加商品
	 * @param product
	 * @return
	 */
	public int addProduct(Product product);
	/**
	 * 有条件的分页
	 * @param condition
	 * @return
	 */
	public List<Product> pageListByCondition(SearchCondition condition);
	/**
	 * 根据条件查询数据的数量
	 * @param condition
	 * @return int
	 */
	public int totalSizeByCondition(SearchCondition condition);
	/**
	 * 修改
	 * @param product
	 * @return
	 */
	public boolean updateProduct(Product product);
	/**
	 * 修改商品的状态
	 * @param id
	 * @param status
	 * @return int
	 */
	public int updateStatus(Product product);
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Product findById(Integer id);
	/**
	 * 根据id删除商品
	 * @param id
	 * @return
	 */
	public int deleteById(int id);
	/**
	 * 全部删除
	 * @param selectIds
	 * @return
	 */
	public int delAll(int[] selectIds);
	/**
	 * 批量修改上架下架
	 * @param key
	 * @param status
	 * @return
	 */
	public int updateAll(@Param("id")Integer id, @Param("status")Integer status);
	public Product findproductById(Integer id);

}
