<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">添加</a></li>
		</ul>
	</div>
	<div class="formbody">

		<div class="formtitle">
			<span>基本信息</span>
		</div>
		<div>
			<form action="<%=request.getContextPath() %>/AddStudentServlet" method="post" class="forminfo">
				<label>STUDENTNAME</label>
				<br>
				<input type="text" name="stuName" class="scinput" placeholder="请正确输入名字" >
				<span id="stuNameMsg"></span>
				<br />
				<br />
				<label>STUDENTAGE</label>
				<br />
				<input type="text" name="stuAge" class="scinput" placeholder="请正确输入年龄">
				<span id="stuAgeMsg"></span>
				<br />
				<br />
				<label>STUDENTSEX：</label>
				<input type="radio" name="stuSex" value="男" checked="checked" >男
				<input type="radio" name="stuSex" value="女" >女
				<br />
				<br />
				<label>STUDENTHOBBY：</label>
				<input type="checkbox" name="stuHobby" id="" checked="checked" value="篮球">篮球
				<input type="checkbox" name="stuHobby" id="" value="足球">足球
				<input type="checkbox" name="stuHobby" id="" value="乒乓球">乒乓球
				<input type="checkbox" name="stuHobby" id="" value="保龄球">保龄球
				<input type="checkbox" name="stuHobby" id="" value="桌球">桌球
				<input type="checkbox" name="stuHobby" id="" value="桌球">桌球
				<br />
				<br />
				<label>STUDENTPHONE</label>
				<br />
				<input type="text" name="stuPhone" class="scinput" id="" placeholder="请正确输入手机号码">
				<span id="stuPhoneMsg"></span>
				<br />
				<label>STUDENTSCHOOL</label>
				<br />
				<select name="stuSchool" class="scinput" >
					<option value="-1">==请选择学校==</option>
					<option value="兰州交通大学">兰州交通大学</option>
					<option value="甘肃政法大学">甘肃政法大学</option>
					<option value="西北师范大学">西北师范大学</option>
					<option value="中国农业大学">中国农业大学</option>
				</select>
				<br />
				<br />
				<label>STUDENTADDRESS</label>
				<br />
				<input type="text" name="stuAddress" class="scinput" id="" placeholder="请正确输入详细地址">
				<span id="stuAddressMsg"></span>
				<br />
				<br />
				<label>USERDETAILS</label>
				<br />
				<textarea name="stuInfo" class="scinput" style="width:50%;height:100px;" placeholder="请输入基本信息" ></textarea>
				<br>
				<br>
				<input type="submit" class="btn" value="录入数据">
			</form>
		</div>
	</div>


</body>

</html>
