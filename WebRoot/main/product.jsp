<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<style type="text/css">
		ul li {
			text-decoration: none;
			list-style-type: none;
			line-height: 20px;
		}
		
		body {
			font-family: 宋体, Arial, Helvetica, sans-serif;
			font-size: 12px;
			background: #769b72 url(../images/booksaleimg/bg_grad.gif) top center
				no-repeat;
			cursor: default;
			color: #404040;
			margin: 0;
			padding: 0;
		}
	</style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.11.1.js"></script>
	<script type="text/javascript">
		function goumai(id){
			var result = confirm("是否确认购买");
			if(result){
				location='<s:url action="shoppingCart_add" namespace="/main"/>?bid='+id;
			}
		}
	</script>
</head>
<body>
	<div style="width: 60%;margin:20px auto;">
		<div style="width:100%;float: left;">
			<h1>
				
			</h1>
			<span><font color="#cccccc">丛书名：<s:property value="book.bname"/></font></span>
			<hr />
			<div>
				<div style="float: left;width:20%;">
					<img src="${pageContext.request.contextPath}/productImages/<s:property value="book.bimg"/>"  border=0 />
				</div>
				<div style="float: left;width:80%">
					<ul class="info">
						<li>作&nbsp;者：<s:property value="book.author"/></li>
						<li>出版社：中国出版社</li>
						<li style="float:left;width:50%;">出版时间：<s:property value="book.time"/></li>
						<li style="float:left;width:50%;">字数：10万</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">版次：1</li>
						<li style="float:left;width:50%;">页数：25</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">印刷时间：2018-09-25</li>
						<li style="float:left;width:50%;">开本：4	</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">印次：3</li>
						<li style="float:left;width:50%;">纸张：500</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">ISBN：INAWHFWE</li>
						<li style="float:left;width:50%;">包装：精品</li>
						<li>
							<div class='your_position'>
								您现在的位置:&nbsp; <a href='${pageContext.request.contextPath}/main/main.jsp'><font style='color: #cc3300'><strong>当当图书</strong></font></a> &gt;&gt;
								<a href='<s:url action="book_selectPage" namespace="/main"/>?cid=<s:property value="cid"/>&pid=0'>
								<font style='color: #cc3300'> 
									<strong> <s:property value="pname"/> </a>
								&gt;&gt;</strong>
								</font>
								<a href='<s:url action="book_selectPage" namespace="/main"/>?cid=<s:property value="cid"/>&pid=<s:property value="pid"/>'>
								<font style='color: #cc3300'> 
									<strong><s:property value="cname"/>
										</strong></font></a>
								
								
							</div>
						</li>
						<li>定价：￥<s:property value="book.bprice"/>&nbsp;&nbsp;
							当当价：<s:property value="book.dprice"/>￥&nbsp;&nbsp; 节省：￥<s:property value="book.bprice-book.dprice"/></li>
						<li><a href="javascript:void(0)"> <img
								src='${pageContext.request.contextPath}/images/buttom_goumai.gif' class="abc"
								onclick='goumai(<s:property value="bid"/>)' />
						</a></li>
					</ul>
				</div>
				<div style="float: clear;"></div>
			</div>
		</div>
	</div>
</body>
</html>