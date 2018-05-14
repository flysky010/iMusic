<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
div.userEditDiv{
	position:absolute;
	top:100px;
	left:200px;
	width:924px;
	height:700px;
	margin:1px;
	font-size:12px;
	font-family:Arial;
}

div.userEditDiv ul.userUl{
	border:1px solid #999;
}

div.userEditDiv span.userLabel{
	width:80px;
	display:inline-block;
}

</style>    

<%@ include file="../common/head.jsp" %>
<%@ include file="../common/left.jsp" %>
<div class="userEditDiv">
	<form action="addUser.do" method="post">
		<ul class="list-group">
			<li class="list-group-item">
				<span class="userLabel"><label>用户名：</label></span>
				<input class="userInput" name="name" type="text" value="${user.name}"  maxLength="50"/>
			</li>
			<li class="list-group-item">
				<span class="userLabel"><label>密码：</label></span>
				<input class="userInput" name="password" type="text" value="${user.password}"  maxLength="50"/>
			</li>
			<li class="list-group-item">
				<span class="userLabel"><label>确认密码：</label></span>
				<input class="userInput" name="recPwd" type="text" value=""  maxLength="50"/>
			</li>
			<li class="list-group-item">
				<span class="userLabel"><label>状态：</label></span>
				<input type="radio" id="forever" name="state" <c:if test="${user.state==1}">checked="checked"</c:if>  value="1"><label for="forever">启用</label>
				<input type="radio" id="casual" name="state" <c:if test="${user.state==0}">checked="checked"</c:if> value="0"><label for="casual">禁用</label>
			</li>
		</ul>
		<div class="ytweb-form-btn">
         	<input type="submit" class="userAddBtn" value="保存" />  
			<input type="button" class="userCacelBtn" value="取消" onclick="javascript:history.back(-1);"/>
       </div>
	</form>
</div>
