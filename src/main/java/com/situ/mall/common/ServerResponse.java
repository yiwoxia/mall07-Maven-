package com.situ.mall.common;

import java.io.Serializable;

/**
 * 
 * 后台返回给前端对象
 *
 * @param <T>
 */
public class ServerResponse<T> implements Serializable{
	//当前状态(程序员判断状态)：成功，失败，未登录，没有权限
	private Integer status;
	//描述信息(主要是给用户看的提示信息)
	private String msg;
	//后台返回给前端的数据
	private T data;
	
	
	
	public ServerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServerResponse(Integer status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public ServerResponse(Integer status, T data) {
		super();
		this.status = status;
		this.data = data;
	}

	public ServerResponse(Integer status) {
		super();
		this.status = status;
	}

	public ServerResponse(Integer status, String msg, T data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	//后台返回给前端的状态  ，只是告诉前台成功的状态:status,msg----成功
	public static<T>  ServerResponse<T> createSuccess(){
		
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode());
	
	}
	//后台返回给前端的状态只是告诉前台成功的状态:status,msg-------成功
	public static<T>  ServerResponse<T> createSuccess(String msg){
		
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),msg);
	
	}
	//后台返回给前端的状态只是告诉前台成功的状态:status,msg,data------成功
	public static<T>  ServerResponse<T> createSuccess(String msg,T data){
		
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),msg,data);
	
	}
	
	//后台返回给前端的状态  ，只是告诉前台失败的状态:status,msg----失败
	public static<T>  ServerResponse<T> createError(){
		
		return new ServerResponse<>(ResponseCode.ERROR.getCode());
	
	}
	//后台返回给前端的状态，只是告诉前台失败的状态:status,msg----失败
	public static<T>  ServerResponse<T> createError(String msg){
		
		return new ServerResponse<>(ResponseCode.ERROR.getCode(),msg);
	
	}
	//后台返回给前端的状态，只是告诉前台失败的状态:status,msg,data----失败
	public static<T>  ServerResponse<T> createError(String msg,T data){
		
		return new ServerResponse<>(ResponseCode.ERROR.getCode(),msg,data);
	
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	
	
}
