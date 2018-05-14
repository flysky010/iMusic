<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<!-- <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!-- <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script> -->
<!-- <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/js/searchResult.js"></script>
</head>

<style>
.g-wrap-search{
	width:800px;
	height:1600px;
	margin:0px auto;
	border:1px solid #D3D3D3;
	background-color:#FFF;
	overflow:hidden;
}
.pgsrch{
    width: 420px;
    height: 40px;
    margin: 40px auto;
    background-position: 0 0;
    z-index: 10;
	border:1px solid #E3E3E3;
}	
input{
    font-size: 12px;
    color: #333;
    font-family: Arial, Helvetica, sans-serif;
	height:100%;
	width:370px;
	border:1px solid #E3E3E3;
	outline:none;
}
.g-srch{
	vertical-align:middle;
	margin-left:8px;
	display:inline-block;
}
.m-srch-body{
	width:90%;
	height:800px;
	margin-right:auto;
	margin-left:auto;
}
.s-note{
	width:100%;
	height:15px;
    margin: 28px 0 17px;
	color:#999;
	font-size:12px;
	font-family:Arial;
	line-height:15px;
}
.s-note:hover{
	color: #999;
}
.s-note-num{
	color: #c20c0c;
}
.m-tabs{
	width:100%;
	float:left;
}
#menu { 
	font:16px verdana, arial, sans-serif; 
}
#menu, #menu li {
	list-style:none;
	padding:0;
	margin:0;
}
#menu li { 
	float:left; 
}
#menu li a {
	display:block;
	width:143px;
	height:30px;
	line-height:30px;
	text-align:center;
	background:#F6F6F6;
	color:#000;
	text-decoration:none;
	border-top:2px solid #999;
	border-bottom:1px solid #F2F2F2;
	/*border-right:1px solid #000;*/
}
#menu li a:hover {
	background:#146C9C;
	color:#fff;
	text-decoration:none;
	border-right:1px solid #000;
}
#menu li a.last {
 border-right:0; /* 去掉左侧边框 */
}
.n-srchst{
	width:100%;
}
.n-srchsongst{
	width:100%;
	margin-top:20px;
}
.item{
	width:100%;
	height:43px;
	font-size:14px;
	font-family:Arial;
	line-height:43px;
	background-color:#F9F9F9;
}
.s-1{
	display:inline-block;
/* 	margin-left:50px; */
}
.s-2{
	display:inline-block;
	margin-left:250px;
}
.s-3{
	display:inline-block;
	margin-left:90px;
}
.s-4{
	display:inline-block;
	margin-left:75px;
}
.item:hover{
	border:1px solid #999;
}
body{
	background-color:#F5F5F5;
}
.btn-audio{
	vertical-align:middle;
    width: 20px;
    height: 20px;
    background:url(images/voice_stop.png) no-repeat center bottom;
    background-size:cover;
    display:inline-block;
    cursor:pointer;
    margin-left:50px;
}
.lyric {
    margin: 10px 0 18px 52px;
    color: #666;
    line-height: 23px;
    word-wrap: break-word;
    word-break: break-all;
}
</style>

<body onload="item_song_bkcolor()">
	<%@ include file="../Common/nav.jsp" %>
	<div class="g-wrap-search">
		<div class="pgsrch">
			<input id="m-search-input" type="text" class="srch j-flag" value="${sname}" style="opacity: 1;">
			<a href="javascript:void(0);" onclick="searchMusic()">
				<span class="glyphicon glyphicon-search g-srch" style="color:#B0B1B0; font-size: 23px;"></span>
			</a>
		</div>
		<div style="clear:both"></div>
		<div class="m-srch-body">
			<div class="s-note">
				搜索“${sname}”，找到
				<span class="s-note-num">${snum}</span>
				首单曲
			</div>
			<ul id="menu">
				<li><a id="li-1" href="javascript:void(0);" onclick="changeItem(1)">单曲</a></li>
				<li><a id="li-2" href="javascript:void(0);" onclick="changeItem(2)">歌词</a></li>
				<li><a id="li-3" href="javascript:void(0);" onclick="changeItem(3)">专辑</a></li>
				<li><a id="li-4" href="javascript:void(0);" onclick="changeItem(4)">歌单</a></li>
				<li><a id="li-5" href="javascript:void(0);" onclick="changeItem(5)">用户</a></li>
			</ul>
			<div style="clear:both"></div>
			<div class="n-srchst">
				<div class="n-srchsongst" id="dan-qu">
					<c:forEach items="${songs}" var="mItem" varStatus="st">
						<div class="item">
							<div class="btn-audio" onclick="playmusic(this)" id="mp3Div">
								<audio id="mp3Btn">
									<source src="${mItem.path}" type="audio/mpeg" />
								</audio>
							</div>
							<a href="#" class="s-1">
<!-- 								<span class="glyphicon glyphicon-play-circle" style="color:#797979;"></span> -->
								${mItem.stitle}
							</a>
							<span class="s-2">${mItem.singer}</span>
							<a href="#" class="s-3">${mItem.albumName}</a>
							<span class="s-4">${mItem.stime}</span>
						</div>
					</c:forEach>
				</div>
				<div class="n-srchsongst" id="ge-ci">
					<c:forEach items="${songs}" var="mItem" varStatus="st">
						<div class="item">
							<div class="btn-audio" onclick="playmusic(this)" id="mp3Div">
								<audio id="mp3Btn">
									<source src="${song.path}" type="audio/mpeg" />
								</audio>
							</div>
							<a href="#" class="s-1">
								${mItem.stitle}
							</a>
							<span class="s-2">${mItem.singer}</span>
							<a href="#" class="s-3">${mItem.albumName}</a>
							<span class="s-4">${mItem.stime}</span>
						</div>
						<div class="lyric">
							<div class="lyric-1">
								<div id="lrc_all417833754" class="f-hide">
									${mItem.lyric}
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../Common/footer.jsp" %>
</body>