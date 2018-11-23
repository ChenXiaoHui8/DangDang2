<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>订单</title>
		<link rel="stylesheet"href="../css/dingdan.css"type="text/css">
	</head>
	<body>
		<form action='<s:url action="order_deleteMany" namespace="/main"></s:url>' method="post">
		<table class="table-head table-mod">
			<tbody>
				<tr>
					<th width="331px">宝贝</th>
					<th>单价</th>
					<th>数量</th>
					<th>实付款</th>
					<th>交易状态</th>
				</tr>
			</tbody>
		</table>
		<s:iterator value="orderList">
		<div class="dom">
			<label>
				<span class="time">
					<input type="checkbox" name="ids" value="<s:property value="orderNumber"/>"/>
					<span class="time"><s:property value="date"/></span>
				</span>
				<span>
					<span>订单号</span>
					<span>:</span>
					<span><s:property value="orderNumber"/></span>
				</span>
			</label>
		</div>
		<table class="tb">
			<s:iterator value="scList" status="sta">
			<tr>
				<td width="330px">
					<div style="display: block;">
						<a href="<s:url action="book_selectOne" namespace="/main"/>?bid=<s:property value="book.bid"/>&cid=<s:property value="book.cid"/>"><img width="76" height="109" src="${pageContext.request.contextPath}/productImages/<s:property value="book.bimg"/>" style="float: left;"/></a>
						<p style="width: 230px; margin-left:10px; float: left;">
							<a href="<s:url action="book_selectOne" namespace="/main"/>?bid=<s:property value="book.bid"/>&cid=<s:property value="book.cid"/>"><span class="sp"><s:property value="book.bname"/></span></a>
						</p>
					</div>
				</td>
				<td width="238px" align="center">
					<div>
						<p>$<s:property value="book.dprice"/></p>
					</div>
				</td>
				<td width="238px" align="center"><s:property value="number"/></td>
				<s:if test="#sta.index==0">
				<td class="boder" rowspan="<s:property value="scList.size()"/>">￥<s:property value="totalPrice"/></td>
				<td class="boder" width="239px" rowspan="<s:property value="scList.size()"/>">
					<s:if test="orderStatus=='已支付'">
						<div>
							<p>交易成功</p>
							<p>订单详情</p>
						</div>
					</s:if>
					<s:elseif test="orderStatus=='未支付'">
						<div>
							<a href='/alipay.trade.page.pay-JAVA-UTF-8/index.jsp?orderId=<s:property value="orderNumber"/>&price=<s:property value="totalPrice"/>'>-->点击支付</a>
							<p>订单详情</p>
						</div>
					</s:elseif>
				</td>
				</s:if>
			</tr>
			
			
			<%-- <tr>
				<td width="330px">
					<div style="display: block;">
						<img src="../images/hf.jpg" style="float: left;"/>
						<p style="width: 230px; margin-left:10px; float: left;">
							<a href="javascript::"><span class="sp">自动充值 河南联通话费50元手机充值50元快充50元 及时到账</span></a>
						</p>
					</div>
				</td>
				<td width="238px" align="center">
					<div>
						<p>$49.95</p>
					</div>
				</td>
				<td width="238px" align="center">1</td>
			</tr> --%>
			
			
			</s:iterator>
		</table>
		</s:iterator>
		
		
		<div style="margin: 50px;text-align: center;">
				<a href="javascript:history.go(-1);">
				<input 	class="button_1"  type="button" value="取消" /></a>  
				<input type="submit" value="删除选择订单"/>
	    </div>
	    </form>
	</body>
</html>