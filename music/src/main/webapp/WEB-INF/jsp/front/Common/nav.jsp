
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

<style>
nav.nav-bg{
    background-color: #C40000;
    width:800px;
    margin:0px auto;
}
nav.navbar a{
	color:white;
	font-family:Arial;
}
nav.navbar a:hover{
	background-color: #9B0909 !important;
}
.navbar {
    margin-bottom: 0px !important;/*覆盖原来的样式*/ 
}
.form-control{
	border: 1px solid transparent !important;
	outline:none !important;
}
.dropdown-menu a:hover{
	color:white !important;
	font-family:Arial;
}
</style>

<nav class="navbar nav-bg" role="navigation">
	<div class="container-fluid"> 
    <div class="navbar-header navbar-center">
        <a class="navbar-brand" href="/home.do">爱音乐iMusic</a>
    </div>
    <div class="collapse navbar-collapse" id="example-navbar-collapse">
		<ul class="nav navbar-nav" >
<!-- 			<li class="active"><a href="/home.do">推荐</a></li> -->
			<li><a href="/ranklist.do">排行榜</a></li>
			<li><a href="/playlist.do">歌单</a></li>
<!-- 			<li><a href="#">歌手</a></li> -->
			<li><a href="/login.do">我的音乐</a></li>
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">
					我的主页 <span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="/user/toUpdateUserInfo">编辑个人信息</a></li>
					<li><a href="/logout">退出</a></li>
<!-- 					<li class="divider"></li> -->
<!-- 					<li><a href="#">分离的链接</a></li> -->
				</ul>
			</li>
		</ul>
		<form class="navbar-form navbar-right" role="search" action="/search.do">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="请输入歌曲" name="searchInput">
			</div>
			<button type="submit" class="btn btn-default">搜索</button>
		</form>
	</div>
    </div>
</nav>