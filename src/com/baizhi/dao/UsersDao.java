package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Users;

public interface UsersDao {
	// ��½����
	public Users login(@Param("email")String email , @Param("upassword")String upassword);
		
	// ע�Ṧ��
	public void regist(Users us);
	
	// �����
	public void update(String email);
}
