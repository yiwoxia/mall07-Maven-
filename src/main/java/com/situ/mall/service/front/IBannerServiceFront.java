package com.situ.mall.service.front;

import com.situ.mall.pojo.Banner;
import com.situ.mall.vo.PageBean;

public interface IBannerServiceFront {

	/**
	 * 查找状态为展示的广告图
	 * @return Banner
	 */
	Banner findBanner();
	
	
}
