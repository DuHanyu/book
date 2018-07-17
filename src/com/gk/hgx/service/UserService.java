package com.gk.hgx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.hgx.bean.User;
import com.gk.hgx.mapper.UserMapper;

@Service
public class UserService {
 
	@Autowired
	private UserMapper userMapper;
	
	public void register(User user) {
		userMapper.add(user);
	}

	public boolean findUserByLoginname(String loginname) {
		return userMapper.findUserByLoginname(loginname)==0;
	}

	public boolean findUserByEmail(String email) {
		return userMapper.findUserByEmail(email)==0;
	}

	public User login(User user) {
     return userMapper.getUserByLoginnameAndLoginpass(user);		
	}

	public void updatePassword(Integer uid, String newpass) {
	   userMapper.updateByUid(uid, newpass);
	}
	
	
	
}
