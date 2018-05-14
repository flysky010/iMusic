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
	<form action="updateFileInfo.do" method="post">
		<input type="hidden" name="sid" value="${song.sid}"/>
		<ul class="list-group">
			<li class="list-group-item">
				<span class="userLabel"><label>专辑：</label></span>
				<input class="userInput" name="albumName" type="text" value="${song.albumName}"  maxLength="50"/>
			</li>
			<li class="list-group-item">
				<span class="userLabel"><label>歌曲：</label></span>
				<input class="userInput" name="stitle" type="text" value="${song.stitle}"  maxLength="50"/>
			</li>
			<li class="list-group-item">
				<span class="userLabel"><label>歌手：</label></span>
				<input class="userInput" name="singer" type="text" value="${song.singer}"  maxLength="50"/>
			</li>
<!-- 			<li class="list-group-item"> -->
<!-- 				<span class="userLabel"><label>状态：</label></span> -->
<%-- 				<input type="radio" id="forever" name="state" <c:if test="${user.state==1}">checked="checked"</c:if>  value="1"><label for="forever">启用</label> --%>
<%-- 				<input type="radio" id="casual" name="state" <c:if test="${user.state==0}">checked="checked"</c:if> value="0"><label for="casual">禁用</label> --%>
<!-- 			</li> -->
		</ul>
		<div class="ytweb-form-btn">
         	<input type="submit" class="fileAddBtn" value="保存" />  
			<input type="button" class="fileCacelBtn" value="取消" onclick="javascript:history.back(-1);"/>
       </div>
	</form>
</div>
