package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Category;

public interface CategoryDao {
	public List<Category> selectAll();
	public Category select(int cid);
	
	public int selectPid(@Param("cid")int cid);
}
