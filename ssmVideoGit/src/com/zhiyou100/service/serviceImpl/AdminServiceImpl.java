package com.zhiyou100.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.AdminMapper;
import com.zhiyou100.model.Admin;
import com.zhiyou100.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminMapper adminMapper;
	public Admin findAdminByAdminName(String adminname) {
		Admin admin = adminMapper.findAdminByAdminName(adminname);
		return admin;
	}


}
