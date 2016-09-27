<%@page import="cn.etl.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student list</title>
</head>
<body>
	<table>
		<%List<Student> list=(List<Student>)request.getAttribute("list");
		for(Student s:list){
		%>
		<tr>
		<td><%=s.getUsername() %></td>
		<td><%=s.getPassword() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>