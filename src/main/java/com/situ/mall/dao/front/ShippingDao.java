package com.situ.mall.dao.front;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.situ.mall.pojo.City;
import com.situ.mall.pojo.District;
import com.situ.mall.pojo.Province;
import com.situ.mall.pojo.Shipping;

@Repository("shippingDao")
public interface ShippingDao {
	/**
	 * 根据用户ID查询*/
	 public List<Shipping> findByUserId(Integer id);
	 /**
	  * 添加地址
	  * @param shipping
	  * @return
	  */
	public int addShipping(Shipping shipping);
	/**
	 * 添加地址
	 * @param shipping
	 * @return int
	 */
	public int addAddress(Shipping shipping);


	/**
	 * 查找所有的省份
	 * @return List<Province>
	 */
	List<Province> selectProvinces();

	/**
	 * 根据省份查找其全部的市
	 * @param provinceId
	 * @return List<City>
	 */
	List<City> selectCitys(Integer provinceId);

	/**
	 * 根据市查找所有的县区
	 * @param cityId
	 * @return List<District>
	 */
	List<District> selectAreas(Integer cityId);

}
