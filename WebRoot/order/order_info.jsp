<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.11.1.js"></script>
		<script type="text/javascript">
			function jiaqian(){
				var num = 0;
				$(".number").each(function(i,obj){
					var number = $(obj).html();
					var dprice = parseInt($(obj).parent().prev().html());
					$(obj).parent().next().html(number*dprice);
					num += number*dprice;
				});
				$("#zongji").html(num);
				
			}
			function tiao(){
				var num = $("#zongji").html();
			
				location='<s:url action="address_selectAll" namespace="/main"/>?totalPrice='+num;
			}
			$(function(){
				jiaqian()
			});
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单骤:
			<span class="red_bold">1.确认订单</span> > 2.填写送货地址 > 3.订单成功
		</div>
		<div class="fill_message">

			<table class="tab_login">
				<tr>
					<td valign="top" class="w1" style="text-align: left">
						<b>序号</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品名称</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品单价</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品数量</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>小计</b>
					</td>
				</tr>

				<!-- 订单开始 -->
				<s:iterator value="shoppingRecList" status="sta">
					<tr>
						<td valign="top">
							<s:property value="#sta.index+1"/>
						</td>
						<td valign="top">
							<s:property value="book.bname"/>
						</td>
						<td valign="top">
							<s:property value="book.dprice"/>
						</td>
						<td valign="top">
							<span class="number"><s:property value="number"/></span>
						</td>
						<td valign="top">
							
						</td>
					</tr>
					
				</s:iterator>
				<!-- 订单结束 -->
				<tr>
					<td valign="top" class="w1" style="text-align: left" colspan="5">
						<b>总价￥<span id="zongji"></span></b>
					</td>
				</tr>
			</table>
			<br />
			<br />
			<br />
			<div class="login_in">
				
				<a href="<s:url action="shoppingCart_selectShopping" namespace="/main"/>"><input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="取消" /></a>
				<input type="hidden" name=""/>
				<a href="javascript:viod(0)" onclick="tiao()"><input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" /></a>
				
				
			</div>

		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

