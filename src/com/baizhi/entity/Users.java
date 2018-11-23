package com.baizhi.entity;

public class Users {
	private int uid;
	private String uname;
	private String email;
	private String upassword;
	private String ustatus;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int uid, String uname, String email, String upassword,
			String ustatus) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.email = email;
		this.upassword = upassword;
		this.ustatus = ustatus;
	}
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", email=" + email
				+ ", upassword=" + upassword + ", ustatus=" + ustatus + "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUstatus() {
		return ustatus;
	}
	public void setUstatus(String ustatus) {
		this.ustatus = ustatus;
	}
	
}
