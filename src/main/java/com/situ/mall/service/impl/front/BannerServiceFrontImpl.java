package com.situ.mall.service.impl.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.dao.front.BannerFrontDao;
import com.situ.mall.pojo.Banner;
import com.situ.mall.service.front.IBannerServiceFront;

@Service
public class BannerServiceFrontImpl implements IBannerServiceFront{

	@Autowired
	private BannerFrontDao bannerDao;

	@Override
	public Banner findBanner() {
		
		return bannerDao.findBanner();
	}
	
}
