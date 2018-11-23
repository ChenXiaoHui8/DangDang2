package com.baizhi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// ǿ��ת��
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		// ��ȡsession����,����ȡ���������
		String username =(String)request.getSession().getAttribute("name");
		// �ж������Ƿ�Ϊ��
		if(username != null){
			// �����Ϊ�վͷ���
			chain.doFilter(req,res);
		}else{
			// ���Ϊ�գ����ض��򵽵�¼ҳ��
			response.sendRedirect(request.getContextPath()+"/user/login_form.jsp");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
