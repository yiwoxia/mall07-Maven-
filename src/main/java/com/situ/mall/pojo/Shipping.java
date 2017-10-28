package com.situ.mall.pojo;

import java.io.Serializable;
import java.util.Date;

public class Shipping implements Serializable{
	
	
	 	private Integer id;
	 	/**用户ID*/
	    private Integer userId;
	    /**收货姓名*/
	    private String receiverName;
	    /**收货固定电话*/
	    private String receiverPhone;
	    /**收货移动电话*/
	    private String receiverMobile;
	    /**省份*/
	    private String receiverProvince;
	    /**城市*/
	    private String receiverCity;
	    /**区、县*/
	    private String receiverDistrict;
	    /**详细地址*/
	    private String receiverAddress;
	    /**邮编*/
	    private String receiverZip;

	    private Date createTime;

	    private Date updateTime;

		public Shipping() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Shipping(Integer id, Integer userId, String receiverName, String receiverPhone, String receiverMobile,
				String receiverProvince, String receiverCity, String receiverDistrict, String receiverAddress,
				String receiverZip, Date createTime, Date updateTime) {
			super();
			this.id = id;
			this.userId = userId;
			this.receiverName = receiverName;
			this.receiverPhone = receiverPhone;
			this.receiverMobile = receiverMobile;
			this.receiverProvince = receiverProvince;
			this.receiverCity = receiverCity;
			this.receiverDistrict = receiverDistrict;
			this.receiverAddress = receiverAddress;
			this.receiverZip = receiverZip;
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

		public String getReceiverName() {
			return receiverName;
		}

		public void setReceiverName(String receiverName) {
			this.receiverName = receiverName;
		}

		public String getReceiverPhone() {
			return receiverPhone;
		}

		public void setReceiverPhone(String receiverPhone) {
			this.receiverPhone = receiverPhone;
		}

		public String getReceiverMobile() {
			return receiverMobile;
		}

		public void setReceiverMobile(String receiverMobile) {
			this.receiverMobile = receiverMobile;
		}

		public String getReceiverProvince() {
			return receiverProvince;
		}

		public void setReceiverProvince(String receiverProvince) {
			this.receiverProvince = receiverProvince;
		}

		public String getReceiverCity() {
			return receiverCity;
		}

		public void setReceiverCity(String receiverCity) {
			this.receiverCity = receiverCity;
		}

		public String getReceiverDistrict() {
			return receiverDistrict;
		}

		public void setReceiverDistrict(String receiverDistrict) {
			this.receiverDistrict = receiverDistrict;
		}

		public String getReceiverAddress() {
			return receiverAddress;
		}

		public void setReceiverAddress(String receiverAddress) {
			this.receiverAddress = receiverAddress;
		}

		public String getReceiverZip() {
			return receiverZip;
		}

		public void setReceiverZip(String receiverZip) {
			this.receiverZip = receiverZip;
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
			return "Shipping [id=" + id + ", userId=" + userId + ", receiverName=" + receiverName + ", receiverPhone="
					+ receiverPhone + ", receiverMobile=" + receiverMobile + ", receiverProvince=" + receiverProvince
					+ ", receiverCity=" + receiverCity + ", receiverDistrict=" + receiverDistrict + ", receiverAddress="
					+ receiverAddress + ", receiverZip=" + receiverZip + ", createTime=" + createTime + ", updateTime="
					+ updateTime + "]";
		}

}