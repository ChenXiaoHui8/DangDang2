package com.baizhi.service;

import com.baizhi.entity.Users;

public interface UsersService {
	// µÇÂ¼
	public Users login(String email , String upassword);
	
	//×¢²á
	public void regist(Users users);
	
	// ¼¤»îÕËºÅ
	public void update(String email);
}
