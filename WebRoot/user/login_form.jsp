<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="<s:url value="/css/login.css"/>" rel="stylesheet" type="text/css" />
		<link href="<s:url value="/css/page_bottom.css"/>" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<s:url value="/jquery/jquery-1.11.1.js"/>"></script>
		<script type="text/javascript">
			function change(){
				if(emai() & pwd ()){
					return true;
				}else{
					return false;
				}
			}
			function emai(){
				var eml = $("[name=email]").val();
				if(eml.endsWith("@qq.com")){
					$("#s1").html("格式正确").css("color","green");
					return true;
				}else{
					$("#s1").html("不能为空且以@qq.com结尾").css("color","red");
					return false;
				}
			}
			function pwd(){
				if($("[name=upassword]").val().length!=0){
					$("#s2").html("格式正确").css("color","green");
					return true;
				}else{
					$("#s2").html("不能为空").css("color","red");
					return false;
				}
			}
		</script>
		
	</head>
	<body>


		<%@include file="../common/head1.jsp"%>

		<div class="enter_part">

			<%@include file="../common/introduce.jsp"%>

			<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red" id="divErrorMssage">
					
					</div>
					<div class="main">
						<h3>
							登录当当网
						</h3>

						<form method="post" action="<s:url action="users_login" namespace="/main"/>" id="ctl00" onsubmit="return change()">
							<ul>
								<li>
									<span>请输入Email地址：</span>
									<input type="text" value="@qq.com" name="email" id="txtUsername" class="textbox" onblur="emai()"/>
									<input type="hidden" value="<s:property value="bj"/>" name="bj"/>
									<input type="hidden" value="<s:property value="bid"/>" name="bid"/>
								</li>
								<div id="s1"></div>
								<li>
									<span class="blank">密码：</span>
									<input type="password" name="upassword" id="txtPassword"
										class="textbox" onblur="pwd()"/>
									<span id="s2"></span>
								</li>
								<li>
									<input type="submit" id="btnSignCheck" class="button_enter"
										value="登 录" />
								</li>
							</ul>
							<input type="hidden" name="uri" value="${uri}" />
						</form>
					</div>
					<div class="user_new">
						<p>
							您还不是当当网用户？
						</p>
						<p class="set_up">
							<a href="register_form.jsp">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>

	</body>
</html>