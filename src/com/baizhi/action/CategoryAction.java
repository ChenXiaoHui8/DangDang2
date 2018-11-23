package com.baizhi.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.service.impl.CategoryServiceImp;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class CategoryAction extends ActionSupport {
	private List<Category> categoryList;
	
	@Autowired
	private CategoryService categoryservice;
	
	
	public String selectAll(){
		System.out.println("-----½øÈëcategoryµÄselectAll---------");
		categoryList = categoryservice.selectAll();
		return"category.jsp";
	}


	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	
}
