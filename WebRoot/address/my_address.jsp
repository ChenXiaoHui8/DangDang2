<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>收获地址管理 - 当当网</title>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			我的收货地址：
		</div>
		<div class="fill_message">

			<table class="tab_login">
				<tr>
					<td valign="top" class="w1" style="text-align: left">
						<b>序号</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货地址编号</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货人姓名</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货人地址</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货人联系方式</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货地址状态</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>操作</b>
					</td>
				</tr>

				<!-- 收货地址开始 -->
				<s:iterator value="addressList" status="sta">
				<tr>
					<td valign="top">
						<s:property value="#sta.index+1"/>
					</td>
					<td valign="top">
						<s:property value="aid"/>
					</td>
					<td valign="top">
						 <s:property value="aname"/>
					</td>
					<td valign="top">
						  <s:property value="address"/>
					</td>
					<td valign="top">
						   <s:property value="phone"/>
					</td>
					<s:if test="defaultStatus==0">
						<td valign="top">
							<a href="<s:url action="address_updateDefault" namespace="/main"/>?id=<s:property value="aid"/>">设置成默认地址</a>     
						</td>
					</s:if>
					<s:else>
						<td valign="top">
							<font color="red">默认地址   </font>
						</td>
					</s:else>
					
					<td valign="top">
						  <a  href="<s:url action="address_updateDelete" namespace="/main"/>?id=<s:property value="aid"/>">删除</a>
					</td>
				</tr>
				<!-- <tr>
					<td valign="top">
							2
					</td>
					<td valign="top">
							2
					</td>
					<td valign="top">
						           李四
					</td>
					<td valign="top">
						        花园路北环
					</td>
					<td valign="top">
						   654789
					</td>
					<td valign="top">
						  <a  href="#">设置为默认</a>
					</td>
					<td valign="top">
						  <a  href="#">删除</a>
					</td>
				</tr>
				<tr>
					<td valign="top">
							3
					</td>
					<td valign="top">
							3
					</td>
					<td valign="top">
						           王五
					</td>
					<td valign="top">
						    CBD
					</td>
					<td valign="top">
						   654789
					</td>
					<td valign="top">
						  <a href="#">设置为默认</a>
					</td>
					<td valign="top">
						  <a  href="#">删除</a>
					</td>
				</tr> -->
				<!--收货地址结束 -->
				</s:iterator>
			</table>
			
			<div style="margin: 50px;text-align: center;">
				<a href="${pageContext.request.contextPath}/address/add_address.jsp">添加新的收货地址</a>
				<a href="${pageContext.request.contextPath}/main/main.jsp">
					<input 	class="button_1"  type="button" value="返回主页面" />
				</a>  
	    	</div>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html> 
