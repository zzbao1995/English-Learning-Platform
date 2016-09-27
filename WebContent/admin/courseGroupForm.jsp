<%@page import="cn.etl.entity.CourseGroup"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="/js/form.js"></script>
<title></title>
</head>
<body>
	
	<form action ='/courseGroup/${(empty action)?"add":"modify"}' method="post"  role="form" 
	class="form-horizontal asyn-form" >
			<label>课程组ID</label>
			<select name="id" id="${ele.id }" class="select">
				<option value="01">01</option>
				<option value="02">02</option>
				<option value="03">03</option>
				<option value="04">04</option>
				<option value="05">05</option>
				<option value="06">06</option>
				<option value="07">07</option>
				<option value="08">08</option>
				<option value="09">09</option>
			</select>
			<label >课程组名称</label>
			<input name="gName"  class="form-control" value="${ ele.gName}" required>&nbsp;&nbsp;
			<button type="button">添加链接</button>
			<div class="urls">
			<%
			CourseGroup cg = (CourseGroup)request.getAttribute("ele");
			if(cg!=null&&cg.getUrls()!=null)
			{
				String[] urls = cg.getUrls().split(";");
				String[] urlNames = cg.getUrlNames().split(";");
				for(int k=0;k<urls.length;k++)
					{
				%>
				<div class="url">
					<label>链接名称</label>
					<input name="_urlNames" value="<%=urlNames[k]%>">
					<label >链接地址</label>
					<input name="_urls"  class="form-control" value="<%=urls[k] %>" required>&nbsp;&nbsp;
					<button type="button" class="del">删除</button>
				</div>
				<%  } }%>
			</div>
			
		<button type="submit" class="btn btn-default">提交</button>
		
	</form>
	<script type="text/javascript">
	var msg = '${msg}';
    if(msg!='') alert(msg);
	</script>
</body>
</html>