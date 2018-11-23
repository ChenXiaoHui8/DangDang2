package com.baizhi.entity;

import java.util.List;

public class Category {
	private int cid;
	private int pid;
	private String cname;
	private int length;
	private List<Category> categoryList;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int cid, int pid, String cname, int length,
			List<Category> categoryList) {
		super();
		this.cid = cid;
		this.pid = pid;
		this.cname = cname;
		this.length = length;
		this.categoryList = categoryList;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", pid=" + pid + ", cname=" + cname
				+ ", length=" + length + ", categoryList=" + categoryList + "]";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	
	
}
