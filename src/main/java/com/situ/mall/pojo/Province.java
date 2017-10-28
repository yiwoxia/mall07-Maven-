package com.situ.mall.pojo;

import java.io.Serializable;

public class Province implements Serializable {

	//id
	private Integer id;
	private String province;
	private Integer sort;
	public Province() {
		super();
		
	}
	public Province(Integer id, String province, Integer sort) {
		super();
		this.id = id;
		this.province = province;
		this.sort = sort;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @return the sort
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * @param sort the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Province [id=" + id + ", province=" + province + ", sort=" + sort + "]";
	}
	
	
}
