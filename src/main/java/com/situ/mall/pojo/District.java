package com.situ.mall.pojo;

import java.io.Serializable;

public class District implements Serializable {

	private Integer id;
	private String district;
	private Integer cityId;
	
	public District() {
		super();
		
	}

	public District(Integer id, String district, Integer cityId) {
		super();
		this.id = id;
		this.district = district;
		this.cityId = cityId;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @return the cityId
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "District [id=" + id + ", district=" + district + ", cityId=" + cityId + "]";
	}
	
	
	
	
}
