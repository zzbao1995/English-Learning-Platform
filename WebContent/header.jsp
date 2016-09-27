<%@page import="cn.etl.entity.Course"%>
<%@page import="cn.etl.entity.CourseGroup"%>
<%@page import="java.util.List"%>
<%@page import="cn.etl.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="js/ReadingC&C.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div class="address">
		<img class="en" src="images/en.png"> <a id="add" href="">123456@mail.cn</a>
		<%
			User u = (User) session.getAttribute("user");
			if (null == u) {
		%>
		<a class="loginOut" href="/loginPage">登录</a>
		<%
			} else {
		%>
		<a class="loginOut" href="/logout">注销</a> <img class="user"
			src="images/user.png">
		<%
			}
		%>
	</div>

	<!--导航条  -->
	<div class="menu">
		<span class="title">MINIC</span> <img class="search"
			src="images/search.png">
		<ul class="navigation">
			
			<%
				List<CourseGroup> cgList = (List<CourseGroup>) request
						.getAttribute("cGList");
				List<Course> cList = (List<Course>) request.getAttribute("cList");
				int i = 0, j = 0;
				if (cgList != null && cList != null)
					while (i < cgList.size()) {
						CourseGroup cg = cgList.get(i);
						i++;
			%>
			<li class="navigation0"><a><%=cg.getgName() %></a>
				<ul class="navigation1">
					<em></em>
					<li>
					<%
						
								while (j < cList.size()) {
								Course c = cList.get(j);
								j++;
								if(!(c.getId().substring(0,2).equals(cg.getId())))
								break;
								
					%>
					<a class="navi" href=""><%=c.getcName() %></a> 
					<% 
								
								} 
						if(cg.getUrls()!=null&&cg.getUrlNames()!=null)
						{
						String[] urls = cg.getUrls().split(";");
						String[] urlNames = cg.getUrlNames().split(";");
						for(int k=0;k<urls.length;k++)
						{
					%>
						<a class="navi" href="<%=urls[k]%>"><%=urlNames[k] %></a>
					<%  }
						}%>
					</li>
					
				</ul>
		   </li>
			<%
				}
			%>
			
			<!-- 辅助平台 -->
			<li class="navigation0"><a>辅助平台</a>
				<ul class="navigation1">
					<em></em>
					<li><a class="navi" href="">学习平台</a> <a class="navi" href="">新闻平台</a>
						<a class="navi" href="">测试平台</a></li>
				</ul>
			</li>

			<li class="navigation0"><a>辅助系统</a>
				<ul class="navigation1">
					<em></em>
					<li><a class="navi" href="">多模态语料库</a> <a class="navi" href="">口语自主测试</a>
						<a class="navi" href="">学术论文评测系统</a> <a class="navi" href="">语言与思维实训基地</a></li>
				</ul></li>
		</ul>



	</div>
</body>
</html>