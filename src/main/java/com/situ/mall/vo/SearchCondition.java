package com.situ.mall.vo;

import com.situ.mall.pojo.Categrory;
import com.situ.mall.pojo.Product;

public class SearchCondition {
	private Integer pageIndex;
	private Integer pageSzie;
	private Product product;
	private Categrory category;
	
	public SearchCondition() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public SearchCondition(Integer pageIndex, Integer pageSzie, Product product) {
		super();
		this.pageIndex = pageIndex;
		this.pageSzie = pageSzie;
		this.product = product;
	}

	


	public SearchCondition(Integer pageIndex, Integer pageSzie, Product product, Categrory category) {
		super();
		this.pageIndex = pageIndex;
		this.pageSzie = pageSzie;
		this.product = product;
		this.category = category;
	}




	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSzie() {
		return pageSzie;
	}

	public void setPageSzie(Integer pageSzie) {
		this.pageSzie = pageSzie;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Categrory getCategory() {
		return category;
	}

	public void setCategory(Categrory category) {
		this.category = category;
	}




	@Override
	public String toString() {
		return "SearchCondition [pageIndex=" + pageIndex + ", pageSzie=" + pageSzie + ", product=" + product
				+ ", category=" + category + "]";
	}

	
	
}
