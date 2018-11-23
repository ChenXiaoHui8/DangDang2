package com.baizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;
import com.baizhi.entity.ShoppingCart;

public interface ShoppingCartService {
	// չʾ���й��ﳵ
	public List<ShoppingCart> selectShoppingCart(int uid ,int statusId);
	
	// �޸�Ϊɾ��״̬
	public void updateStatusDelete(int uid , int bid);
	
	// �޸�Ϊ�ָ�״̬
	public void updateStatusRecover(int uid ,int bid);
	
	// ���ﳵ���
	public void add(int uid , int bid);
	//	����ɾ����ͼ��
	public void delete(int uid , int bid);
	// �޸Ĺ��ﳵ��ͼ����Ʒ������
	public void updateNum(int uid , int bid , int number); 
	
	// ��չ��ﳵ
	public void deleteAll(int uid);

}
