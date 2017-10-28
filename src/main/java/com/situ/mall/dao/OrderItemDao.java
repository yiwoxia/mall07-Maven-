package com.situ.mall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.situ.mall.pojo.OrderItem;

@Repository("orderItemDao")
public interface OrderItemDao {

	public List<OrderItem> findOrderItemByorder_no(Long orderNo);

}
