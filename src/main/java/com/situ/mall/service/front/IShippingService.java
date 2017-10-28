package com.situ.mall.service.front;

import java.util.List;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.pojo.City;
import com.situ.mall.pojo.District;
import com.situ.mall.pojo.Province;
import com.situ.mall.pojo.Shipping;

public interface IShippingService {
	/**
	 * 根据用户Id查询
	 * @param id
	 * @return
	 */

	public List<Shipping>  findByUserId(Integer id);
	/**
	 * 添加地址
	 * @param shipping
	 */
	public boolean addShipping(Shipping shipping);
	
	/**
	 * 添加地址
	 * @param shipping
	 * @return ServerResponse<List<Shipping>>
	 */
	public  ServerResponse<List<Shipping>> addAddress(Shipping shipping);

	/**
	 * 根据省份查找其全部的市
	 * @param provinceId
	 * @return List<City>
	 */
	public List<City> selectCitys(Integer provinceId);
	/**
	 * 根据市查找所有的县区
	 * @param cityId
	 * @return List<District>
	 */
	public List<District> selectAreas(Integer cityId);
	/**
	 * 查找所有的省份
	 * @return List<Province>
	 */
	public List<Province> selectProvinces();
}
