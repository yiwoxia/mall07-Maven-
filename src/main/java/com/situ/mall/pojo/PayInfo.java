package com.situ.mall.pojo;

import java.io.Serializable;
import java.util.Date;

public class PayInfo implements Serializable{

	 	private Integer id;
	 	/**用户id*/
	    private Integer userId;
	    /**订单号*/
	    private Long orderNo;
	    /**支付平台:1-支付宝,2-微信*/
	    private Integer payPlatform;
	    /**支付宝支付流水号*/
	    private String platformNumber;
	    /**支付宝支付状态*/
	    private String platformStatus;
	    /**创建时间*/
	    private Date createTime;
	    /**更新时间*/
	    private Date updateTime;
		
	    public PayInfo() {
			super();
			// TODO Auto-generated constructor stub
		}

		public PayInfo(Integer id, Integer userId, Long orderNo, Integer payPlatform, String platformNumber,
				String platformStatus, Date createTime, Date updateTime) {
			super();
			this.id = id;
			this.userId = userId;
			this.orderNo = orderNo;
			this.payPlatform = payPlatform;
			this.platformNumber = platformNumber;
			this.platformStatus = platformStatus;
			this.createTime = createTime;
			this.updateTime = updateTime;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public Long getOrderNo() {
			return orderNo;
		}

		public void setOrderNo(Long orderNo) {
			this.orderNo = orderNo;
		}

		public Integer getPayPlatform() {
			return payPlatform;
		}

		public void setPayPlatform(Integer payPlatform) {
			this.payPlatform = payPlatform;
		}

		public String getPlatformNumber() {
			return platformNumber;
		}

		public void setPlatformNumber(String platformNumber) {
			this.platformNumber = platformNumber;
		}

		public String getPlatformStatus() {
			return platformStatus;
		}

		public void setPlatformStatus(String platformStatus) {
			this.platformStatus = platformStatus;
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
			return "PayInfo [id=" + id + ", userId=" + userId + ", orderNo=" + orderNo + ", payPlatform=" + payPlatform
					+ ", platformNumber=" + platformNumber + ", platformStatus=" + platformStatus + ", createTime="
					+ createTime + ", updateTime=" + updateTime + "]";
		}
	    
	    
	
}
