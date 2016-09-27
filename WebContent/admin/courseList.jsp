<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<a href="/admin/courseForm.jsp" class="op">添加</a>
	<a class="op" onclick="del.submit()">删除选中条目</a>

    <br><br>
	<form action="/course/delete" method="post" class="asyn-form" id="del">
	<table>
		<tr><th>ID</th><th>名称</th><th>课程组</th><th>学分</th><th>负责人</th><th></th><th></th></tr>
		<c:forEach  var="ele" items="${pb.data }">

			<tr>
			
			<td>${ele.id}</td>
			<td>${ele.cName }</td>
			<td>${ele.gName }</td>
			<td>${ele.credits }</td>
			<td>${ele.chief }</td>
			<td></td>
			<td><a href="/course/courseForm/${ele.id }.fm">编辑</a></td>
			<td><input type="checkbox" name="id" value="${ele.id }"></td>
			</tr>

		</c:forEach>
	</table>
	
	</form>
	<center class="page">
			 <a href="/course/1/0.htm?view=/admin/courseList.jsp">&laquo;</a>&nbsp;&nbsp;&nbsp;&nbsp;
			 <a href="/course/${pb.prePage }/0.htm?view=/admin/courseList.jsp">&lsaquo;</a>&nbsp;&nbsp;&nbsp;&nbsp;
			 <span>${pb.pageIndex }/${pb.mxIndex }</span>&nbsp;&nbsp;&nbsp;&nbsp;
			 <a href="/course/${pb.nextPage }/0.htm?view=/admin/courseList.jsp">&rsaquo;</a>&nbsp;&nbsp;&nbsp;&nbsp;
			 <a href="/course/${pb.mxIndex }/0.htm?view=/admin/courseList.jsp">&raquo;</a>
	</center>
</body>
</html>