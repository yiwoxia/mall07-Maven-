package com.situ.mall.service;

import com.situ.mall.pojo.User;
import com.situ.mall.vo.PageBean;

public interface IUserService {
	/**
	 * 分页
	 * @param pageIndex1
	 * @param pageSize1
	 * @return
	 */
	public PageBean pageList(int pageIndex, int pageSize);
	/**
	 * 检测用户名
	 * @param username
	 * @return
	 */
	public boolean checkUsername(String username);
	/**
	 * 修改
	 * @param user
	 */
	public boolean updateUser(User user);
	/**
	 * 根据ID修改
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id);
	/**
	 * 删除
	 * @param id
	 */
	public boolean deleteUser(Integer id);
	/**
	 * 添加
	 * @param user
	 */
	public boolean addUser(User user);
	/**
	 * 阿里云
	 * @param name
	 * @return
	 */
	public User checkUser(String name);

}
