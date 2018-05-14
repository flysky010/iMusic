<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!-- <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script> -->
<!-- <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/js/playlist.js">

</script>
<style>
.playlists{
	width:800px;
	height:1024px;
	margin:0px auto;
	border:1px solid #D3D3D3;
	background-color:white;
}
.warp-playlist{
	width:80%;
	height:100%;
	margin-top:40px;
	margin-left:80px;
/* 	border:1px solid #C40000; */
}
.v-hd{
	width:100%;
	height:60px;
	border-bottom-style:solid;
	border-bottom-width:2px;
	border-bottom-color:#C40000;
}
.tit-hd{
	float:left;
}
div.tit-hd a.tit{
	text-decoration:none;
	color:#333333;
	font-family:Arial;
	font-size:16px;
}
.btn-group{
	display:inline-block;
	margin-top:15px;
	margin-left:20px;
}
.playlist{
	width:100%;
	height:80%;
}
span.songDesc{
	display:block;
	color:#000;
}
.playlistUnit{
	width:159px;
	height:160px;
	float:left;
	padding-left:3px;
	padding-right:3px;
	margin-top:30px;
	margin-bottom:10px;
}
img.songImg{
	width:100%;
	height:140px;
}
a.zbtn {
    height: 24px;
    line-height: 24px;
    color: #333;
    text-align: left;
    padding: 0;
}
.zpgi {
    margin: 0 1px 0 2px;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 2px;
    vertical-align: middle;
    width:20px;
    height:25px;
}
.pager{
	overflow:hidden;
}
</style>

<body style="background-color:#F5F5F5" onload="run()">
	<%@ include file="../Common/nav.jsp" %>
	<div class="playlists">
		<div class="warp-playlist">
			<div class="v-hd">
				<div class="tit-hd">
					<h3 id="catName">
						${name}
					</h3>
				</div>
				<div class="btn-group">
				    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
				    	选择分类
				        <span class="caret"></span>
				    </button>
				    <ul class="dropdown-menu" id="dropdown-menu-title" role="menu">
				    	<li>
				            <a href="javascript:void(0);" onclick ="getPlaylistByType('1')">热门</a>
				        </li>
				    	<li>
				            <a href="javascript:void(0);" onclick="getPlaylistByType('2')">流行</a>
				        </li>
				        <li>
				            <a href="javascript:void(0);" onclick="getPlaylistByType('3')">摇滚</a>
				        </li>
				        <li>
				            <a href="javascript:void(0);" onclick="getPlaylistByType('4')">民谣</a>
				        </li>
				        <li>
				            <a href="javascript:void(0);" onclick ="getPlaylistByType('5')">华语</a>
				        </li>
				        
				    </ul>
				</div>
			</div>
			<div class="playlist">
				<c:forEach items="${playlists}" var="pItem" varStatus="st">
					<div class="playlistUnit">
					<a href="javascript:void(0);" onclick="toSinglePlaylist(${pItem.id})">
						<img src="${pItem.path}" width=100px class="songImg">
					</a>
					<a href="javascript:void(0);" onclick="toSinglePlaylist(${pItem.id})">
					<span class="songDesc">${pItem.title}</span>
					</a>
					</div>
				</c:forEach>
			</div>
			<div style="clear:both"></div>
			<div class="pager">
				<a href="javascript:void(0);" onclick="getPrePage()" class="zbtn">上一页</a>
				<select id="selectNum" onchange="getCurrentPage2()">
					<c:forEach items="${listPage}" var="pItem" varStatus="st">
						<c:choose>
							<c:when test="${pItem.serNum == curNum}">
								<option value="${pItem.serNum}"  selected>${pItem.serNum}</option>
							</c:when>
							<c:otherwise>
								<option value="${pItem.serNum}" >${pItem.serNum}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				<a href="javascript:void(0);" onclick="getNextPage()" class="zbtn">下一页</a>
			</div>
		</div>
	</div>
	<%@ include file="../Common/footer.jsp" %>
</body>
</html>