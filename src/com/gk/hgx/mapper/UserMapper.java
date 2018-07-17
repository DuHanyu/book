package com.gk.hgx.mapper;

import org.apache.ibatis.annotations.Param;

import com.gk.hgx.bean.User;

public interface UserMapper {

	public void add(User user);

	public int findUserByLoginname(String loginname);

	public int findUserByEmail(String email);

	public User getUserByLoginnameAndLoginpass(User user);
	
	public void updateByUid(@Param("uid") Integer uid,@Param("newpass") String newpass);
	
	
}
