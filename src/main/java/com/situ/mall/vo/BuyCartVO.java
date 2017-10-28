package com.situ.mall.vo;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 
 * 购物车
 *
 */
public class BuyCartVO {
	
	//购物项集合
	private List<CartItemVO> items = new ArrayList<CartItemVO>();
	
	//继续购物，最后一次产品的id
	private Integer productId;
	
	public void addItem(CartItemVO cartItemVO){
	
		boolean isExisit = false;
		
		//1.这件商品原来在购物车里面有，我们只需要更新购买数量
		for (CartItemVO item : items) {
			if (item.getProduct().getId() == cartItemVO.getProduct().getId()) {
				//存在这件商品将isExist设置为true
				isExisit = true;
				//对之前购物车的数量和新选购的商品的数量进行相加
				int amount = item.getAmount() + cartItemVO.getAmount();
				//购买这件商品的总数量应该<=product.stock
				//判断商品的数量有没有超过库存
				if(amount <= cartItemVO.getProduct().getStock()){
					//如果没有超过库存则将数量添加到购物车
					item.setAmount(amount);
				}else{
					//超出购买限制，最大只能购买这件商品的最大库存
					item.setAmount(item.getProduct().getStock());
				}
				break;
			}
		}
		//2.这件商品原来没有加入购物车，加入购物车
		//如果没有该商品则将该商品加入到购物车
		if (isExisit == false) {
			items.add(cartItemVO);
		}
	}
	//计算购物总金额
	@JsonIgnore
	public double getTotalPrice(){
		Double totalPrice = 0.00;
		for (CartItemVO item : items) {
			totalPrice += item.getAmount() * item.getProduct().getPrice().doubleValue();
		}
		return totalPrice;
	}
	public List<CartItemVO> getItems() {
		return items;
	}

	public void setItems(List<CartItemVO> items) {
		this.items = items;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		
		return "BuyCartVO [items=" + items + ", productId=" + productId + "]";
	}
	
	
}
