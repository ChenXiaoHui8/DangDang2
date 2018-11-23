package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressService {
	public List<Address> select(int uid);
	
	public void add(Address add);
	
	public void updateDefault(int uid , int aid);
	
	public void updateDeleteStatus(int aid);
}
