package com.situ.mall.service;

import java.util.List;

import com.situ.mall.pojo.OrderItem;

public interface IOrderItemService {

	/**
	 * 查询
	 * @param order_no
	 * @return
	 */
	public List<OrderItem> findOrderItemByorder_no(Long orderNo);


}
