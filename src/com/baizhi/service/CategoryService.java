package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Category;

public interface CategoryService {
	public List<Category> selectAll();
	public Category select(int cid);
	public int selectPid(int cid);
}
