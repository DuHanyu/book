package com.gk.hgx.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.hgx.bean.Admin;
import com.gk.hgx.mapper.AdminMapper;

@Service
public class AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	public Admin get(Admin admin) {
		return adminMapper.get(admin);
	}

}
