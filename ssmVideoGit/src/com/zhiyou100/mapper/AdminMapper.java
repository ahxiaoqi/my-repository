package com.zhiyou100.mapper;

import com.zhiyou100.model.Admin;

public interface AdminMapper {
	Admin findAdminByAdminName(String adminname);
}
