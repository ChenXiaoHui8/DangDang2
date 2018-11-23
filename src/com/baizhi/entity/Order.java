package com.baizhi.entity;

import java.util.Date;
import java.util.List;

public class Order {
	private int oid;
	private int aid;
	private double totalPrice; 
	private String orderStatus;
	private String orderNumber;
	private Date date;
	private List<ShoppingCart> scList;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<ShoppingCart> getScList() {
		return scList;
	}
	public void setScList(List<ShoppingCart> scList) {
		this.scList = scList;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int oid, int aid, double totalPrice, String orderStatus,
			String orderNumber, Date date, List<ShoppingCart> scList) {
		super();
		this.oid = oid;
		this.aid = aid;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
		this.orderNumber = orderNumber;
		this.date = date;
		this.scList = scList;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", aid=" + aid + ", totalPrice="
				+ totalPrice + ", orderStatus=" + orderStatus
				+ ", orderNumber=" + orderNumber + ", date=" + date
				+ ", scList=" + scList + "]";
	}
	
	
}
