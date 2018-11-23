package com.baizhi.entity;

public class ShoppingCart {
	private int sid;
	private int uid;
	private int bid;
	private int status;
	private int number;
	private Book book;
	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoppingCart(int sid, int uid, int bid, int status, int number,
			Book book) {
		super();
		this.sid = sid;
		this.uid = uid;
		this.bid = bid;
		this.status = status;
		this.number = number;
		this.book = book;
	}
	@Override
	public String toString() {
		return "ShoppingCart [sid=" + sid + ", uid=" + uid + ", bid=" + bid
				+ ", status=" + status + ", number=" + number + ", book="
				+ book + "]";
	}
	public ShoppingCart(int uid, int bid, int number) {
		super();
		this.uid = uid;
		this.bid = bid;
		this.number = number;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}
