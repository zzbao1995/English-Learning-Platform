<%@page import="java.net.URLEncoder"%>
<%@page import="cn.etl.util.FileUtil"%>
<%@page import="cn.etl.controller.FileController"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
	.mylink{
	display :block;
	}
</style>
</head>
<body>
	
	<%
	File[] files=(File[])request.getAttribute("files");
	String servletPath = (String)request.getAttribute("servletPath");
	String cate = servletPath.split("/")[2];
	if(files!=null) for(File f:files){
	String linkUrl = servletPath;
	if(cate.equals("exercise"))
		linkUrl = "/MINIC/"+servletPath+"/"+f.getName();
	if(cate.equals("courseware"))
		linkUrl = "/MINIC/file/download?fileName="+f.getName()+"&servletPath="+servletPath;
	else if(cate.equals("video"))
		linkUrl = "/MINIC/player.jsp?playsrc="+servletPath+"/"+f.getName();
	%>
	<a href="<%=linkUrl%>" class="<%=cate%> mylink" ><%=f.getName() %></a>
	<%}%>
</body>
</html>