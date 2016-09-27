<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="/css/admin.css">
    
 </head>
 <body>
   <header>
   	  <img src="/images/adminTit.png">
   	  <div class="loginState"><span >${user.username },你好！&nbsp;|</span><a href="/logout">&nbsp;注销</a></div>
   </header>
   <div class="content">
     <div class="left">
     	<ul>
     		<li>
     			<a href="/courseGroup.adm" class="menu-item" target="right">课程组管理</a>
     		</li>
     		<li>
     			<a href="/course.adm" class="menu-item" target="right">课程管理</a>
     		</li>
     		<li>
     			<a href="/teacher.adm" class="menu-item" target="right">教师管理</a>
     		</li>
     		<li>
     			<a href="/student.adm" class="menu-item" target="right">学生管理</a>
     		</li>
     		
     		<li>
     			<a href="/news.adm" class="menu-item" target="right">新闻管理</a>
     		</li>
     	</ul>
     </div>
     <div class="right" >
     	<iframe frameborder="0" scrolling="no" name="right" src="/courseGroup.adm"></iframe>
     </div>
     
   	
   </div>
   <footer>
   	  
   </footer>
 </body>
</html>