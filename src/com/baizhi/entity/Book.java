package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{
	private int bid;
	private int cid;
	private String bname;
	private double bprice;
	private Date time;
	private int inventory;
	private String author;
	private int salenum;
	private String messages;
	private double dprice;
	private String bimg;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bid, int cid, String bname, double bprice, Date time,
			int inventory, String author, int salenum, String messages,
			double dprice, String bimg) {
		super();
		this.bid = bid;
		this.cid = cid;
		this.bname = bname;
		this.bprice = bprice;
		this.time = time;
		this.inventory = inventory;
		this.author = author;
		this.salenum = salenum;
		this.messages = messages;
		this.dprice = dprice;
		this.bimg = bimg;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", cid=" + cid + ", bname=" + bname
				+ ", bprice=" + bprice + ", time=" + time + ", inventory="
				+ inventory + ", author=" + author + ", salenum=" + salenum
				+ ", messages=" + messages + ", dprice=" + dprice + ", bimg="
				+ bimg + "]";
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public double getBprice() {
		return bprice;
	}
	public void setBprice(double bprice) {
		this.bprice = bprice;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getSalenum() {
		return salenum;
	}
	public void setSalenum(int salenum) {
		this.salenum = salenum;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public double getDprice() {
		return dprice;
	}
	public void setDprice(double dprice) {
		this.dprice = dprice;
	}
	public String getBimg() {
		return bimg;
	}
	public void setBimg(String bimg) {
		this.bimg = bimg;
	}
	
}
