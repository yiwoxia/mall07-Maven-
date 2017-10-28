package com.situ.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.mall.dao.OrderItemDao;
import com.situ.mall.pojo.OrderItem;
import com.situ.mall.service.IOrderItemService;

@Service
public class OrderItemService implements IOrderItemService{
	
	@Resource(name="orderItemDao")
	private OrderItemDao orderItemDao;
	//分页查询
	@Override
	public List<OrderItem> findOrderItemByorder_no(Long orderNo) {
		// TODO Auto-generated method stub
		return orderItemDao.findOrderItemByorder_no(orderNo);
	}

}
