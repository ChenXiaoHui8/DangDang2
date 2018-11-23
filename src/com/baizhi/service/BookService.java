package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Book;

public interface BookService {
	public List<Book> selectHot();
	public List<Book> selectTime();
	public List<Book> select();
	public List<Book> selectByPage(int cid , int pid , int curPage , int pageSize);
	public Book selectOne(int bid);
	public String selectName(int id);
	public int selectTotalPage(int cid , int pid , int pageSize);
}
