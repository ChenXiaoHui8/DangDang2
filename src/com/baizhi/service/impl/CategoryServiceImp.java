package com.baizhi.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
@Service
public class CategoryServiceImp implements CategoryService {
	
	@Autowired
	private CategoryDao cd;
	@Override
	public List<Category> selectAll() {
		List<Category> categoryList = null;
			categoryList = cd.selectAll();
			for(Category c:categoryList){
				int sum = 0;
				for(Category d:c.getCategoryList()){
					sum += d.getLength();
				}
				c.setLength(sum);
			}
		return categoryList;
	}
	public Category select(int cid) {
		Category categoryList = null;
			categoryList = cd.select(cid);
				int sum = 0;
				for(Category d:categoryList.getCategoryList()){
					sum += d.getLength();
				}
				categoryList.setLength(sum);
			
		return categoryList;
	}
	public int selectPid(int cid){
		return cd.selectPid(cid);
	}

}
