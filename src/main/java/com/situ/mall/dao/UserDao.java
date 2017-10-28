package com.situ.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.mall.pojo.User;

@Repository("userDao")
public interface UserDao {
	/**
	 * 查询一共有多少条数据
	 * @return
	 */
	public int totalSize();
	/**
	 * 根据条件查询数据的个数
	 * @param index
	 * @param pageSize
	 * @return
	 */
	public List<User> pageList(@Param(value="pageIndex")int pageIndex, @Param(value="pageSize")int pageSize);
	/**
	 * 检测用户名
	 * @param username
	 * @return
	 */
	public int checkUsername(String username);
	/***
	 * 修改
	 * @param user
	 * @return
	 */
	public int update(User user);
	/**
	 * 根据Id修改
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id);
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int deleteUser(Integer id);
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	public int addUser(User user);

	
	

}
