package com.situ.mall.pojo;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("all")
public class Categrory implements Serializable {
	/**类别Id*/
	private Integer id;
	/**父类别id当id=0时说明是根节点,一级类别*/
	private Integer parentId;
	/**类别名称*/
	private String name;
	/**类别状态1-正常,2-已废弃*/
	private Integer status;
	/**排序编号,同类展示顺序,数值相等则自然排序*/
	private Integer sortOrder;
	/**创建时间*/
	private Date createTime;
	/**更新时间*/
	private Date updateTime;
	
	
	
	public Categrory(Integer id, Integer parentId, String name, Integer status, Integer sortOrder, Date createTime,
			Date updateTime) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.status = status;
		this.sortOrder = sortOrder;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	
	public Categrory() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the parentId
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the sortOrder
	 */
	public Integer getSortOrder() {
		return sortOrder;
	}

	/**
	 * @param sortOrder the sortOrder to set
	 */
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Categrory [id=" + id + ", parentId=" + parentId + ", name=" + name + ", status=" + status
				+ ", sortOrder=" + sortOrder + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
	
}
