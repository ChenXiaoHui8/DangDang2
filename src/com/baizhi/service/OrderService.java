package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Order;

public interface OrderService {
	public void add(Order order);
	
	public List<Order> selectAll(int uid);
	
	public void deleteMany(String[] ids);
	
	public void updateStatus(String id);
}
