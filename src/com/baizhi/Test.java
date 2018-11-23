package com.baizhi;

import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baizhi.dao.BookDao;
import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Order;
import com.baizhi.service.AddressService;
import com.baizhi.service.BookService;
import com.baizhi.service.CategoryService;
import com.baizhi.service.OrderService;
import com.baizhi.service.ShoppingCartService;
import com.baizhi.service.UsersService;
import com.baizhi.service.impl.AddressServiceImp;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.CategoryServiceImp;
import com.baizhi.service.impl.OrderServiceImp;
import com.baizhi.service.impl.ShoppingCartServiceImpl;
import com.baizhi.service.impl.UsersServiceImpl;
import com.baizhi.util.MailUtil;


public class Test {
	
	public static void main(String[] args) {
		/*SqlSession sqlSession = MybatisUtils.getSqlSession();
		BookDao bd = sqlSession.getMapper(BookDao.class);
		System.out.println(bd.selectOne(1));
		
		sqlSession.close();*/
		
		
		/*SqlSession sqlSession2 = MybatisUtils.getSqlSession();
		BookDao bd2 = sqlSession2.getMapper(BookDao.class);
		System.out.println(bd2.selectOne(1));*/
		
		
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bs=(BookService) context.getBean("bookServiceImpl");
		System.out.println(bs.selectHot());
	}
}
