<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.11.1.js"></script>
		<script type="text/javascript">
			function tp(){
				$("#imgVcode").prop("src","/DangDang2/image.servlet?id="+Math.random());
			}
			function emai(){
				var eml = $("#txtEmail").val();
				if(eml.endsWith("@qq.com")){
					$("#s1").html("格式正确").css("color","green");
					return true;
				}else{
					$("#s1").html("不能为空且以@qq.com结尾").css("color","red");
					return false;
				}
			}
			function name1(){
				if($("#txtNickName").val().length !=0){
					$("#s2").html("格式正确").css("color","green");
					return true;
				}else{
					$("#s2").html("昵称不能为空").css("color","red");
					return false;
				}
			}
			function pwd(){
				if($("#txtPassword").val().length !=0){
					$("#s3").html("格式正确").css("color","green");
					return true;
				}else{
					$("#s3").html("密码不能为空").css("color","red");
					return false;
				}	
			}
			function pwd1(){
				if($("#txtRepeatPass").val()==$("#txtPassword").val()){
					$("#s4").html("格式正确").css("color","green");
					return true;
				}else{
					$("#s4").html("两次密码不一致").css("color","red");
					return false;
				}	
			}
			function change(){
				if(emai()&name1()&pwd()&pwd1()){
					return true;
				}else{
					return false;
				}
			}
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="<s:url action="users_regist" namespace="/main"/>" id="f" onsubmit="return change()">
				<h2>
					以下均为必填项
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="users.email" type="text" id="txtEmail" value="@qq.com" class="text_input" onblur="emai()"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
									<span id="s1"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="users.uname" type="text" id="txtNickName" class="text_input" onblur="name1()"/>
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="s2" ></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="users.upassword" type="password" id="txtPassword"
								class="text_input" onblur="pwd()"/>
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="s3"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" type="password" id="txtRepeatPass"
								class="text_input" onblur="pwd1()"/>
							<div class="text_left" id="repeatPassValidMsg">
							<span id="s4"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="${pageContext.request.contextPath}/image.servlet" />
							<input name="yzm" type="text" id="txtVerifyCode"
								class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									
									<span id="number.info" style="color:red"></span>
									<a href="javascript:void(0)" onclick="tp()">看不清楚？换个图片</a>
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

