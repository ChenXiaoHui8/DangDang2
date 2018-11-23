package com.baizhi.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baizhi.entity.Users;
import com.baizhi.service.UsersService;
import com.baizhi.service.impl.UsersServiceImpl;
import com.baizhi.util.MailUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class UsersAction extends ActionSupport {
	private Users users;
	private UsersService us = new UsersServiceImpl();
	private String email;
	private String uname;
	private String upassword;
	private String yzm;
	private int bj;
	private String yanZhengMa;
	private int bid;
	
	@Autowired
	private UsersService usersservice;
	
	public String login(){
		System.out.println("-----进入登录--------");
		users = usersservice.login(email, upassword);
		if(users!=null){
			ActionContext.getContext().getSession().put("users", users);
			System.out.println("--登录成功--");
			if(bj == 1){
				return "select";
			}else if (bj == 2 ) {
				return "selectShopping";
			}else if (bj == 3 ) {
				return "shoppingCare_add";
			}else if (bj == 4 ) {
				return "order_selectAll";
			}else {
				return "main.jsp";
			}
			
		}else{
			return "login_form.jsp";
		}
	}
	public String regist(){
		System.out.println("-----进入注册--------");
		String str = (String) ActionContext.getContext().getSession().get("yzm");
		if(str.compareToIgnoreCase(yzm)==0){
			if(MailUtil.sendSimpleMail(users.getEmail())==1){
				usersservice.regist(users);
				return "verify_form.jsp";
			}else{
				return "register_form.jsp";
			}
			
		}else{
			return "register_form.jsp";
		}
	}
	public String activate(){
		System.out.println("==========进入激活=============");
		String yy = (String) ActionContext.getContext().getSession().get("yanZhengMa");
		if(yanZhengMa.equalsIgnoreCase(yy)){
			usersservice.update(email);
			return "register_ok.jsp";
		}
		System.out.println("失败");
		return "verify_form.jsp";
	}
	
	public String logout(){
		System.out.println("------进入注销logout----------");
		ActionContext.getContext().getSession().remove("users");
		return "main.jsp";
	}
	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public UsersService getUs() {
		return us;
	}
	public void setUs(UsersService us) {
		this.us = us;
	}
	public int getBj() {
		return bj;
	}
	public void setBj(int bj) {
		this.bj = bj;
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
	public String getYzm() {
		return yzm;
	}
	public void setYzm(String yzm) {
		this.yzm = yzm;
	}
	public String getYanZhengMa() {
		return yanZhengMa;
	}
	public void setYanZhengMa(String yanZhengMa) {
		this.yanZhengMa = yanZhengMa;
	}
	
}
