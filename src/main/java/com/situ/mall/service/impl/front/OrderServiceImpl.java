package com.situ.mall.service.impl.front;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.mall.dao.front.OrderDao;
import com.situ.mall.pojo.Order;
import com.situ.mall.pojo.OrderItem;
import com.situ.mall.service.front.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	@Resource(name="orderDao")
	private OrderDao orderDao;
	// 添加订单项
	@Override
	public int addOrderItem(OrderItem orderItem) {
		return orderDao.addOrderItem(orderItem);
	}
	// 根据订单号查询订单项
	@Override
	public List<OrderItem> findByOrder(Long orderNo) {
		return orderDao.findByOrderNo(orderNo);
	}
	// 添加订单
	@Override
	public boolean add(Order order) {
		int result = orderDao.add(order);
		return result > 0 ? true : false;
	}
	//查看订单展示订单页面
	@Override
	public List<Object> findorderByUser(Integer id) {
		return orderDao.findorderByUser(id);
	}
	
}
