package com.baizhi.service;

import com.baizhi.entity.Users;

public interface UsersService {
	// ��¼
	public Users login(String email , String upassword);
	
	//ע��
	public void regist(Users users);
	
	// �����˺�
	public void update(String email);
}
