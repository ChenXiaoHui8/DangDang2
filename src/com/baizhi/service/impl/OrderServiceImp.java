package com.baizhi.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhi.dao.BookDao;
import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Order;
import com.baizhi.entity.ShoppingCart;
import com.baizhi.service.OrderService;
@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderDao od;
	
	@Autowired
	private BookDao bd;
	
	@Override
	public void add(Order order) {
		
			List<ShoppingCart> scList = order.getScList();
			for(ShoppingCart sc:scList){
				od.add(order, sc);
				int bid = sc.getBid();
			
				int number = sc.getNumber();
				bd.update(bid, number);
			}

	}
	
	public List<Order> selectAll(int uid){
		
			return od.selectAll(uid);
		
	}
	
	public void deleteMany(String[] ids){
		
			od.deleteMany(ids);
		
	}
	
	public void updateStatus(String id){
		
			od.updateStatus(id);
			
		
	}

}
