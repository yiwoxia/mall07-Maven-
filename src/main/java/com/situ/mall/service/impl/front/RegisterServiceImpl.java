package com.situ.mall.service.impl.front;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.mall.dao.front.RegisterDao;
import com.situ.mall.pojo.User;
import com.situ.mall.service.front.IRegisterService;

@Service("registerService")
public class RegisterServiceImpl implements IRegisterService {

	@Resource(name="registerDao")
	private RegisterDao registerDao;
	
	//注册用户
	@Override
	public boolean registerUser(User user) {
		int result = registerDao.registerUser(user);
		return result > 0 ? true : false;
	}
	
	//检测用户名是否存在
	@Override
	public boolean checkUsername(String username) {
		User user = registerDao.checkUsername(username);
		return user != null ? true:false;
	}
	//激活用户状态
	@Override
	public boolean setStatus(String activeCode) {
		int result = registerDao.setStatus(activeCode);
		return false;
	}
	
}
