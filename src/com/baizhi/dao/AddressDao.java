package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressDao {
	public List<Address> select(int uid);
	public void add(Address add);
	public void updateDefault(int aid);
	public void updateNotDefault(int uid);
	public void updateDeleteStatus(int aid);
}
