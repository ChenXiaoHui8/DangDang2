package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Users;

public interface UsersDao {
	// 登陆功能
	public Users login(@Param("email")String email , @Param("upassword")String upassword);
		
	// 注册功能
	public void regist(Users us);
	
	// 激活功能
	public void update(String email);
}
