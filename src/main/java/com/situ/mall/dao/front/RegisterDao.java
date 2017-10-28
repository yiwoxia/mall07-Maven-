package com.situ.mall.dao.front;

import org.springframework.stereotype.Repository;

import com.situ.mall.pojo.User;

@Repository("registerDao")
public interface RegisterDao {
	/**
	 * 注册用户
	 * @param user
	 * @return int
	 */
	public int registerUser(User user);

	/**
	 * 检测用户名是否存在
	 * @param username
	 * @return User
	 */
	public User checkUsername(String username);
	/**
	 * 激活用户状态
	 * @param activeCode
	 * @return
	 */
	public int setStatus(String activeCode);

}
