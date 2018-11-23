package com.baizhi.action;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baizhi.entity.Order;
import com.baizhi.entity.ShoppingCart;
import com.baizhi.entity.Users;
import com.baizhi.service.OrderService;
import com.baizhi.service.ShoppingCartService;
import com.baizhi.service.impl.OrderServiceImp;
import com.baizhi.service.impl.ShoppingCartServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class OrderAction extends ActionSupport {
	private Order order;
	private ShoppingCartService scs = new ShoppingCartServiceImpl();
	private OrderService os = new OrderServiceImp();
	private int bj;
	private List<Order> orderList;
	private String[] ids;
	private String out_trade_no;
	@Autowired
	private OrderService orderservice;
	
	public String add(){
		System.out.println("------进入添加订单add--------");
		// 自动生成一个订单号captcha 
		char[] codeChar = "0123456789".toCharArray();
        String orderNumber = ""; // 存放生成的订单号
        Random random = new Random();
        for(int i = 0; i < 16; i++) { // 循环将每个字符到订单号中
            int index = random.nextInt(codeChar.length);
            orderNumber += codeChar[index];
        }
      
        
        Date date = new Date();
        order.setDate(date);
		order.setOrderNumber(orderNumber);
		Users users = (Users) ActionContext.getContext().getSession().get("users");
		int uid = users.getUid();
		List<ShoppingCart> shoppingRecList = scs.selectShoppingCart(uid, 0);
		order.setScList(shoppingRecList);
		scs.deleteAll(uid);
		orderservice.add(order);
		return "order_ok.jsp";
	}
	
	public String updateStatus(){
		System.out.println("========进入支付成功action==========");
		orderservice.updateStatus(out_trade_no);
		return "pay_ok.jsp";
	}
	
	public String deleteMany(){
		if(ids.length!=0){
			orderservice.deleteMany(ids);
		}
		return"selectAll";
	}
	
	public String selectAll(){
		System.out.println("------进入查询订单selectAll-------------");
		if(ActionContext.getContext().getSession().get("users")==null){
			bj = 4;
			return "login_form.jsp";
		}else{
			Users users = (Users) ActionContext.getContext().getSession().get("users");
			int uid = users.getUid();
			orderList = orderservice.selectAll(uid);
			return"my_order.jsp";
		}	
	} 
	public Order getOrder() {
		return order;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderService getOs() {
		return os;
	}



	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public void setOs(OrderService os) {
		this.os = os;
	}




	public int getBj() {
		return bj;
	}

	public void setBj(int bj) {
		this.bj = bj;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public ShoppingCartService getScs() {
		return scs;
	}

	public void setScs(ShoppingCartService scs) {
		this.scs = scs;
	}
	
}
