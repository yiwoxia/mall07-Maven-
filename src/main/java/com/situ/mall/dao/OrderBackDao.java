package com.situ.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.mall.pojo.Order;
import com.situ.mall.pojo.User;

@Repository("orderBackDao")
public interface OrderBackDao {
	/**
	 * 查询一共有多少条数据
	 * 
	 * @return
	 */
	public int totalSize();
	/**
	 * 根据条件查询数据的个数
	 * @param index
	 * @param pageSize
	 * @return
	 */
	public List<Order> pageList(@Param(value="pageIndex1")int pageIndex1, @Param(value="pageSize1")int pageSize1);

	

}
