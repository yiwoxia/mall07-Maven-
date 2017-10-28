package com.situ.mall.service.impl.front;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.mall.dao.front.LoginDao;
import com.situ.mall.pojo.User;
import com.situ.mall.service.front.ILoginService;



@Service
public class LoginServiceImpl implements ILoginService{

	
	@Resource(name="loginDao")
	private LoginDao loginDao;

	@Override
	public User checkUser(User user) {
		return loginDao.checkUser(user);
	}
	/**
	 * 根据Id查询用户名
	 */
	@Override
	public User fandByUser(String user) {
		return loginDao.fandByUser(user);
	}
	
}
