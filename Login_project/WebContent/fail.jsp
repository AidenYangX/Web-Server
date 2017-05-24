<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath }/css/style.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>

<script>
	$(function() {
		$('.error').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 490) / 2
		});
		$(window).resize(function() {
			$('.error').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 490) / 2
			});
		})
		var time = $("b#tim").html();
		var setIntVal = setInterval(function(){
			time -- ;
			$("b#tim").html(time);
			if(time == 0){
				clearInterval(setIntVal);
				window.location="${pageContext.request.contextPath}/login.jsp";
			}
		},1000);
	});
</script>


</head>


<body style="background: #edf6fa;">

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">404错误提示</a></li>
		</ul>
	</div>

	<div class="error">

		<h2>非常遗憾，您输入的用户名或密码不正确！</h2>
		<p>
			页面<b id="tim" style="color: red">3</b>秒后自动跳转，若没有自动跳转!
		</p>
		<div class="reindex">
			请手动点击下方按钮<a href="${pageContext.request.contextPath }/login.jsp"
				target="_parent">登录</a>
		</div>

	</div>


</body>

</html>
