package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Order;
import com.baizhi.entity.ShoppingCart;

public interface OrderDao {
	public void add(@Param("order")Order order,@Param("sc")ShoppingCart sc);
	
	public List<Order> selectAll(int uid);
	
	public void deleteMany(String[] ids);
	
	// Ö§¸¶£¬ÐÞ¸Ä×´Ì¬
	public void updateStatus(String id);
}
