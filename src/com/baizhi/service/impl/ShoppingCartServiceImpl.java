package com.baizhi.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhi.dao.BookDao;
import com.baizhi.dao.ShoppingCartDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.ShoppingCart;
import com.baizhi.service.ShoppingCartService;

@Service	
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Autowired
	private ShoppingCartDao scd;
	
	@Override
	public List<ShoppingCart> selectShoppingCart(int uid, int statusId) {
		 return scd.selectShoppingCart(uid, statusId);
			
		
	}

	@Override
	public void updateStatusDelete(int uid, int bid) {
		
			scd.updateStatusDelete(uid, bid);
	}
	

	@Override
	public void updateStatusRecover(int uid, int bid) {
		
			scd.updateStatusRecover(uid, bid);
			

	}

	@Override
	public void add(int uid, int bid) {

		ShoppingCart sc = null;
	
			sc = scd.selectOne(uid, bid);
			if(sc == null){
				scd.add(uid, bid);
			}else{
				sc.setNumber(sc.getNumber()+1);
				scd.updateNum(sc);
			}
			
	}
	
	
	public void updateNum(int uid , int bid , int number){
		
		ShoppingCart sc = new ShoppingCart(uid,bid,number);
	
			scd.updateNum(sc);
		
	}
	
	
	public void delete(int uid , int bid){
		
			scd.delete(uid, bid);
		
	}
	
	public void deleteAll(int uid){
		
			scd.deleteAll(uid);
	}
}
