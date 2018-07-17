package com.gk.hgx.controll;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gk.hgx.bean.User;
import com.gk.hgx.service.UserService;
import com.gk.hgx.util.VerifyCode;


@Controller
public class UserController {
    
	@Autowired
	VerifyCode verifyCode;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/verifyCode")
	public void VerifyCodeImg(HttpSession session,HttpServletResponse response) throws Exception {
		
		BufferedImage image = verifyCode.getImage();
		VerifyCode.output(image, response.getOutputStream());
		session.setAttribute("imgVerifyCode",verifyCode.getText());
	}
	
	@RequestMapping(value="/forward")
	public String forward(Map<String,Object> map){
		map.put("user", new User());
		return "jsps/user/regist";
	}
	
	@RequestMapping("/ajaxLoginname")
	@ResponseBody
	public boolean ajaxLoginname(@RequestParam(value="loginname") String loginname){
		if(loginname!=null&&loginname.trim()!="") {
          return userService.findUserByLoginname(loginname);
		}
		return false;
	}

	@RequestMapping("/ajaxEmail")
	@ResponseBody
	public boolean ajaxEmail(@RequestParam(value="email") String email){
		if(email!=null&&email.trim()!="") {
       return userService.findUserByEmail(email);
	}
		return false;
	}
	
	@RequestMapping("/ajaxVerifyCode")
	@ResponseBody
	public boolean ajaxVerifyCode(@RequestParam(value="verifyCode") String verifyCode,HttpSession session){
       
		if(verifyCode!=null&&verifyCode.trim()!="") {
		String verify=(String) session.getAttribute("imgVerifyCode");
		return verify.equalsIgnoreCase(verifyCode);
		}
		return false;
	}
	
	@RequestMapping("/ajaxLoginpass")
	@ResponseBody
	public boolean ajaxLoginpass(@RequestParam(value="loginpass") String loginpass,HttpSession session){
       
		if(loginpass!=null&&loginpass.trim()!="") {
		String oldLoginpass=((User) session.getAttribute("user")).getLoginpass();
		return oldLoginpass.equals(loginpass);
		}
		return false;
	}
	

	@RequestMapping("/register")
	public String register(@Valid User user,BindingResult bindingResult,HttpServletRequest request) {
		
		String verifyCode=(String) request.getSession().getAttribute("imgVerifyCode");
		
		user.setActivationCode(UUID.randomUUID().toString());
		
		if(!user.getLoginpass().equals(user.getReloginpass())) {
			FieldError fieldError=new FieldError("user", "loginpass", "密码与确认密码不相同");
			bindingResult.addError(fieldError);
		}
		if(!verifyCode.equalsIgnoreCase(user.getVerifyCode())) {
			FieldError fieldError=new FieldError("user", "verifyCode", "验证码错误55");
			bindingResult.addError(fieldError);
		}
		if(bindingResult.hasFieldErrors()) {
			request.setAttribute("code", "error");
			request.setAttribute("msg", "注册失败");
			return "jsps/user/regist";
		}
		
		userService.register(user);
		request.setAttribute("code", "success");
		request.setAttribute("msg", "注册成功");
		return "jsps/msg";
    }
	
	@RequestMapping("/forwardLogin")
	public String forwardLogin(Map<String,Object> map,HttpSession session) {
		if(session.getAttribute("user")!=null) {
			session.invalidate();
		}
		map.put("user", new User());
		return "jsps/user/login";
	}
	
	@RequestMapping("/login")
	public String login(@Valid User user,BindingResult bindingResult,HttpSession session) {
		
		String verifyCode2=user.getVerifyCode();
		user=userService.login(user);
		String verifyCode=(String) session.getAttribute("imgVerifyCode");
		if(user==null) {
			FieldError fieldError=new FieldError("user", "loginname", "用户名或密码错误");
			bindingResult.addError(fieldError);
		}
		if(!verifyCode.equalsIgnoreCase(verifyCode2)) {
			FieldError fieldError=new FieldError("user", "verifyCode", "验证码错误55");
			bindingResult.addError(fieldError);
		}
		if(bindingResult.hasFieldErrors()) {
			return "jsps/user/login";
		}
		session.setAttribute("user", user);
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/forwardUpdatePassword")
	public String forwardUpdatePassword() {
		return "jsps/user/pwd";
	}
	
	@RequestMapping("/updatePassword")
	public String updatePassword(User user,HttpServletRequest request) {
		
		boolean flag=true;
		String verifyCode2=user.getVerifyCode();
		String verifyCode=(String) request.getSession().getAttribute("imgVerifyCode");
		String oldPassword=((User)request.getSession().getAttribute("user")).getLoginpass();
		if(!verifyCode.equalsIgnoreCase(verifyCode2)) {
			request.setAttribute("verifyCode","验证码错误");
			flag=false;
		}
		if(!user.getNewpass().equals(user.getReloginpass())) {
			request.setAttribute("newpass","新密码和确认密码不相同");
			flag=false;
		}
		if(!user.getLoginpass().equals(oldPassword)) {
			request.setAttribute("loginpass","老密码不正确");
			flag=false;
		}
		  
		if(flag) {
		userService.updatePassword(user.getUid(),user.getNewpass());
		request.setAttribute("code", "success");
		request.setAttribute("msg", "修改成功");
		return "jsps/msg";
		}else {
			return "jsps/user/pwd";
		}
		
		
	}
	
}
