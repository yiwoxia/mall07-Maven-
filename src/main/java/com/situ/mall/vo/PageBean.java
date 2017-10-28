package com.situ.mall.vo;

import java.util.ArrayList;
import java.util.List;

import com.situ.mall.pojo.Product;

public class PageBean<T> {
	// 当前
	private Integer pageIndex;
	// 当前页显示的条数
	private Integer pageSize;
	 // 总条
	private Integer totalCount;
	  // 总页
	private Integer totalpage;
	   // 当前页要显示的数
	private List<T>list;
	
	
	
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PageBean(Integer pageIndex, Integer pageSize, Integer totalCount, Integer totalpage, List<T> list) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalpage = totalpage;
		this.list = list;
	}



	public Integer getPageIndex() {
		return pageIndex;
	}



	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}



	public Integer getPageSize() {
		return pageSize;
	}



	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}



	public Integer getTotalCount() {
		return totalCount;
	}



	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}



	public Integer getTotalpage() {
		return totalpage;
	}



	public void setTotalpage(Integer totalpage) {
		this.totalpage = totalpage;
	}



	public List<T> getList() {
		return list;
	}



	public void setList(List<T> list) {
		this.list = list;
	}



	@Override
	public String toString() {
		return "PageBean [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalpage=" + totalpage + ", list=" + list + "]";
	}
	
	
 	
}
