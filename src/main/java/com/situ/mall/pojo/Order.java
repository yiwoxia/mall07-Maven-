package com.situ.mall.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order implements Serializable{
	/**订单id*/
	private Integer id;
	/**订单号*/
	private Long orderNo;
	/**用户Id*/
	private Integer userId;
	
	private Integer shippingId;
	/**实际付款金额，单位是元，保留两位小数*/
	private BigDecimal payment;
	/**支付类型，1-在线支付*/
	private Integer paymentType;
	/**运费，单位是元*/
	private Integer postage;
	/**订单状态：0-已取消-10-未付款，20-已付款*/
	private Integer status;
	/**支付时间*/
	private Date paymentTime;
	/**发货时间*/
	private Date sendTime;
	/**交易完成时间*/
	private Date endTime;
	/**交易关闭时间*/
	private Date closeTime;
	/**创建时间*/
	private Date createTime;
	/**更新时间*/
	private Date updateTime;
	/***orderItem 集合*/
	private List<OrderItem> orderItems;
	/***shipping*/
	private Shipping shipping;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Order(Integer id, Long orderNo, Integer userId, Integer shippingId, BigDecimal payment, Integer paymentType,
			Integer postage, Integer status, Date paymentTime, Date sendTime, Date endTime, Date closeTime,
			Date createTime, Date updateTime, List<OrderItem> orderItems, Shipping shipping) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.userId = userId;
		this.shippingId = shippingId;
		this.payment = payment;
		this.paymentType = paymentType;
		this.postage = postage;
		this.status = status;
		this.paymentTime = paymentTime;
		this.sendTime = sendTime;
		this.endTime = endTime;
		this.closeTime = closeTime;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.orderItems = orderItems;
		this.shipping = shipping;
	}



	public Order(Integer id, Long orderNo, Integer userId, Integer shippingId, BigDecimal payment, Integer paymentType,
			Integer postage, Integer status, Date paymentTime, Date sendTime, Date endTime, Date closeTime,
			Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.userId = userId;
		this.shippingId = shippingId;
		this.payment = payment;
		this.paymentType = paymentType;
		this.postage = postage;
		this.status = status;
		this.paymentTime = paymentTime;
		this.sendTime = sendTime;
		this.endTime = endTime;
		this.closeTime = closeTime;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getShippingId() {
		return shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getPostage() {
		return postage;
	}

	public void setPostage(Integer postage) {
		this.postage = postage;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
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

	
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}



	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}



	public Shipping getShipping() {
		return shipping;
	}



	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}



	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNo=" + orderNo + ", userId=" + userId + ", shippingId=" + shippingId
				+ ", payment=" + payment + ", paymentType=" + paymentType + ", postage=" + postage + ", status="
				+ status + ", paymentTime=" + paymentTime + ", sendTime=" + sendTime + ", endTime=" + endTime
				+ ", closeTime=" + closeTime + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", orderItems=" + orderItems + ", shipping=" + shipping + "]";
	}

	
	
}
