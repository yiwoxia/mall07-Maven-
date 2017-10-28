package com.situ.mall.pojo;

import java.io.Serializable;

public class City implements Serializable {

	private Integer id;
	private String city;
	private Integer provinceId;
	
	public City() {
		super();
		
	}

	public City(Integer id, String city, Integer provinceId) {
		super();
		this.id = id;
		this.city = city;
		this.provinceId = provinceId;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the provinceId
	 */
	public Integer getProvinceId() {
		return provinceId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param provinceId the provinceId to set
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "City [id=" + id + ", city=" + city + ", provinceId=" + provinceId + "]";
	}
	
	
	
	
}
