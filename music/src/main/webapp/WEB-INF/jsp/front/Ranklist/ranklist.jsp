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

<script src="/js/ranklist.js"></script>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/1.10.0/jquery.min.js"></script>
</head>

<style>
.wrap-1{
	width:800px;
	height:1200px;
	margin:0px auto;
	border:1px solid #D3D3D3;
	overflow:hidden;
}
.wrap-list{
	width:200px;
	height:1200px;
	background-color:#F9F9F9!important;
	float:left;
}
.wrap-body{
	width:598px;
	height:1200px;
	background-color:#FFF;
	display:inline-block;
	padding-left:40px;
}
.body-hd{
	margin-top:30px;
}
.f-ff1{
    display: block;
    font-size: 1.5em;
    font-weight: bold;
	text-align:center;
}
ul *{
    cursor: pointer;
    vertical-align: middle;
}
.list-group-item{
	background-color:#F9F9F9;
}

img.msk{
	width:40px;
	height:40px;
}
.name {
    width: 120px;
    overflow: hidden;
    margin-top: 2px;
    margin-bottom: 8px;
	display:inline-block;
}
.name-a{
	color:#000;
	text-decoration:none;
}
.name-a:hover{
	color:#000;
	text-decoration:none;
}
.hd-img{
	float:left;
	padding-top:20px;
	padding:2px;
	border:1px solid #CCCCCC;
}
.hd-img img{
	width:150px;
}
.hd-desc{
	padding-left:20px;	
	display:inline-block;
}
.hd-tlt{
	display: block;
    font-size: 1.5em;
    font-weight: bold;
	
}
.s-fc1{
	color:#666666;
}
.s-fc2{
	color:#999999;
}
.btns{
	margin-top:20px;
}
.u-btn{
	width:64px;
	height:31px;
	border:1px solid #C8C6C6;
	border-radius:5px;
	font-size:14px;
	font-family:Arial;
	display:inline-block;
	background-color:#589FE0;
	color:#FFF;
	text-align:center;
	line-height:31px;
}
.u-btn:hover{
	color:#FFF;
	text-decoration:none;
}
.body-song-list{
	margin-top:30px;
	padding: 0 30px 40px 0px;

}
.u-title-1 {
    height: 33px;
}
.u-title {
    height: 40px;
    border-bottom: 2px solid #c20c0c;
}
.u-title-1 h3 {
    line-height: 0px;
}

.u-title h3 {
    float: left;
    font-size: 24px;
    font-weight: normal;
}
h3 {
    display: block;
    font-weight: bold;
}
.f-ff2 {
    font-family: "Microsoft Yahei", Arial, Helvetica, sans-serif;
}
.u-title-1 .sub {
    margin: 9px 0 0 20px;
}
.u-title .sub {
    float: left;
    margin: 13px 0 0 10px;
}
.s-fc3, a.s-fc3:hover {
    color: #666;
}
.s-fc3, a.s-fc3:hover {
    color: #666;
}
.u-title-1 .more {
    margin-top: 5px;
}
.u-title .more {
    float: right;
    margin-top: 14px;
}
.s-fc3, a.s-fc3:hover {
    color: #666;
}
.f-cb:after {
    clear: both;
    content: '.';
    display: block;
    height: 0;
    visibility: hidden;
}
.s-fc6{
	color:#D86363;
}
.u-list{
	font-size:12px;
}
.song-rank{
	vertical-align:middle!important;
}
.song-img{
	width:50px;
	height:50px;
}
.song-play{
	padding-left:8px;
}
.song-time{
	color:#666;
	vertical-align:middle!important;
}
.song-singer{
	vertical-align:middle!important;
}
.song-singer-a{
	color:#000;
}
body{
	background-color:#F5F5F5;
}
.list-group-item{
	border:0px !important;
	background-color:#F9F9F9 !important;
}
.btn-audio{
	vertical-align:middle;
    width: 20px;
    height: 20px;
    background:url(images/voice_stop.png) no-repeat center bottom;
    background-size:cover;
    display:inline-block;
    cursor:pointer;
}
th {
    text-align: center!important;
}
td{
	font-size:12px;
	font-family:Arial;
}
</style>
<body style="background-color:#F5F5F5">
<%@ include file="../Common/nav.jsp" %>
<div class="wrap-1">
	<div class="wrap-list">
		<h2 class="f-ff1">爱音乐特色榜</h2>
		<ul class="list-group">
			<c:forEach items="${ranklists}" var="ranklist" varStatus="st">
				<li class="list-group-item">
					<a href="javascript:void(0);" onclick="changeRanklist('${ranklist.rid}')" class="name-a">
						<img src="${ranklist.rpic}" class="msk">
						<p class="name">
							${ranklist.rname}
						</p>
					</a>
				</li>
			</c:forEach>
<!-- 			<li class="list-group-item"> -->
<!-- 				<a href="javascript:void(0);" onclick="changeRanklist('1')" class="name-a"> -->
<!-- 					<img src="/images/biao-sheng.jpg" class="msk"> -->
<!-- 					<p class="name"> -->
<!-- 						爱音乐飙升榜 -->
<!-- 					</p> -->
<!-- 				</a> -->
<!-- 			</li> -->
<!-- 			<li class="list-group-item"> -->
<!-- 				<a href="javascript:void(0);" onclick="changeRanklist('2')" class="name-a"> -->
<!-- 					<img src="/images/xin-ge.jpg" class="msk"> -->
<!-- 					<p class="name"> -->
<!-- 						爱音乐新歌榜 -->
<!-- 					</p> -->
<!-- 				</a> -->
<!-- 			</li> -->
<!-- 			<li class="list-group-item"> -->
<!-- 				<a href="javascript:void(0);" onclick="changeRanklist('3')" class="name-a"> -->
<!-- 					<img src="/images/yuan-chuang.jpg" class="msk"> -->
<!-- 					<p class="name"> -->
<!-- 						爱音乐原创榜 -->
<!-- 					</p> -->
<!-- 				</a> -->
<!-- 			</li> -->
		</ul>
	</div>
	<div class="wrap-body">
		<div class="body-hd">
			<div class="hd-img">
				<img src="${ranklist.rpic}">
			</div>
			<span class="hd-desc">
				<h2 class="hd-tlt">${ranklist.rname}</h2>
				<div class="cnt">
					<span class="glyphicon glyphicon-time" style="color:#B1B1B1;"></span>
					<span class="s-fc1">最近更新：${ranklist.rmodifytime}</span>
					<span class="s-fc2">(每周更新)</span>
					<input type="hidden" id="rid" value="${ranklist.rid}">
				</div>
				<div class="btns">
					<a href="javascript:void(0);" onclick="play()" class="u-btn" >
						<span class="glyphicon glyphicon-play-circle" style="color:#FFFFFF;"></span>
						播放
					</a>
					<a href="javascript:void(0);" onclick="downloadMusic()" class="u-btn">
						<span class="glyphicon glyphicon-download-alt" style="color: #FFFFFF;"></span>
						下载
					</a>
				</div>
			</span>
		</div>
		<div style="clear:both"></div>
		<div class="body-song-list">
			<div class="u-title u-title-1 f-cb">
				<h3><span class="f-ff2">歌曲列表</span></h3>
				<span class="sub s-fc3"><span>${total}</span>首歌</span>
				<div class="more s-fc3">播放：<strong class="s-fc6" id="play-count">${ranklist.rplaynum}</strong>次</div>
			</div>
			<div class="u-list">
				<table class="table table-bordered table-striped" id="table-rank">
					<thead>
						<tr>
							<th>序号</th>	
							<th>标题</th>
							<th>时长</th>
							<th>歌手</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${songs}" var="song" varStatus="st">
							<tr>
								<td class="song-rank">${song.id}</td>
								<td>
									<div class="tlt-desc-2">
										<img src="${song.albumPic}" class="song-img">
<!-- 										<span class="glyphicon glyphicon-play-circle song-play" style="color:#797979;"></span> -->
										<div class="btn-audio" onclick="playmusic(this)" id="mp3Div">
											<audio id="mp3Btn">
												<source src="${song.path}" type="audio/mpeg" />
											</audio>
										</div>
										<span class="song-name">${song.stitle}</span>
									</div>
								</td>
								<td class="song-time">${song.stime}</td>
								<td class="song-singer" valign="middle">
									<a href="#" class="song-singer-a">
										${song.singer}
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
<%@ include file="../Common/footer.jsp" %>
</body>