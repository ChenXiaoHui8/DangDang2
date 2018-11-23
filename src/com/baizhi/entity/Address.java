package com.baizhi.entity;

public class Address {
	private int aid;
	private String aname;
	private String address;
	private String phone;
	private int uid;
	private int delectStatus;
	private int defaultStatus;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int aid, String aname, String address, String phone,
			int uid, int delectStatus, int defaultStatus) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.address = address;
		this.phone = phone;
		this.uid = uid;
		this.delectStatus = delectStatus;
		this.defaultStatus = defaultStatus;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", aname=" + aname + ", address="
				+ address + ", phone=" + phone + ", uid=" + uid
				+ ", delectStatus=" + delectStatus + ", defaultStatus="
				+ defaultStatus + "]";
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getDelectStatus() {
		return delectStatus;
	}
	public void setDelectStatus(int delectStatus) {
		this.delectStatus = delectStatus;
	}
	public int getDefaultStatus() {
		return defaultStatus;
	}
	public void setDefaultStatus(int defaultStatus) {
		this.defaultStatus = defaultStatus;
	}
	
}
