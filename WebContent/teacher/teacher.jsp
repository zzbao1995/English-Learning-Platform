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
     			<a href="/file.tea" class="menu-item" target="right">资源管理</a>
     		</li>
     		
     	</ul>
     </div>
     <div class="right" >
     	<iframe frameborder="0" scrolling="no" name="right" src="/file.tea"></iframe>
     </div>
     
   	
   </div>
   <footer>
   	  
   </footer>
 </body>
</html>