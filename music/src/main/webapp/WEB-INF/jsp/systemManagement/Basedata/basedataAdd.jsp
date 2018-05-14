<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="/js/basedata.js"></script>

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
.uploadfile{
	margin-left:83px;
	margin-top:5px;
	color: transparent;
	
}
.edit_cover{
	width:140px;
	height:140px;
}
</style>    

<%@ include file="../common/head.jsp" %>
<%@ include file="../common/left.jsp" %>
<div class="userEditDiv">
	<form action="addBasedata.do" method="post">
		<ul class="list-group">
			<li class="list-group-item">
				<span class="userLabel"><label>歌手：</label></span>
				<input class="userInput" id="singer" name="singer" type="text" value=""  maxLength="50"/>
			</li>
			<li class="list-group-item">
				<span class="userLabel"><label>专辑：</label></span>
				<input class="userInput" id="albumName" name="albumName" type="text" value=""  maxLength="50"/>
			</li>
			<li class="list-group-item">
				<span class="userLabel"><label>歌曲：</label></span>
				<input class="userInput" id="songName" name="songName" type="text" value=""  maxLength="50"/>
			</li>
			<li class="list-group-item">
				<span class="userLabel"><label>时长：</label></span>
				<input class="userInput" id="songTime" name="songTime" type="text" value=""  maxLength="50"/>
			</li>
			<li class="list-group-item">
				<span class="userLabel"><label>专辑封面：</label></span>
				<img id="edit_cover" class="edit_cover" src="">
				<input name="fileupload" type="file" onchange="showImg()" id="auto-id-input2" class="uploadfile">
			</li>
		</ul>
		<div class="ytweb-form-btn">
<!--          	<input type="submit" class="userAddBtn" value="保存" />   -->
         	<input type="button" class="userAddBtn" value="保存" onclick="save('/addBasedata.do')" />
			<input type="button" class="userCacelBtn" value="取消" onclick="javascript:history.back(-1);"/>
       </div>
	</form>
</div>
