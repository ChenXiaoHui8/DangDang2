package com.baizhi.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bd;
	
	@Override
	public List<Book> selectHot() {
		
		return bd.selectHot();
		
	}

	@Override
	public List<Book> selectTime() {
		
			return bd.selectTime();
			
		
	}

	@Override
	public List<Book> select() {
		
			return bd.select();
		
	}
	
	public List<Book> selectByPage(int cid , int pid , int curPage , int pageSize){
		
			int begin = pageSize*(curPage-1)+1;
			int end = pageSize*curPage;
			return bd.selectByPage(cid, pid, begin, end);
		
	}
	
	public Book selectOne(int bid){
		
			 return bd.selectOne(bid);
			
	
	}
	public String selectName(int id){
		
			 return bd.selectName(id);
		
	}
	
	public int selectTotalPage(int cid , int pid , int pageSize){
		
			int totalPage = 0;
		
			int num = bd.selectNum(cid, pid);
			totalPage = num%pageSize==0?num/pageSize:num/pageSize+1;
		return totalPage;
	}
}
