package com.zhiyou100.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou100.model.Admin;
import com.zhiyou100.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminServie;
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String testLogin(String username,String password,Model model ,HttpServletRequest req){
		Admin admin = adminServie.findAdminByAdminName(username);
		System.out.println(admin);
		System.out.println(password);
		if(admin != null){
			if(password.equals(admin.getPassword())){
				model.addAttribute("admin", admin);
				return "forward:/video/list.do";
			}else{
				 req.getSession().setAttribute("errormessage", "密码错误");
				return "redirect:/login.jsp ";
			}
		}else{
			 req.getSession().setAttribute("errormessage", "密码错误");
			return "redirect:/login.jsp ";
		}
	}
	@RequestMapping("exit.do")
	public String edit(HttpServletRequest req) {
		req.getSession().invalidate();
		return "redirect:/login.jsp ";
	}
}
