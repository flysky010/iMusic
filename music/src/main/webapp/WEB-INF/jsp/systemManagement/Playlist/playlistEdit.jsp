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
	<form action="updatePlaylistMg.do" method="post">
		<input type="hidden" name="id" value="${playlist.id}"/>
		<ul class="list-group">
			<li class="list-group-item">
				<span class="userLabel"><label>类型：</label></span>
				<select name="typeName">
					<c:forEach items="${pts}" var="pt" varStatus="st">
						<option  value ="${pt.catName}">${pt.catName}</option>
					</c:forEach>
				</select>
			</li>
			<li class="list-group-item">
				<span class="userLabel"><label>歌单：</label></span>
				<input class="userInput" name="title" type="text" value="${playlist.title}"  maxLength="50"/>
			</li>
			<li class="list-group-item">
				<span class="userLabel"><label>是否显示：</label></span>
				<input type="radio" id="forever" name="isShow" <c:if test="${playlist.isShow==1}">checked="checked"</c:if>  value="1"><label for="forever">显示</label>
				<input type="radio" id="casual" name="isShow" <c:if test="${playlist.isShow==0}">checked="checked"</c:if> value="0"><label for="casual">隐藏</label>
			</li>
			<li class="list-group-item">
				<span class="userLabel"><label>是否首页轮播：</label></span>
				<input type="radio" id="forever" name="isCarousel" <c:if test="${playlist.isCarousel==1}">checked="checked"</c:if>  value="1"><label for="forever">是</label>
				<input type="radio" id="casual" name="isCarousel" <c:if test="${playlist.isCarousel==0}">checked="checked"</c:if> value="0"><label for="casual">否</label>
			</li>
		</ul>
		<div class="ytweb-form-btn">
         	<input type="submit" class="userAddBtn" value="保存" />  
			<input type="button" class="userCacelBtn" value="取消" onclick="javascript:history.back(-1);"/>
       </div>
	</form>
</div>
