package com.baizhi.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baizhi.entity.Book;
import com.baizhi.entity.ShoppingCart;
import com.baizhi.entity.Users;
import com.baizhi.service.ShoppingCartService;
import com.baizhi.service.impl.ShoppingCartServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class ShoppingCartAction extends ActionSupport {
	private ShoppingCartService scs = new ShoppingCartServiceImpl();
	private List<ShoppingCart> shoppingDelList;
	private List<ShoppingCart> shoppingRecList;
	private static int uid;
	private int bid;
	private int number;
	private int bj;
	@Autowired
	private ShoppingCartService shoppingcartservice;
	// 展示所有购物车商品
	public String selectShopping(){
		System.out.println("------进入购物车展示页面selectShopping-------");
		if(ActionContext.getContext().getSession().get("users")==null){
		
			bj = 2;
			return "login_form.jsp";
		}else{
			Users users = (Users) ActionContext.getContext().getSession().get("users");
			uid = users.getUid();
			shoppingDelList = shoppingcartservice.selectShoppingCart(uid, 1);
			shoppingRecList = shoppingcartservice.selectShoppingCart(uid, 0);
			return "cart_list.jsp";
		}
	}
	public String select(){
		System.out.println("------进入购物车确认订单select-------");
		shoppingRecList = shoppingcartservice.selectShoppingCart(uid, 0);
		return"order_info.jsp";
	}
	// 添加新的商品
	public String add(){
		System.out.println("------进入购物车添加add-------");
		if(ActionContext.getContext().getSession().get("users")==null){
			bj = 3;
			return "login_form.jsp";
		}else{
			Users users = (Users) ActionContext.getContext().getSession().get("users");
			uid = users.getUid();
			shoppingcartservice.add(uid, bid);
			return "selectShopping";
		}
	}
	
	// 点删除修改为删除状态
	public String updateStatusDelete(){
		System.out.println("------进入修改删除状态updateStatusDelete-------");
		shoppingcartservice.updateStatusDelete(uid, bid);
		return "selectShopping";
		
	}
	// 点恢复修改为恢复状态
	public String updateStatusRecover(){
		System.out.println("------进入修改恢复状态updateStatusDelete-------");
		shoppingcartservice.updateStatusRecover(uid, bid);
		return "selectShopping";
	}
	// 彻底删除该商品
	public String delete(){
		System.out.println("------进入彻底删除商品-------");
		shoppingcartservice.delete(uid, bid);
		return "selectShopping";
	}
	
	// 变更商品数量
	public String updateNum(){
		System.out.println("------------进入更改商品数量updateNum-----------");
		shoppingcartservice.updateNum(uid, bid, number);
		return"selectShopping";
	}
	public int getBj() {
		return bj;
	}

	public void setBj(int bj) {
		this.bj = bj;
	}


	
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public ShoppingCartService getScs() {
		return scs;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setScs(ShoppingCartService scs) {
		this.scs = scs;
	}

	

	public List<ShoppingCart> getShoppingDelList() {
		return shoppingDelList;
	}

	public void setShoppingDelList(List<ShoppingCart> shoppingDelList) {
		this.shoppingDelList = shoppingDelList;
	}

	public List<ShoppingCart> getShoppingRecList() {
		return shoppingRecList;
	}

	public void setShoppingRecList(List<ShoppingCart> shoppingRecList) {
		this.shoppingRecList = shoppingRecList;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
}
