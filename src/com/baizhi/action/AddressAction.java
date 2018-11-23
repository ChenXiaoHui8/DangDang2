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
		System.out.println("------�����ַ��select-------------");
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
	// ��ѯ�����ջ���ַ
	public String selectAll(){
		System.out.println("------�����ַ��selectAll-------------");
		System.out.println("�ܼ�Ǯ��"+totalPrice);
		Users users = (Users) ActionContext.getContext().getSession().get("users");
		uid = users.getUid();
		addressList = addressservice.select(uid);
		return"address_form.jsp";
	}
	public String add(){
		System.out.println("-----������ӵ�ַadd-----------");
		address.setUid(uid);
		System.out.println(address);
		addressservice.add(address);
		return"select";
	}
	
	public String updateDefault(){
		System.out.println("-----�����޸�Ĭ�ϵ�ַupdateDefault-------");
		addressservice.updateDefault(uid, id);
		return"select";
	}
	public String updateDelete(){
		System.out.println("********����ɾ��״̬updateDelete---------");
		addressservice.updateDeleteStatus(id);
		return "select";
	}
	

	
	
}
