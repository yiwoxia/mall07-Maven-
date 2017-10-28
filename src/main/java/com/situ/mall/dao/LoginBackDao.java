package com.situ.mall.dao;

import org.springframework.stereotype.Repository;

import com.situ.mall.pojo.User;

@Repository("loginBackDao")
public interface LoginBackDao {
	/**
	 * 检车用户名是否纯在
	 * @param user
	 * @return
	 */
	User checkUser(User user);

}
