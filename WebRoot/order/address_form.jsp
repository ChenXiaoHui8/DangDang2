<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>生成订单 - 当当网</title>
<link href="../css/login.css" rel="stylesheet" type="text/css" />
<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
<link href="../css/address.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../jquery/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(function(){
		 
	})
	function yangshi(){
		$("li").prop("class","address-wrap")
		$(".marker-tip").html("");
		$(":checked").parent().parent().prop("class","address-wrap selected").children(":eq(0)").children().html("寄送至");	
	}
	function dianji(){
		var num = $(":checked").size();
		if(num==0){
			alert("您还没有选择收货地址，请选择");
			return false;
					
		}
		return true;
	}
</script>
</head>
<body>
	<%@include file="../common/head1.jsp"%>
	<div class="login_step">
		生成订单骤: 1.确认订单 ><span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
	</div>
	<div class="fill_message">
		 
		 <form action="<s:url action="order_add" namespace="/main"/>" method="post" onsubmit="return dianji()">
			 <div class="address-wrap">
				<ul class="address-list">
				<input type="hidden" name="order.totalPrice" value='<s:property value="totalPrice"/>'/>
				<s:iterator value="addressList">
				<s:if test="defaultStatus==1">
					 <li class="address-wrap selected">
					<div class="addressBox">
						<span class="marker-tip">寄送至</span>
					</div> 
					<label class="addressInfo">
						
						<input type="radio" name="order.aid" value="<s:property value="aid"/>"  onclick="yangshi()"
						checked='checked'/>
						<span class="user-address">
							<span ><s:property value="address"/> </span>
							<span></span>
							<span>（</span>
							<span><s:property value="aname"/></span>
							<span> 收）</span>
							<em><s:property value="phone"/></em>
						</span>
					</label>
				</li>
				</s:if>
				<s:else>
				 <li class="address-wrap">
					<div class="addressBox">
						<span class="marker-tip"></span>
					</div> 
					<label class="addressInfo">
						
						<input type="radio" name="order.aid" value="<s:property value="aid"/>" onclick="yangshi()"
						/>
						<span class="user-address">
							<span ><s:property value="address"/> </span>
							<span></span>
							<span>（</span>
							<span><s:property value="aname"/></span>
							<span> 收）</span>
							<em><s:property value="phone"/></em>
						</span>
					</label>
				</li>
				</s:else>
				<%-- <li class="address-wrap">
					<label class="addressInfo">
						<input type="radio" name="address"/>
						<span class="user-address">
							<span >河南省 郑州市 金水区 文化路街道 </span>
							<span>文化路82号硅谷广场A座13A16(14层)百知教育</span>
							<span>（</span>
							<span>段小翔</span>
							<span> 收）</span>
							<em>15637128565</em>
						</span>
					</label>
				</li> --%>
				</s:iterator>
				</ul>
			</div>
			
			<div class="login_in">
				<input
					id="btnClientRegister" class="button_1" name="submit" type="submit"
					value="下一步" />
			</div>
			
		</form>
	</div>
	<%@include file="../common/foot1.jsp"%>
</body>
</html>

