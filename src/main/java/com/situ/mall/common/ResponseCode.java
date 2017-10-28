package com.situ.mall.common;
/**
 * 描述信息(主要是给用户看的提示信息)
 * @author 张振
 *
 */
public enum ResponseCode {
	//成功
	SUCCESS(0,"SUCCESS"),
	ERROR(1,"ERROR"),
	//其它状态
	NEED_LOGIN(2,"NEED_LOGIN");
	
	private int code;
	private String desc;
	
	private ResponseCode(int code,String desc){
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	
	
}
