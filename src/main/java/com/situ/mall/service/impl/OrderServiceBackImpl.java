package com.situ.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.dao.OrderBackDao;
import com.situ.mall.pojo.Order;
import com.situ.mall.pojo.User;
import com.situ.mall.service.IOrderServiceBack;
import com.situ.mall.vo.PageBean;

@Service
public class OrderServiceBackImpl implements IOrderServiceBack{

	@Resource(name="orderBackDao")
	private OrderBackDao orderBackDao;

	//分页查询`
	@Override
	public PageBean<Order> pageList(int pageIndex1, int pageSize1) {
		PageBean<Order> pageBean = new PageBean<Order>();
		pageBean.setPageIndex(pageIndex1);//获得当前页
		pageBean.setPageSize(pageSize1);//获得这一页的数据条数
		//获得数据库一共用多少数据
		int totalCount = orderBackDao.totalSize();
		//获得多少页
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize1);
		pageIndex1 = (pageIndex1 - 1) * pageSize1;
		pageBean.setTotalpage(totalPage);
		pageBean.setTotalCount(totalCount);
		List<Order> list = orderBackDao.pageList(pageIndex1, pageSize1);
		pageBean.setList(list);
		return pageBean;
	}
	
}
