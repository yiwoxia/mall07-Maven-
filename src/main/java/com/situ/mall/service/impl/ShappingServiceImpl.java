package com.situ.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.mall.dao.ShappingDao;
import com.situ.mall.pojo.Product;
import com.situ.mall.pojo.Shipping;
import com.situ.mall.service.IShappingService;
import com.situ.mall.vo.PageBean;

@Service
public class ShappingServiceImpl implements IShappingService {
	
	@Resource(name="ShappingDao")
	private ShappingDao shappingDao;
	
	//分页查询
	@Override
	public PageBean<Shipping> pageList(Integer pageIndex1, Integer pageSize1) {

		PageBean<Shipping> pageBean = new PageBean<Shipping>();
		pageBean.setPageIndex(pageIndex1);//获得当前页
		pageBean.setPageSize(pageSize1);//获得这一页的数据条数
		//获得数据库一共用多少数据
		int totalCount = shappingDao.totalSize();
		//获得多少页
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize1);
		pageIndex1 = (pageIndex1 - 1) * pageSize1;
		pageBean.setTotalpage(totalPage);
		pageBean.setTotalCount(totalCount);
		List<Shipping> list = shappingDao.pageList(pageIndex1, pageSize1);
		pageBean.setList(list);
		
		return pageBean;
	}
	//添加
	@Override
	public boolean addShipping(Shipping shipping) {
		int i = shappingDao.addShipping(shipping);
		return i>0 ? true :false;
	}
	//修改
	@Override
	public boolean update(Shipping shipping) {
		int i = shappingDao.update(shipping);
		
		return i>0 ? true : false;
		
	}
	//根据ID查找
	@Override
	public Shipping findById(Integer id) {
		
		return shappingDao.findById(id);
	}
	//删除
	@Override
	public boolean delShippingById(Integer id) {
		
		int i = shappingDao.delShippingById(id);
		
		return i>0 ? true : false;
		
	}
	
	
}
