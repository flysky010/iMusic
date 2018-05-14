<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>爱音乐-iMusic</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/js/home.js" ></script>
</head>

<style>
div.home{
	width:800px;
	margin:0px auto;
}
nav.nav-bg{
    background-color: #C40000;
}
nav.navbar a{
	color:white;
	font-family:Arial;
}
.navbar {
    margin-bottom: 0px !important;/*覆盖原来的样式*/ 
}
.g-wrap3{
	width:100%;
	height:780px;
	background-color:white;
	border:1px solid #D3D3D3;
	overflow:hidden;
}
.g-wrap2{
	width:740px;
	margin:30px;
	margin-right:40px;
	height:700px;
/* 	border:1px solid #C40000; */
}
.v-hd{
	width:100%;
	height:30px;
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
.tab{
	float:left;
	padding:0px 20px;
}
div.tab a.s-fc3{
	text-decoration:none;
	color:#666666;
	font-size:12px;
	font-family:Arial;
}
div.tab span.line{
	padding:0px 10px;
	color:#CECECE;
}
span.more{
	float:right;
}
span.more a.s-fc3{
	text-decoration:none;
	color:#666666;
	font-size:12px;
	font-family:Arial;
}
.v-hd2{
	margin-top:20px;
	width:100%;
	height:30px;
	border-bottom-style:solid;
	border-bottom-width:2px;
	border-bottom-color:#C40000;
}
.tit-hd2{
	float:left;
}
span.more2{
	float:right;
}
div.tit-hd2 a.tit2{
	text-decoration:none;
	color:#333333;
	font-family:Arial;
	font-size:16px;
}
a.s-fc3-2{
	text-decoration:none;
	color:#666666;
	font-size:12px;
	font-family:Arial;
}
.playlist{
	width:100%;
	height:320px;
}
span.songDesc{
	display:block;
}
.playlistUnit{
	width:184px;
	height:160px;
	float:left;
	padding-left:3px;
	padding-right:8px;
	margin-top:10px;
}
img.songImg{
	width:100%;
	height:140px;
}
.charts{
	width:100%;
}
.chartUnit{
	width:33%;
	margin-right:1px;
	margin-left:1px;
	float:left;
	margin-top:10px;
}
span.chart-title{
	
}
.carousel-img{
	width:799px;
	height:368px !important;
	cursor:pointer;
}
a.plu-a {
	text-decoration:none;
	color:black;
}
a.plu-a:hover {
	text-decoration:none;
}
.num{
	color:#666666;
}
.songItem{
	color:black;
}
</style>

<body style="background-color:#F5F5F5" onload="loadData()">
	<div class="home">
		<%@ include file="../Common/nav.jsp" %>
		<div id="myCarousel" class="carousel slide">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
				<c:forEach items="${playlists}" var="playlist" varStatus="st">
					<li data-target="#myCarousel" data-slide-to="${playlist.id}"></li>
				</c:forEach>
<!-- 				<li data-target="#myCarousel" data-slide-to="0" class="active"></li> -->
<!-- 				<li data-target="#myCarousel" data-slide-to="1"></li> -->
<!-- 				<li data-target="#myCarousel" data-slide-to="2"></li> -->
			</ol>   
	
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner">
				<c:forEach items="${playlists}" var="playlist" varStatus="st">
					<div class="item">
						<img src="${playlist.path}" alt="First slide" class="carousel-img" onclick="toSinglePlaylist(${playlist.id})">
					</div>
				</c:forEach>
<!-- 				<div class="item active"> -->
<!-- 					<img src="/images/slide5.jpg" alt="First slide" class="carousel-img" onclick="toSinglePlaylist()"> -->
<!-- 				</div> -->
<!-- 				<div class="item"> -->
<!-- 					<img src="/images/slide6.jpg" alt="Second slide" class="carousel-img" onclick="toSinglePlaylist()"> -->
<!-- 				</div> -->
<!-- 				<div class="item"> -->
<!-- 					<img src="/images/slide8.jpg" alt="Third slide" class="carousel-img" onclick="toSinglePlaylist()"> -->
<!-- 				</div> -->
			</div>
			<!-- 轮播（Carousel）导航 -->
			<a class="carousel-control left carousel-left-next" href="#myCarousel" data-slide="prev"></a>
			<a class="carousel-control right" href="#myCarousel" data-slide="next"></a>
		</div>
		<div class="g-wrap3">
			<div class="g-wrap2">
				<div class="v-hd">
					<div class="tit-hd">
						<a href="javascript:void(0);" onclick="toPlaylist(1)" class="tit">
							<span class="glyphicon glyphicon-star-empty" style="color: rgb(255, 0, 0); font-size: 16px;">
							</span>
							热门推荐
						</a>
					</div>
					<div class="tab">
						<c:forEach items="${playTypes}" var="playType" varStatus="st">
							<a href="javascript:void(0);" onclick="toPlaylist(${playType.catId})" class="s-fc3">${playType.catName}</a>
							<span class="line">|</span>
						</c:forEach>
					</div>
					<span class="more">
						<a href="javascript:void(0)" onclick="toPlaylist(1)" class="s-fc3">更多</a>
						<span class="glyphicon glyphicon-arrow-right" style="color: rgb(255, 0, 0);"></span>
					</span>
				</div>
				<div class="playlist">
					<c:forEach items="${hotPlaylists}" var="hotItem" varStatus="st">
						<div class="playlistUnit">
							<a href="javascript:void(0);" onclick="toSinglePlaylist(${hotItem.id})" class="plu-a">
								<img src="${hotItem.path}" width=100px class="songImg">
								<span class="songDesc">${hotItem.pdesc}</span>
							</a>
						</div>
					</c:forEach>
<!-- 					<div class="playlistUnit"> -->
<!-- 						<a href=#nowhere> -->
<!-- 							<img src="/images/playlistOfChina_1.jpg" width=100px class="songImg"> -->
<!-- 						</a> -->
<!-- 						<span class="songDesc">一句话</span> -->
<!-- 					</div> -->
				</div>
				<div style="clear:both"></div>
				<div class="v-hd2">
					<div class="tit-hd2">
						<a href="/ranklist.do" class="tit2">
							<span class="glyphicon glyphicon-star-empty" style="color: rgb(255, 0, 0); font-size: 16px;">
							</span>
							榜单
						</a>
					</div>
					<span class="more2">
						<a href="/ranklist.do" onclick="" class="s-fc3-2">更多</a>
						<span class="glyphicon glyphicon-arrow-right" style="color: rgb(255, 0, 0);"></span>
					</span>
				</div>
				<div class="charts">
					<div class="list-group chartUnit">
						<a href="#" class="list-group-item active">
				        	<img src="${rkUp.rpic}" style="width:80px;height:80px;">
				        	<span class="chart-title">${rkUp.rname}</span>
			    		</a>
			    		<c:forEach items="${rkUp.songlists}" var="song" varStatus="st">
				    		<a href="javascript:void(0);" onclick="toSingleSong(${song.sid})" class="list-group-item">
							        <span class="num">${song.id}</span>
						        <span class="songItem">${song.stitle}</span>
					    	</a>
				    	</c:forEach>
					</div>
					<div class="list-group chartUnit">
						<a href="#" class="list-group-item active">
				        	<img src="${rkNew.rpic}" style="width:80px;height:80px;">
				        	<span class="chart-title">${rkNew.rname}</span>
			    		</a>
			    		<c:forEach items="${rkNew.songlists}" var="song" varStatus="st">
				    		<a href="javascript:void(0);" onclick="toSingleSong(${song.sid})" class="list-group-item">
							        <span class="num">${song.id}</span>
						        <span class="songItem">${song.stitle}</span>
					    	</a>
				    	</c:forEach>
					</div>
					<div class="list-group chartUnit">
						<a href="#" class="list-group-item active">
				        	<img src="${rkHot.rpic}" style="width:80px;height:80px;">
				        	<span class="chart-title">${rkHot.rname}</span>
			    		</a>
			    		<c:forEach items="${rkHot.songlists}" var="song" varStatus="st">
				    		<a href="javascript:void(0);" onclick="toSingleSong(${song.sid})" class="list-group-item">
							        <span class="num">${song.id}</span>
						        <span class="songItem">${song.stitle}</span>
					    	</a>
				    	</c:forEach>
					</div>
<%-- 					<c:forEach items="${ranklists}" var="ranklist" varStatus="st"> --%>
<!-- 						<div class="list-group chartUnit"> -->
<!-- 							<a href="#" class="list-group-item active"> -->
<%-- 					        	<img src="${ranklist.rpic}" style="width:80px;height:80px;"> --%>
<%-- 					        	<span class="chart-title">${ranklist.rname}</span> --%>
<!-- 				    		</a> -->
<%-- 				    		<c:forEach items="${ranklist.songlists}" var="song" varStatus="st"> --%>
<%-- 					    		<a href="javascript:void(0);" onclick="toSingleSong(${song.sid})" class="list-group-item"> --%>
<!-- 							        <span class="num">1</span> -->
<%-- 							        <span class="songItem">${song.stitle}</span> --%>
<!-- 						    	</a> -->
<%-- 					    	</c:forEach> --%>
<!-- 						</div> -->
<%-- 					</c:forEach> --%>
				</div>
			</div>
		</div>
<!-- 		<div style="clear:both"></div> -->
	</div>
	<%@ include file="../Common/footer.jsp" %>
</body>