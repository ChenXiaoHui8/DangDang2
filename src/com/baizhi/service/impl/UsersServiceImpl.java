package com.baizhi.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhi.dao.UsersDao;
import com.baizhi.entity.Users;
import com.baizhi.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersDao ud;
	@Override
	public Users login(String email, String upassword) {
		
			return ud.login(email, upassword);
		
	}
	

	@Override
	public void regist(Users users) {
	
			ud.regist(users);
		

	}
	
	public void update(String email){
		
			ud.update(email);
		
	}

}
