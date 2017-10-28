package com.situ.mall.pojo;

import java.io.Serializable;
import java.util.Date;

public class Banner implements Serializable{
	
	private Integer id;
	private String name;
	private Integer status;
	private String imageUrl;
	private Date createTime;
	private Date updateTime;
	
	public Banner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Banner(Integer id, String name, Integer status, String imageUrl, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.imageUrl = imageUrl;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Banner [id=" + id + ", name=" + name + ", status=" + status + ", imageUrl=" + imageUrl + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}
	
	

}
