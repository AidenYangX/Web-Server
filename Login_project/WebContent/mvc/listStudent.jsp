<%@page import="com.cxsw.web.service.StudentsServiceImpl"%>
<%@page import="com.cxsw.web.service.StudentsService,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String,Object>> data =  (List<Map<String,Object>>)request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询全部的信息</title>
<style>
	table{
		text-align: center;
		width: 100%;
		min-height: 100px;
	}
	table,tr,th,td{
		border: 1px solid #ff0;
	}
	
</style>
</head>
<body>
	<%-- 测试数据<%=data %> --%>
	<%-- <%
		StudentsService stus = new StudentsServiceImpl();
		List<Map<String,Object>> data = stus.queryAll();
	%> --%>
	<table>
		<tr>
			<th>STUID</th>
			<th>STUNAME</th>
			<th>STUSEX</th>
			<th>STUSCHOOL</th>
			<th>STUPHONE</th>
		</tr>
	<%
		for(Map<String,Object> map :data){
			%>
			<tr>
				<td>
					<%=map.get("stu_id")==null?"":map.get("stu_id").toString() %>
				</td>
				<td>
					<%=map.get("stu_name")==null?"":map.get("stu_name").toString() %>
				</td>
				<td>
					<%=map.get("stu_sex")==null?"":map.get("stu_sex").toString() %>
				</td>
				<td>
					<%=map.get("stu_school")==null?"":map.get("stu_school").toString() %>
				</td>
				<td>
					<%=map.get("stu_phone")==null?"":map.get("stu_phone").toString() %>
				</td>
			</tr>
			<%
		}
		%> 
		
		
	</table>
	<hr>
	<hr>
</body>
</html>