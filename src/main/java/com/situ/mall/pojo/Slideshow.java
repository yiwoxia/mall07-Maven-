package com.situ.mall.pojo;

import java.io.Serializable;
import java.util.Date;

public class Slideshow implements Serializable{

	private Integer id;
	
	private String uri;
	/**状态*/
	private Integer status;
	
	private String link;
	/**创建*/
	private Date create_time;
	/**更新时间*/
	private Date update_time;

	public Slideshow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Slideshow(Integer id, String uri, Integer status, String link, Date create_time, Date update_time) {
		super();
		this.id = id;
		this.uri = uri;
		this.status = status;
		this.link = link;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "Slideshow [id=" + id + ", uri=" + uri + ", status=" + status + ", link=" + link + ", create_time="
				+ create_time + ", update_time=" + update_time + "]";
	}
	
}
