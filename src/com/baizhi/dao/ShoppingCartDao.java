package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.ShoppingCart;

public interface ShoppingCartDao {
	public void updateStatusDelete(@Param("uid")int uid , @Param("bid")int bid);
	public void updateStatusRecover(@Param("uid")int uid , @Param("bid")int bid);
	public void add(@Param("uid")int uid , @Param("bid")int bid);
	
	
	public List<ShoppingCart> selectShoppingCart(@Param("uid")int uid , @Param("statusId")int statusId);
	
	public ShoppingCart selectOne(@Param("uid")int uid , @Param("bid")int bid);
	public void delete(@Param("uid")int uid , @Param("bid")int bid);
	public void updateNum(ShoppingCart shoppingCart); 
	
	public void deleteAll(int uid);
}
