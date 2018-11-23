<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.11.1.js"></script>
		<script type="text/javascript">
 			function alteration(obj,bid){
 				var num = $(obj).prev(":text").val();
 				location='<s:url action="shoppingCart_updateNum" namespace="/main"/>?bid='+bid+'&number='+num;
 				sum();
 			}
 			function sum(){
 				var jiesheng = 0;
 				var zongqian = 0;
 				$(".number").each(function(i,obj){
 					// 获取数量标签的值
 					var num = $(obj).html();
 					
 					// 获取
 					var dprice = parseInt($(obj).parent().prev().find("span").html());
 					
 					var bprice =parseInt($(obj).parent().prev().prev().find("span").html());
 					
 					jiesheng += num *(bprice-dprice);
 					zongqian += num*dprice;
 				});
 				$("#jiesheng").html(jiesheng);
 				$("#zongji").html(zongqian);
 			}
 			$(function(){
 				sum();
 			});
		</script>
	
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="${pageContext.request.contextPath}/images/pic_myshopping.gif" />

		</div>
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>封面</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
                      <!-- 购物列表开始 -->
                      <s:iterator value="shoppingRecList">
						<tr class='td_no_bord'>
							<td class="buy_td_6">
								<span ><img src='${pageContext.request.contextPath}/productImages/<s:property value="book.bimg"/>' height="50px" width="58px"/> </span>
							</td>
							<td>
								<span class="span_w1"><a href='<s:url action="book_selectOne" namespace="/main"/>?bid=<s:property value="bid"/>'><s:property value="book.bname"/></a></span>
							</td>
							<td class="bprice">
								￥<span class="c_gray"><s:property value="book.bprice"/></span>
							</td>
							<td class="dprice">
								&nbsp;&nbsp;
								￥<span><s:property value="book.dprice"/></span>
							</td>
							<td >
								&nbsp;&nbsp;<span class="number"><s:property value="number"/></span>
							</td>

							<td>
								<input class="del_num" type="text" size="3" maxlength="4" value='<s:property value="number"/>'/>
								<a href="javascript:void(0)" onclick="alteration(this,<s:property value="bid"/>)">变更</a>
							</td>
							<td>
								<a href='<s:url action="shoppingCart_updateStatusDelete" namespace="/main"/>?uid=<s:property value="uid"/>&bid=<s:property value="bid"/>'>删除</a>
							</td>
						</tr>
						
						<%-- <tr class='td_no_bord'>
							<td class="buy_td_6">
								<span ><img src="../productImages/2.jpg" height="50px" width="58px"/> </span>
							</td>
							<td>
								<span class="span_w1"><a href="#">Java框架大全</a></span>
							</td>
							<td class="buy_td_5">
								<span class="c_gray">180</span>
							</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span>￥35</span>
							</td>
							<td class="buy_td_1">
								&nbsp;&nbsp;100
							</td>

							<td >
								<input class="del_num" type="text" size="3" maxlength="4"/>
								<a href="#">变更</a>
							</td>
							<td>
								<a href="#">删除</a>
							</td>
						</tr> --%>
						</s:iterator>
					<!-- 购物列表结束 -->
				</table>
				<s:if test="shoppingRecList.size()==0">
					<div class="choice_title"></div>
					<div class="no_select">
						您还没有挑选商品
					</div>
				</div>
				</s:if>
				<div class="choice_balance">
					<div class="select_merch">
					
						<a href='${pageContext.request.contextPath}/main/main.jsp'> 继续挑选商品>></a>
					</div>
					<s:else>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="jiesheng"></span>
							</span>
							<span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span
								class="c_red"> ￥<span id='span_vip_economy'>0.00</span> </span>
								) </span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='zongji'></span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='<s:url action="shoppingCart_select" namespace="/main"/>' > 
								<img src="${pageContext.request.contextPath}/images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
						</s:else>
					</div>
				</div>
			</div>
		</div>

		<!-- 用户删除恢复区 -->

		
		<div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			<table class=tabl_del id=del_table>
				<tbody>
				<s:iterator value="shoppingDelList">

					<tr>
						<td width="58" class=buy_td_6>
							<span><img src='${pageContext.request.contextPath}/productImages/<s:property value="book.bimg"/>' height="50px" width="58px"/></span>
						</td>
						<td width="365" class=t2>
							<a href='<s:url action="book_selectOne" namespace="/main"/>?bid=<s:property value="bid"/>'><s:property value="book.bname"/></a>
						</td>
						<td width="106" class=buy_td_5>
							￥<s:property value="book.bprice"/>
						</td>
						<td width="134" class=buy_td_4>
							<span>￥<s:property value="book.dprice"/></span>
						</td>
						<td width="56" class=buy_td_1>
							<a href="<s:url action="shoppingCart_delete" namespace="/main"/>?uid=<s:property value="uid"/>&bid=<s:property value="bid"/>">移除该商品</a>
						</td>
						<td width="56" class=buy_td_1>
							&nbsp;&nbsp;<a href="<s:url action="shoppingCart_updateStatusRecover" namespace="/main"/>?uid=<s:property value="uid"/>&bid=<s:property value="bid"/>">恢复</a>
						</td>
						<td width="16" class=objhide>
							&nbsp;
						</td>
					</tr>
					</s:iterator>

	
					<tr class=td_add_bord>
						<td colspan=8>
							&nbsp;
						</td>
					</tr>


				</tbody>
			</table>
		</div>
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>



