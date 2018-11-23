package com.baizhi.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baizhi.entity.Address;
import com.baizhi.entity.Users;
import com.baizhi.service.AddressService;
import com.baizhi.service.impl.AddressServiceImp;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class AddressAction extends ActionSupport {
	private List<Address> addressList;
	private AddressService as = new AddressServiceImp();
	private static int uid;
	private int bj;
	private int id;
	private Address address;
	private double totalPrice;
	@Autowired
	private AddressService addressservice;
	
	public String select(){
		System.out.println("------进入地址的select-------------");
		if(ActionContext.getContext().getSession().get("users")==null){
			bj = 1;
			return "login_form.jsp";
		}else{
			Users users = (Users) ActionContext.getContext().getSession().get("users");
			uid = users.getUid();
			addressList = addressservice.select(uid);
			
			return"my_address.jsp";
		}
	}
	// 查询用于收货地址
	public String selectAll(){
		System.out.println("------进入地址的selectAll-------------");
		System.out.println("总价钱："+totalPrice);
		Users users = (Users) ActionContext.getContext().getSession().get("users");
		uid = users.getUid();
		addressList = addressservice.select(uid);
		return"address_form.jsp";
	}
	public String add(){
		System.out.println("-----进入添加地址add-----------");
		address.setUid(uid);
		System.out.println(address);
		addressservice.add(address);
		return"select";
	}
	
	public String updateDefault(){
		System.out.println("-----进入修改默认地址updateDefault-------");
		addressservice.updateDefault(uid, id);
		return"select";
	}
	public String updateDelete(){
		System.out.println("********进入删除状态updateDelete---------");
		addressservice.updateDeleteStatus(id);
		return "select";
	}
	

	
	
}
