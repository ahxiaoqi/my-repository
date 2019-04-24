package com.zhiyou100.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.model.Admin;
import com.zhiyou100.model.User;
import com.zhiyou100.service.AdminService;
import com.zhiyou100.service.UserService;




@Controller
@RequestMapping("/user")
public class UserController {
	private static final String String = null;
	@Autowired
	UserService Userservice;
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public String userLogin(String email,String password,HttpServletRequest req) {
		 User user = Userservice.findUserByemail(email);
		System.out.println("输入的用邮箱为:"+email);
		System.out.println("页面接收密码为"+password);
		System.out.println("查询到的结果为"+user);
		if(user!=null) {
			if(user.getPassword().trim().equals(password.trim())) {
				req.getSession().setAttribute("Email",user.getEmail() );
				return "success";
			}
			else {
				return "false";
			}
		}
		else {
			return "false";
		}
		
	}
	@RequestMapping("/showMyProfile.do")
	public String toUserProfile(HttpServletRequest req,Model model) {
		String  Email = (String)req.getSession().getAttribute("Email");
		User info = Userservice.findUserByemail(Email);
		model.addAttribute("userInfo",info);
		return "before/user/index";
	}
	@RequestMapping("/insertUser.do")
	public String insertUser() {
		return "success";
	}
}
