<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片回显及图片上传</title>
<!-- 引入 js 文件 -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/upload.js"></script>
</head>
<body>
	<!-- 
		1.问题：图片资源预览
		1.答：使用 js 文件 upload.js
		注：若有文件上传操作，需要在form 表单中支持文件上传： enctype="multipart/form-data"
	 -->
	<form action="<%=request.getContextPath()%>/AddImgServlet"
		method="post" enctype="multipart/form-data">
		<img id="imgView" alt=""
			src="<%=request.getContextPath()%>/imgs/default.png"
			style="width: 100px; height: 110px; border: 1px solid #fff;"> 
		<br>
		<label>文件描述</label>
		<input type="text" name="imgDec" placeholder="请添加文件描述信息">
		<br> 
		<input type="file" name="fileName" onchange="previewImage(this,'imgView')">
		<br>
		<br>
		<input type="submit" value="文件上传">
	</form>
</body>
</html>