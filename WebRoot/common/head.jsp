<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<link href="<s:url value="/css/book_head090107.css"/>" rel="stylesheet" type="text/css" />
<div class="head_container">
	<div class="head_welcome">
		<div class="head_welcome_right">
			<span class="head_welcome_text"> </span>
			<span class="head_welcome_text"> <span class="little_n">
					| <a href="<s:url action="address_select" namespace="/main"/>" name="myaddress" class="head_black12a">我的收货地址</a>
					| <a href="<s:url action="order_selectAll" namespace="/main"/>" name="mydangdang" class="head_black12a">我的订单</a> | <a
					href="#" name="helpcenter" class="head_black12a" target="_blank">帮助</a>
					| </span> </span>
			<div class="cart gray4012">
				<a href='<s:url action="shoppingCart_selectShopping" namespace="/main"/>'>购物车</a>
			</div>
		</div>
		<span class="head_toutext" id="logininfo">
		<b>您好<font color="red"><s:property value="#session.users.uname"/></font>，欢迎光临当当网</b>
		<s:if test="#session.users==null">
		[&nbsp;<a href="<s:url value="/user/login_form.jsp"/>" class="b">登录</a>]
		[<a
			href="<s:url value="/user/register_form.jsp"/>" class="b">注册</a>&nbsp;]
		</s:if>
		<s:else>
		[&nbsp;<a href='<s:url action="users_logout" namespace="/main"/>' class="b">登出</a>&nbsp;]
		
		</span>
		</s:else>
	</div>
	<div class="head_head_list">
		<div class="head_head_list_left">
			<span class="head_logo"><a href='<s:url value="/main/main.jsp"></s:url>' name="backtobook"><img
						src="<s:url value="/images/booksaleimg/book_logo.gif"/>" /> </a> </span>
		</div>
		<div class="head_head_list_right">

			<div class="head_head_list_right_b">
			</div>
		</div>
	</div>
	<div class="head_search_div">

	</div>
	<div class="head_search_bg"></div>
</div>
