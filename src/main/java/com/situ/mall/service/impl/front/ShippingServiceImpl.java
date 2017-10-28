package com.situ.mall.service.impl.front;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.dao.front.ShippingDao;
import com.situ.mall.pojo.City;
import com.situ.mall.pojo.District;
import com.situ.mall.pojo.Province;
import com.situ.mall.pojo.Shipping;
import com.situ.mall.service.front.IShippingService;

@Service
public class ShippingServiceImpl implements IShippingService{

	@Resource(name="shippingDao")
	private ShippingDao shippingDao;
	//根据用户Id查询

	@Override
	public List<Shipping> findByUserId(Integer id) {
		// TODO Auto-generated method stub
		return shippingDao.findByUserId(id);
	}
	//添加地址
	@Override
	public boolean addShipping(Shipping shipping) {
		int i = shippingDao.addShipping(shipping);
		return i>0 ? true :false;
	}

	@Override
	public ServerResponse<List<Shipping>> addAddress(Shipping shipping) {
		int result = shippingDao.addAddress(shipping);
		if (result > 0) {
			//List<Shipping> list = shipingDao.findById(shipping.getUserId());
			return ServerResponse.createSuccess("添加成功");
		}
		return ServerResponse.createSuccess("添加失败");
	}
	
	@Override
	public List<Province> selectProvinces() {
		
		return shippingDao.selectProvinces();
	}

	@Override
	public List<City> selectCitys(Integer provinceId) {
		
		return shippingDao.selectCitys(provinceId);
	}

	@Override
	public List<District> selectAreas(Integer cityId) {
		
		return shippingDao.selectAreas(cityId);
	}
}
