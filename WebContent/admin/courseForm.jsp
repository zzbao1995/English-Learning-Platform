<%@page import="cn.etl.entity.CourseGroup"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="/js/form.js"></script>
</head>
<body>
	
	<form action ='/course/${(empty action)?"add":"modify"}' method="post"  role="form" 
	class="form-horizontal asyn-form" >
		<label>课程名称</label>
		<input name="cName"  class="form-control" value="${ ele.cName}" required>&nbsp;&nbsp;
		<label >所属课程组</label>
		<select name="gId" id="${gId }" class="select" reuqired>
			<c:forEach items="list" var="cg">
			<option value="${cg.id }">${cg.gName }</option>
			</c:forEach>
		</select>
		<label >册数</label>
		<select name="cIndex" class="select" id="${cIndex }" required>
			<option value="01">第一册</option>
			<option value="02">第二册</option>
			<option value="03">第三册</option>
			<option value="04">第四册</option>
			<option value="05">第五册</option>
			<option value="06">第六册</option>
		</select>	
		<button type="submit" class="btn btn-default">提交</button>
		
	</form>
	<script type="text/javascript">
	var msg = '${msg}';
    if(msg!='') alert(msg);
	</script>
</body>
</html>