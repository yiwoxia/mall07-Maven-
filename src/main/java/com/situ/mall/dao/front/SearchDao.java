package com.situ.mall.dao.front;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.mall.pojo.Categrory;
import com.situ.mall.pojo.Product;
import com.situ.mall.vo.SearchCondition;

public interface SearchDao {

	/**
	 * 根据分类查询商品的数量
	 * @param categoryId
	 * @return int
	 */
	int totalSize(Integer categoryId);

	/**
	 * 根据分类查询商品
	 * @param categoryId
	 * @param pageIndex
	 * @param pageSize
	 * @return List<Product>
	 */
	List<Product> pageList(@Param("categoryId")Integer categoryId, @Param("pageIndex")Integer pageIndex, @Param("pageSize")Integer pageSize);

	/**
	 * 根据条件查询数据的数量
	 * @param condition
	 * @return int
	 */
	int totalSizeByCondition(SearchCondition condition);
	/**
	 * 有条件的分页
	 * @param condition
	 * @return
	 */
	List<Product> pageListByCondition(SearchCondition condition);

	
}
