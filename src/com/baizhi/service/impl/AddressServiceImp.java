package com.baizhi.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhi.dao.AddressDao;
import com.baizhi.entity.Address;
import com.baizhi.service.AddressService;
@Service
public class AddressServiceImp implements AddressService {
	
	@Autowired
	private AddressDao ad;
	
	@Override
	public List<Address> select(int uid) {
		return ad.select(uid);
		
	}

	@Override
	public void add(Address add) {
		ad.add(add);
	}

	

	@Override
	public void updateDefault(int uid , int aid) {
		ad.updateNotDefault(uid);
		ad.updateDefault(aid);
		
	}


	@Override
	public void updateDeleteStatus(int aid) {
		ad.updateDeleteStatus(aid);

	}	
}