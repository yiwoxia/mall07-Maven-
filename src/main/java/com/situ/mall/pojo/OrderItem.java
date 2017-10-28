package com.situ.mall.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.situ.mall.constant.MallConstant;

public class OrderItem implements Serializable {
	/**订单子表id*/
	private Integer id;
	
	private Long orderNo;
	/**商品id*/
	private Integer productId;
	/**商品名称*/
	private String productName;
	/**商品图片地址*/
	private String productImage;
	/**生成订单时的商品单价，单位是元,保留两位小数*/
	private BigDecimal currentUnitPrice;
	/**商品数量*/
	private Integer quantity;
	/**商品总价,单位是元,保留两位小数*/
	private BigDecimal totalPrice;
	
	private Date createTime;
	
	private Date updateTime;
	
	private Integer userId;

	@JsonIgnore
    public String getFullUrl() {
		return MallConstant.SERVER_ADDRES + productImage;
	}
	
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(Integer id, Long orderNo, Integer productId, String productName, String productImage,
			BigDecimal currentUnitPrice, Integer quantity, BigDecimal totalPrice, Date createTime, Date updateTime,
			Integer userId) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.currentUnitPrice = currentUnitPrice;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.userId = userId;
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

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public BigDecimal getCurrentUnitPrice() {
		return currentUnitPrice;
	}

	public void setCurrentUnitPrice(BigDecimal currentUnitPrice) {
		this.currentUnitPrice = currentUnitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderNo=" + orderNo + ", productId=" + productId + ", productName="
				+ productName + ", productImage=" + productImage + ", currentUnitPrice=" + currentUnitPrice
				+ ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", userId=" + userId + "]";
	}
	
	
}
