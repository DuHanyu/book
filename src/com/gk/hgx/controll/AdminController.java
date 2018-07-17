package com.gk.hgx.controll;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gk.hgx.bean.Admin;
import com.gk.hgx.service.AdminService;

@Controller
public class AdminController {

	
	@Autowired
	private AdminService adminService;
	
	
	@RequestMapping("/loginPre")
	public String loginPre(HttpSession session) {
		
		if(session.getAttribute("admin")!=null) {
			session.invalidate();
		}
		
		return "adminjsps/login";
	}
	
	
	@RequestMapping("/loginJsp")
	public String login(Admin admin,HttpSession session,Map<String,Object> map) {
		String pwd=admin.getAdminpwd();
		admin=adminService.get(admin);
		if(admin==null) {
			map.put("adminname","用户名错误");
		   return "adminjsps/login";
		}else{
			if(!admin.getAdminpwd().equals(pwd)) {
				map.put("adminpwd", "密码错误");
				return "adminjsps/login";
			}
		}
		
		session.setAttribute("admin",admin);
		return "adminjsps/admin/index";
	}
	
	
}
