package com.situ.mall.service;

import com.situ.mall.pojo.User;

public interface ILoginBackService {
	
	/**
	 * 检测用户名的存在
	 * @param user
	 * @return
	 */
	User checkUser(User user);

}
