package com.zhiyou100.mapper;

import com.zhiyou100.model.User;

public interface UserMapper {
	User findUserByemail(String email);
}
