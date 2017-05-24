<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/cloud.js"
	type="text/javascript"></script>

<script>
	$(function() {
		var ok1 = false;
		var ok2 = false;
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		})
		
		$("input[name='userName']").blur(function(){
			if(this.value==null||this.value.trim()==""){
				
				$("span#userNameMsg").html("<i>用户名不能为空</i>");
				
				
				return ;
			}else{
				$("span#userNameMsg").html("");
				ok1 = true;
			}
		})
		$("input[name='userPass']").blur(function(){
			if(this.value==null||this.value.trim()==""){
				$("span#userPassMsg").html("<i>密码不能为空</i>");
				return ;
			}else{
				$("span#userPassMsg").html("");
				ok2 = true;
			}
		})
		$("input[type='button']").click(function(){
			if(ok1&&ok2){
				$("form").submit();
			}else{
				$("span#userNameMsg").html("<i>用户名不能为空</i>");
				$("span#userPassMsg").html("<i>密码不能为空</i>");
			}
		})
	});
</script>

</head>

<body
	style="background-color: #1c77ac; background-image: url(images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">



	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>

	<div class="loginbody">

		<span class="systemlogo"></span>

		<div class="loginbox">
			<form action="<%=request.getContextPath()%>/LoginServlet"
				method="post">
				<ul>
					<li><input name="userName" type="text" class="loginuser"
						 placeholder="请正确输入用户名"  /> <span style="color:red;font-family: '宋体';"  id="userNameMsg"></span>
					</li>
					<li><input name="userPass" type="password" class="loginpwd"
						 placeholder="请正确输入密码" /> <span style="color:red;font-family: '宋体';" id="userPassMsg"></span>
					</li>
					<li><input type="button" class="loginbtn" value="登录" /><label>
							<input name="" type="checkbox" value="" checked="checked" />记住密码
					</label> <label><a href="#">忘记密码？</a></label></li>
				</ul>
			</form>

		</div>

	</div>



	<div class="loginbm">版权所有  &copy;2017-2018 | 创新思维 |仅供学习测试|勿用于任何商业用途</div>


</body>

</html>
