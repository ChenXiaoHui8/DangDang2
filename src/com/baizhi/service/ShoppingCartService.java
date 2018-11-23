package com.baizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;
import com.baizhi.entity.ShoppingCart;

public interface ShoppingCartService {
	// 展示所有购物车
	public List<ShoppingCart> selectShoppingCart(int uid ,int statusId);
	
	// 修改为删除状态
	public void updateStatusDelete(int uid , int bid);
	
	// 修改为恢复状态
	public void updateStatusRecover(int uid ,int bid);
	
	// 购物车添加
	public void add(int uid , int bid);
	//	彻底删除该图书
	public void delete(int uid , int bid);
	// 修改购物车里图书商品的数量
	public void updateNum(int uid , int bid , int number); 
	
	// 清空购物车
	public void deleteAll(int uid);

}
