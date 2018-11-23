package com.baizhi.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.BookService;
import com.baizhi.service.CategoryService;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.CategoryServiceImp;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class BookAction extends ActionSupport {
	private BookService bs = new BookServiceImpl();
	private Book book;
	private List<Book> bookList;
	
	@Autowired
	private CategoryService cs; 
	private static int cid;
	private Category category;
	private static int pid;
	private static int num;
	private int parent_id;
	private int totalPage;
	private int curPage=1;
	private int category_id;
	private int pageSize = 5;
	private int bid;
	private String pname;
	private String cname;
	
	@Autowired
	private BookService bookservice;
	// ������
	public String selectHot(){
		System.out.println("-----����������------");
		bookList = bookservice.selectHot();
		return"hot.jsp";
	}
	
	// �����
	public String selectTime(){
		System.out.println("-----���������------");
		bookList = bookservice.selectTime();
		return"new.jsp";
	}
	
	// �༭�Ƽ���
	public String select(){
		System.out.println("-----����༭�Ƽ���------");
		bookList = bookservice.select();
		return"recommend.jsp";
	}
	

	// ��������
	public String selectTimeHot(){
		System.out.println("-----��������������------");
		bookList = bookservice.selectTime();
		return"hotBoard.jsp";
	}
	
	// ��ҳ
	public String selectPage(){
		System.out.println("------����selectPage----");
		pname = bookservice.selectName(cid); // ��ǰλ�õ�һ���������
		cname = bookservice.selectName(pid);  // ��ǰλ�õĶ����������
		category = cs.select(cid);  // չʾ���
		if(pid==0){ // ����һ�����
			parent_id = cid;
			category_id = 0;
		}else{    // ����������
			category_id = pid;
			parent_id = 0;
		}
		totalPage = bookservice.selectTotalPage(category_id, parent_id, pageSize);
		bookList = bookservice.selectByPage(category_id , parent_id, curPage, pageSize); // ��ҳ��ѯͼ��
		return"book_list.jsp";
	}

	// ͼ������	
	public String selectOne(){
		System.out.println("----����selectOne------");
		pid = cid; // pid �������id
		cid = cs.selectPid(pid);  // cidһ�����id
		cname = bookservice.selectName(pid);   // ��ǰλ�õĶ����������
		pname = bookservice.selectName(cid);   // ��ǰλ�õ�һ���������
		book = bookservice.selectOne(bid);
		return "product.jsp";
	}
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BookService getBs() {
		return bs;
	}

	

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setBs(BookService bs) {
		this.bs = bs;
	}

	public CategoryService getCs() {
		return cs;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurPage() {
		return curPage;
	}

	

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
	
}
