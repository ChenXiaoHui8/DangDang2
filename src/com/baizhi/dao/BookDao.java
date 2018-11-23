package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;

public interface BookDao {
	public List<Book> selectHot();
	public List<Book> selectTime();
	public List<Book> select();
	public List<Book> selectByPage(@Param("cid")int cid,@Param("pid")int pid , @Param("begin")int begin,@Param("end")int end);
	public Book selectOne(@Param("bid")int bid);
	
	public String selectName(int id);
	public int selectNum(@Param("cid")int cid,@Param("pid")int pid);
	
	// ����ͼ��ʱ���ٸ�ͼ��������Ӹ�ͼ������
	public void update(@Param("bid")int bid,@Param("number")int number);
	
}
