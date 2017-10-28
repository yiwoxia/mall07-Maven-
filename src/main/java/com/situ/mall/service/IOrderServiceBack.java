package com.situ.mall.service;

import com.situ.mall.vo.PageBean;

public interface IOrderServiceBack {

	/**
	 * 分页查询
	 * @param pageIndex1
	 * @param pageSize1
	 * @return
	 */
	public PageBean pageList(int pageIndex1, int pageSize1);

}
