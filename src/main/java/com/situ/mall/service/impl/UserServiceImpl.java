package com.situ.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.mall.dao.UserDao;
import com.situ.mall.pojo.Shipping;
import com.situ.mall.pojo.User;
import com.situ.mall.service.IUserService;
import com.situ.mall.vo.PageBean;

@Service
public class UserServiceImpl implements IUserService{
	
	@Resource(name="userDao")
	private UserDao userDao;
	/**
	 * 分页查询
	 */
	@Override
	public PageBean<User> pageList(int pageIndex, int pageSize) {
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setPageIndex(pageIndex);//获得当前页
		pageBean.setPageSize(pageSize);//获得这一页的数据条数
		//获得数据库一共用多少数据
		int totalCount = userDao.totalSize();
		//获得多少页
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageIndex = (pageIndex - 1) * pageSize;
		pageBean.setTotalpage(totalPage);
		pageBean.setTotalCount(totalCount);
		List<User> list = userDao.pageList(pageIndex, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	/**
	 * 检测用户名
	 */
	@Override
	public boolean checkUsername(String username) {
		// TODO Auto-generated method stub
		int i = userDao.checkUsername(username);
		return i>0?true:false;
	}
	/**
	 * 修改
	 */
	@Override
	public boolean updateUser(User user) {

		int i = userDao.update(user);
		return i>0 ? true : false;
		
	}
	/***
	 * 根据ID修改
	 */
	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findUserById(id);
	}
	/***
	 * 删除
	 */
	@Override
	public boolean deleteUser(Integer id) {
		int i = userDao.deleteUser(id);
		return i>0 ? true : false;
		
	}
	/***
	 * 添加
	 */
	@Override
	public boolean addUser(User user) {
		int i = userDao.addUser(user);
		return i>0 ? true : false;
		
	}
	@Override
	public User checkUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
