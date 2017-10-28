package com.situ.mall.service.impl.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.dao.front.SearchDao;
import com.situ.mall.pojo.Categrory;
import com.situ.mall.pojo.Product;
import com.situ.mall.service.front.ISearchService;
import com.situ.mall.vo.PageBean;
import com.situ.mall.vo.SearchCondition;

@Service
public class SearchServiceImpl implements ISearchService {
	
	@Autowired
	private SearchDao searchDao;

	@Override
	public PageBean<Product> findByCategory(Integer categoryId, Integer pageIndex, Integer pageSize) {

		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalSize = searchDao.totalSize(categoryId);
		int totalPage = (int) Math.ceil(1.0 * totalSize / pageSize);
		pageIndex = (pageIndex - 1) * pageSize;
		pageBean.setTotalCount(totalSize );
		pageBean.setTotalpage(totalPage);
		List<Product> list = searchDao.pageList(categoryId, pageIndex, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Product> pageListByCondition(SearchCondition condition) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页
		pageBean.setPageIndex(condition.getPageIndex());
		condition.setPageIndex((condition.getPageIndex()-1)*condition.getPageSzie());
		//设置一页有多少数据
		pageBean.setPageSize(condition.getPageSzie());
		int totalSize = searchDao.totalSizeByCondition(condition);//获得符合条件的个数
		//看看有多少页
		int totalPage = (int) Math.ceil(1.0 * totalSize  /condition.getPageSzie());
		pageBean.setTotalCount(totalSize);
		pageBean.setTotalpage(totalPage);
		List<Product> list = searchDao.pageListByCondition(condition);
		for (Product product : list) {
		  System.out.println(list);	
		}
		pageBean.setList(list);
		return pageBean;
	}

}