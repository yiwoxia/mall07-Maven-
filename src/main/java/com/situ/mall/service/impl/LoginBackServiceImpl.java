package com.situ.mall.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.dao.LoginBackDao;
import com.situ.mall.pojo.User;
import com.situ.mall.service.ILoginBackService;

@Service
public class LoginBackServiceImpl implements ILoginBackService{

	@Autowired
	private LoginBackDao loginBackDao;
	
	//检车用户名是否存在
	@Override
	public User checkUser(User user) {
		return loginBackDao.checkUser(user);
	}
	
	
}
