package com.situ.mall.service;

import java.util.Map;

public interface IStaticPageService {
	
	/**
	 *商品详情页静态化
	 * @param root 数据
	 * @param id 商品的id
	 */
	public boolean productIndex(Map<String,Object> root ,Integer id);
	
}
