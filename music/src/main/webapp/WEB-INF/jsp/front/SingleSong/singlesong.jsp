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
<script src="/js/singlesong.js"></script>
</head>
<style>
.warp1{
	width:800px;
	height:1290px;
	margin:0px auto;
	border:1px solid #D3D3D3;
	background-color:white;
}
.warp2{
	width:90%;
	height:1230px;
	margin-top:40px;
	margin-left:40px;
/*  	border:1px solid #C40000;  */
}
.imgDiv{
	width:208px;
	height:208px;
	float:left;
}
img.img-top{
	width:100%;
	height:100%;
}
.playlistDesc{
	width:410px;
	height:300px;
	margin-right:30px;
	float:right;
/* 	border:1px solid #C40000; */
}
.tit{
	height:27px;
/* 	border:1px solid #4C0000; */
}
.titDesc{
	font-family:Arial;
	line-height:27px;
	font-weight:bold;
	margin-left:20px;
/* 	border:1px solid #4C0000; */
}
.athr-img{
	width:35px;
	height:35px;
}
.author{
	margin-top:10px;
	margin-left:2px;
}
.athr-ctime{
	color:#999999;
}
.tag{
	margin-top:10px;
}
.tag-desc{
	color:#666666;
}
p.intr{
	margin-top:10px;
}
b{
	color:#666666;
}
.song-list{
	width:100%;
	height:700px;
/* 	border:1px solid #C40000; */
}
.v-hd{
	width:100%;
	height:35px;
	border-bottom:2px solid #C40000;
}
.tit-hd{
	float:left;
}
.song-desc{
	font-family:Arial;
	font-size:22px;
	color:#333333;
}
.song-count{
	font-size:12px;
	color:#666666;
	margin-left:30px;
	display:inline-block;
}
.p-desc{
	margin-top:15px;
	float:right;
	font-size:12px;
}
.song-num{
	color:red;
}
.play-desc,.ci{
	color:#666666;
}
.t-song{
	width:100%;
	height:100%;
}
.tlt-t,.athor-t,.album-t{
	font-size:14px;
	color:#333333;
}
.time-t{
	font-size:14px;
	color:#999999;
}
td{
	text-align:center; /*设置水平居中*/
    vertical-align:middle;/*设置垂直居中*/
}
table.t-des th{  
	text-align: center;  
	vertical-align: middle!important;  
}
.imgDiv{
	border:1px solid #D5D5D5;
	padding:3px;
} 
a:hover {
	text-decoration: none !important;
}
.op-t{
	font-size:14px;
	color:#333333;
}
.black_overlay{
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index:1001;
	-moz-opacity: 0.8;
	opacity:.80;
	filter: alpha(opacity=80);
}
.white_content {
	display: none;
	position: absolute;
	top: 20%;
	left: 30%;
	width: 40%;
	height: 50%;
	border: 1px solid white;
	background-color: white;
	z-index:1002;
	overflow: auto;
}
.zbar {
    width:100%;
    height:38px;
    border-bottom: 1px solid #191919;
    background: #2d2d2d;
}
 .zttl {
    padding-right: 45px;
    margin: 0;
    height: 38px;
    line-height: 38px;
    padding-left: 18px;
    font-weight: bold;
    font-size: 14px;
    color: #fff;
    background-position: 50% 0;
    _background-image: none;
    float:left;
}
.zcls {
	font-size: 22px;
    float:right;
    width:8%;
    height:38px;
    line-height: 38px;
    color:#fff;
    text-align:center;
    cursor:pointer;
}
input:focus, textarea:focus, span:focus, a:focus, button:focus {
    outline: none;
}
ul{ 
	padding:0px; 
	margin:0px; 
} 
ul.pl-ul li { 
    padding: 6px 0 6px 35px; 
    border-top: 1px solid #e0e0e0; 
} 
.pl-ul{
	margin:0px;
	cursor:pointer;
}
.pl-tlt{
	width:80px;
	height:10px;
	margin-left:10px;
	display:inline-block;
	font-size:12px;
	font-family:Arial;
}
.pl-song-num{
	margin-left:50px;
	font-size:12px;
	font-family:Arial;
	color:#999999;
}
.pl-img-div{
	width:40px;
	height:40px;
	float:left;
}
.pl-img{
	width:100%;
	height:100%;
}
body{
	margin:0px;
	padding:0px;
}
</style>

<body style="background-color:#F5F5F5" onload="init()">
	<%@ include file="../Common/nav.jsp" %>
		<div class="warp1">
		<div class="warp2">
			<div class="imgDiv">
				<img src="${song.albumPic}" class="img-top">
			</div>
			<div class="playlistDesc">
				<div class="tit">
					<img src="/images/image_singlesong.png">
					<span class="titDesc">${song.stitle}</span>
				</div>
<!-- 				<div class="author"> -->
<!-- 					<a href="/#"> -->
<%-- 						<img src="${singlePlaylist.authorPic}" class="athr-img"> --%>
<!-- 					</a> -->
<!-- 					<span class="athr-name"> -->
<%-- 						<a href="/#">${singlePlaylist.author}</a> --%>
<!-- 					</span> -->
<%-- 					<span class="athr-ctime">${singlePlaylist.createTime}&nbsp;创建</span> --%>
<!-- 				</div> -->
<!-- 				<div class="tag"> -->
<!-- 					<span class="tag-desc">标签：</span> -->
<%-- 					<c:forEach items="${categorys}" var="item" varStatus="st"> --%>
<%-- 						<a href="${item.catLink}"> --%>
<%-- 							<span class="label label-info">${item.catName}</span> --%>
<!-- 						</a> -->
<%-- 					</c:forEach> --%>
<!-- 				</div> -->
				<p id="album-desc-dot" class="intr"><b>歌词：</b>
					${song.lyric}
				</p>
			</div>
			<div style="clear:both"></div>
			<div class="song-list" id="song-list">
				<div class="v-hd">
					<div class="tit-hd">
						<span class="song-desc">歌曲列表</span>
						<span class="song-count">1首</span>
					</div>	
<!-- 					<div class="p-desc"> -->
<!-- 						<a href="#nowhere" class="play-desc">播放：</a> -->
<%-- 						<span class="song-num" id="song-num">${singlePlaylist.playNum}</span> --%>
<!-- 						<span class="ci">次</span> -->
<%-- 						<input type="hidden" id="pid" value="${singlePlaylist.pid}"> --%>
<!-- 					</div> -->
				</div>
				<div class="t-song">
					<table class="table table-striped table-bordered table-hover t-des">
						<thead>
							<tr>
								<th>&nbsp;</th>
								<th>歌曲标题</th>
								<th>时长</th>
								<th>歌手</th>
								<th>专辑</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${songs}" var="mItem" varStatus="st">
								<tr>
									<td class="td-t">
										<audio src="${mItem.path}" controls="controls" id="mp3Btn">
											您的浏览器不支持播放
										</audio>
									</td>
									<td class="td-t">
										<a href="/#">
											<span class="tlt-t">
												${mItem.stitle}
											</span>
										</a>
									</td>
									<td class="td-t">
										<span class="time-t">
											${mItem.stime}
										</span>
									</td>
									<td class="td-t">
										<a href="/#">
											<span class="athor-t">
												${mItem.singer}
											</span>
										</a>
									</td>
									<td class="td-t">
										<a href="/#">
											<span class="album-t">
												${mItem.albumName}
											</span>
										</a>
									</td>
									<td class="td-t">
										<a href="javascript:void(0);" onclick="ShowDiv('MyDiv','fade',${mItem.id})" title="收藏">
											<span class="glyphicon glyphicon-plus op-t" ></span>
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div id="fade" class="black_overlay">
	</div>
	<div id="MyDiv" class="white_content">
		<div class="zbar">
			<div class="zttl f-thide">添加到歌单</div>
			<div class="zcls" onclick="CloseDiv('MyDiv','fade')">x</div>
		</div>
		<div class="xtag">
			<ul  style="list-style-type:none" class="pl-ul" id="pl-ul">
				</ul>
		</div>
	</div>
	<%@ include file="../Common/footer.jsp" %>
</body>