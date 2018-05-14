<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<%    
String path = request.getContextPath();   
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 

<style>

div.head{
	width:1124px;
	height:100px;
	border-bottom:2px solid #C40000;
	display:block;
}

div.head_picture{
	width:80%;
	height:100%;
	float:left;
}

div.head_picture img{
	width:100%;
	height:100%;
}

div.adminDesc{
	float:right;
	height:100%;
	width:15%;
}

span.topRightDesc{
	font-size:14px;
	font-family:Arial;
	margin-top:80px;
	margin-left:10px;
	display:inline-block;
	
}

a.header_a{
	text-decoration:none;
}

</style>

<div class="head"> 
	<div class="head_picture">
		<img src="<%=basePath %>/images/head1.jpg" /> 
	</div>
	<div class="adminDesc">
		<span class="topRightDesc">
			<c:choose>
				<c:when test="${hour< 12 && hour >= 5}">上午好！</c:when>
				<c:when test="${hour >= 12 && hour < 18}">下午好！</c:when>
				<c:otherwise>晚上好！</c:otherwise>
			</c:choose>
		${login_system_user['name']}
		</span>
		<span class="topRightDesc">|</span>
		<span class="topRightDesc"><a class="header_a" href="/logout" target="_top">退出</a></span>
	</div>
</div>