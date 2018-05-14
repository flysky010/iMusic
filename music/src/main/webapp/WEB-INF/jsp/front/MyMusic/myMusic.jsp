<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
    
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!-- <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script> -->
<!-- <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="/js/myMusic.js"></script>
</head>

<style>
.g-wrap-1{
	width:800px;
	height:1024px;
	
	margin:0px auto;
	border:1px solid #D3D3D3;
}
.g-wrap-left{
	width:240px;
	height:1024px;
	float:left;
	background-color:#F9F9F9;
	border-right:1px solid #D3D3D3;
	border-bottom:1px solid #D3D3D3;
}
.g-wrap-right{
	width:558px;
	height:1024px;
	display:inline-block;
	background-color:#FFF;
	padding-left:40px;
	border-bottom:1px solid #D3D3D3;
}
.wrap-left-tlt{
	width:100%;
	height:35px;
	margin-top:30px;
	padding-left:15px;
	font-family:Arial;
}
.left-desc{
	font-weight:bold;
	font-size:18px;
	
	cursor:pointer;
}
.u-btn-crt {
    width: 75px;
    height: 30px;
    background-position: 0 -96px;
	display: inline-block;
	float: right;
	margin-right:5px;
	background-image: url(images/button-new.png);
	background-position: 5% 5%; 
	background-repeat:no-repeat;
}
a {
	cursor: pointer;
    text-decoration: none;
    color: #333;
}
i{
    font-style: normal;
    text-align: right;
    font-size: 10px;
	margin-left:30px;
	line-height:30px;
}
.pl-img-div{
	width:40px;
	height:37px;
	float:left;
}
.pl-img{
	width:100%;
	height:100%;
}
.pl-ul{
	margin:0px;
	margin-top:15px;
	padding-left:15px;
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
.wrap-body{
	width:598px;
	height:1024px;
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
	width:150px;
	height:150px;
	float:left;
	padding-top:20px;
	padding:2px;
	border:1px solid #CCCCCC;
}
.hd-img img{
	width:100%;
	height:100%
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
	width:250px;
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

a:visited {   
	font-size: 12px;   
	color: #000000;   
	text-decoration: none!important;   
}

a:focus{
	text-decoration: none !important;
	color: #000000; 
}
.upload{
    padding: 7px 10px;
    width:64px;
	height:31px;
    line-height: 31px;
    position: relative;
    border:1px solid #C8C6C6;
    border-radius:5px;
 	font-size:14px; 
	font-family:Arial;
    text-decoration: none;
    color:#FFF;
    background-color:#589FE0;
    text-align:center;
    cursor: pointer;
}
.change{
	width:64px;
	height:31px;
	cursor: pointer;
    position: absolute;
    overflow: hidden;
    right: 0;
    top: 0;
    opacity: 0;
    font-size:0;
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
.zbody{
	margin-left: 30px;
    text-align: left;
    padding:40px 0px;
}

.u-txt {
	vertical-align: middle;
    width: 330px;
    height: 33px;
    margin: 0;
    padding: 5px 6px 6px;
    border: 1px solid #cdcdcd;
    border-radius: 2px;
    line-height: 19px;
}
input:focus, textarea:focus, span:focus, a:focus, button:focus {
    outline: none;
}
.tip {
    margin: 0 0 20px 88px;
}
.s-fc4, a.s-fc4:hover {
    color: #999;
}
.z-btn{
    margin-left: 48px;
}
.z-btn-1 {
    width: 82px;
    height: 36px;
    background-position: 0 -96px;
	display: inline-block;
	margin-left: 35px;
	background-image: url(images/btn-create.png);
	background-position: 5% 5%; 
	background-repeat:no-repeat;
}
.z-btn-2 {
    width: 82px;
    height: 36px;
    background-position: 0 -96px;
	display: inline-block;
	margin-left: 48px;
	background-image: url(images/btn-cancel.png);
	background-position: 5% 5%; 
	background-repeat:no-repeat;
}
.pl-song-edit{
	float:right;
	font-size:12px;
	font-family:Arial;
	color:#999999;
}
.pl-song-del{
	float:right;
	font-size:12px;
	font-family:Arial;
	color:#999999;
}
.g-wrap-right2{
	width:558px;
	height:1024px;
	display:inline-block;
	background-color:#FFF;
	padding:40px;
	border-bottom:1px solid #D3D3D3;
}

.g-wrap2{
	height:680px;
}
.u-bread1 {
    height: 27px;
    border-bottom: 1px solid #cbcbcb;
    font-family: simsun;
}
.s-fc7, a.s-fc7:hover {
    color: #0c73c2;
}
a {
    cursor: pointer;
    text-decoration: none;
    color: #333;
}
.u-bread1 .arr {
    margin: 0 6px 0 8px;
}
.s-fc4, a.s-fc4:hover {
    color: #999;
}
.f-fw1 {
    font-weight: bold;
}
.n-base {
    margin-top: 30px;
}
.n-base .frm {
	width: 364px;
    float: left;
    width: 340px;
    margin-right: 30px;
}
.frm .itm {
    padding-left: 62px;
}
.frm .itm {
    position: relative;
    zoom: 1;
    min-height: 32px;
    margin-bottom: 10px;
    padding-left: 38px;
}
.must {
    position: absolute;
    left: 0;
    top: 11px;
}
.s-fc6, a.s-fc6:hover {
    color: #c20c0c;
}
.m-frm .lab {
    display: block;
    position: absolute;
    top: 0;
    left: 0;
    width: 70px;
    line-height: 32px;
    text-align: right;
     font-weight: normal;
}
label {
    cursor: default;
}
#auto-id-input1 {
	width: 292px;
    height: 32px;
    margin-left: 30px;
    padding: 5px 6px 6px;
    border: 1px solid #cdcdcd;
    border-radius: 2px;
    line-height: 32px;
}
.n-base .tagnote {
    margin-top: 25px;
    margin-left: 30px;
}
.s-fc4, a.s-fc4:hover {
    color: #999;
}
.u-txtwrap {
    padding-right: 14px;
}
.n-base .area {
    height: 122px;
}
.n-base .txt, .n-base .area {
    width: 292px;
}
.u-txt2 {
	width: 100%;
    height: 19px;
    padding: 5px 6px 6px;
    border: 1px solid #cdcdcd;
    border-radius: 2px;
    line-height: 19px;
    margin-left:30px;
}
textarea {
    resize: none;
    overflow: auto;
}
.f-pr {
	width: 140px;
    height: 140px;
    position: relative;
    zoom: 1;
}
.n-base img {
	margin-left: 30px;
    width: 140px;
    height: 140px;
    border:1px solid #cdcdcd;
}
.uploadfile{
	margin-left:30px;
	margin-top:5px;
	color: transparent;
}
.ft {
    margin-top: 40px;
}
.u-btn2{
	display: inline-block;
    width:83px;
    height: 31px;
    cursor: pointer;
    margin-left:30px;
    background: url(/images/btn-save2.png) no-repeat center;
}
.u-btn3{
display: inline-block; 
    width:83px;
    height: 31px;
    cursor: pointer;
    margin-left:10px;
    background: url(/images/btn-cancel2.png) no-repeat center;
}
.typeName{
	margin-left:30px;
	margin-top:7px;
}
.li-tag{
	margin-top:5px;
	margin-left:35px;
}
.li-tag-edit{
	float:left;
	width: 40px;
	height: 20px;
	vertical-align:middle !important;
	margin-right:6px;
	margin-left:-3px;
	text-align:center;
	color:white;
/* 	cursor:pointer; */
	list-style:none;
/* 	border-radius:100%; */
/* 	-o-border-radius:100%; */
/* 	-ms-border-radius:100%; */
/* 	-moz-border-radius:100%; */
/* 	-webkit-border-radius:100%; */
}
.op-t{
	margin-top:16px;
	font-size:14px;
	color:#333333;
}

.g-wrap-right3{
	width:558px;
	height:1024px;
	display:inline-block;
	background-color:#FFF;
	padding:40px;
	border-bottom:1px solid #D3D3D3;
}
#auto-id-input1-1 {
	width: 292px;
    height: 32px;
    margin-left: 30px;
    padding: 5px 6px 6px;
    border: 1px solid #cdcdcd;
    border-radius: 2px;
    line-height: 32px;
}
#auto-id-input2-1 {
	width: 292px;
    height: 32px;
    margin-left: 30px;
    padding: 5px 6px 6px;
    border: 1px solid #cdcdcd;
    border-radius: 2px;
    line-height: 32px;
}
#auto-id-input3-1 {
	width: 292px;
    height: 32px;
    margin-left: 30px;
    padding: 5px 6px 6px;
    border: 1px solid #cdcdcd;
    border-radius: 2px;
    line-height: 32px;
}
#auto-id-input4-1 {
	width: 292px;
    height: 32px;
    margin-left: 30px;
    padding: 5px 6px 6px;
    border: 1px solid #cdcdcd;
    border-radius: 2px;
    line-height: 32px;
}
</style>

<body style="background-color:#F5F5F5">
	<%@ include file="../Common/nav.jsp" %>
	<div class="g-wrap-1" id="g-wrap-1">
		<div class="g-wrap-left" id="g-wrap-left">
			<div class="warp-left-1">
				<div class="wrap-left-tlt">
					<span class="left-desc">
						创建的歌单
						<span class="left-num">(${plTotal})</span>
					</span>
					<a href="javascript:void(0);" onclick="ShowDiv('MyDiv','fade')" class="u-btn-crt">
						<i>新建</i>
					</a>
				</div>
				<div style="clear:both"></div>
				<ul style="list-style-type:none" class="pl-ul" id="pl-ul">
					<c:forEach items="${playlists}" var="playlist" varStatus="st">
						<li id="li-${playlist.id}" class="li-${playlist.id}">
							<div class="playlistWrap">
								<div class="pl-img-div">
									<a href="javascript:void(0)" onclick="changePlaylist(${playlist.id})" >
										<img src="${playlist.path}" class="pl-img">
									</a>
								</div>
								<p class="pl-tlt">
									<a href="javascript:void(0)" onclick="changePlaylist(${playlist.id})">
										${playlist.title}
									</a>
								</p>
								<div class="pl-song-del" onclick="delPlaylist(${playlist.id})">删除</div>
								<div class="pl-song-edit" onclick="editPlaylist(${playlist.id})">修改</div>
								<p class="pl-song-num">${playlist.songnum}首</p>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="g-wrap-right" id="g-wrap-right">
			<div class="body-hd">
				<div class="hd-img">
					<img src="${playlist.path}">
				</div>
				<span class="hd-desc">
					<h2 class="hd-tlt">爱音乐特色榜</h2>
					<div class="cnt">
						<span class="glyphicon glyphicon-time" style="color:#B1B1B1;"></span>
						<span class="s-fc1">最近更新：${playlist.modifyTime}</span>
						<span class="s-fc2">(每周更新)</span>
						<input type="hidden" id="rid" value="${playlist.id}">
						<input type="hidden" id="pname" value="${playlist.title}">
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
						<a href="javascript:void(0);" class="upload">
							<span class="glyphicon glyphicon-upload" style="color: #FFFFFF;"></span>
							上传
							<input class="change" type="file" id="upload-file" class="uploadInput" onchange="submitform()"  name="files" multiple="multiple" />
						</a>
					</div>
				</span>
			</div>
			<div style="clear:both"></div>
			<div class="body-song-list">
				<div class="u-title u-title-1 f-cb">
					<h3><span class="f-ff2">歌曲列表</span></h3>
					<span class="sub s-fc3"><span>${total}</span>首歌</span>
					<div class="more s-fc3">播放：<strong class="s-fc6" id="play-count">${playlist.playnum}</strong>次</div>
				</div>
				<div class="u-list">
					<table class="table table-bordered table-striped" id="table-rank">
						<thead>
							<tr>
								<th>序号</th>	
								<th>标题</th>
								<th>时长</th>
								<th>歌手</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${songs}" var="song" varStatus="st">
								<tr>
									<td class="song-rank">${song.id}</td>
									<td>
										<div class="tlt-desc-2">
											<img src="${song.albumPic}" class="song-img">
											<div class="btn-audio" onclick="playmusic(this)" id="mp3Div">
												<audio id="mp3Btn">
													<source src="${song.path}" type="audio/mpeg" />
												</audio>
												<input type="hidden" value="${song.sid}">
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
									<td class="td-t">
										<a class="opt-a" href="javascript:void(0);" 
											onclick="toEditSong('${song.stitle}','${song.stime}','${song.singer}','${song.sid}','${song.albumName}')" 
											title="编辑">
											<span class="glyphicon glyphicon-edit op-t" ></span>
										</a>
									</td>
								</tr>
							</c:forEach>
					  </tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="g-wrap-right2" id="g-wrap-right2">
			<div class="g-wrap2">
				<div>
					<div class="u-bread1">
						<a href="#nowhere" class="s-fc7" id="s-fc7"></a>
						<span class="arr s-fc4">></span>
						<span class="f-fw1">编辑歌单</span>
					</div>
					<div class="n-base">
						<div class="frm m-frm">
							<div class="itm">
								<span class="must s-fc6">*</span>
								<label class="lab">歌单名：</label>
								<input type="text" class="u-txt1 txt j-flag" value="" id="auto-id-input1">
								<input type="hidden" value="" id="pid-input-hidden">
							</div>
							<div class="itm">
								<label class="lab">标签：</label>
								<select name="typeName" class="typeName" id="typeName">
								</select>
								<div class="li-tag"></div>
								<div class="s-fc4 tagnote">选择适合的标签，最多选3个</div>
							</div>
							<div class="itm">
								<label class="lab">介绍：</label>
								<div class="u-txtwrap f-pr">
									<textarea class="u-txt2 area j-flag" id="auto-id-textarea"></textarea>
								</div>
							</div>
							<div class="itm f-pr">
								<label class="lab">封面：</label>
								<img id="edit_cover" src="">
								<input name="fileupload" type="file" onchange="showImg()" id="auto-id-input2" class="uploadfile">
							</div>
							<div class="itm ft">
								<a href="javascript:void(0)" class="u-btn2" onclick="save()"></a>
								<a href="javascript:void(0)" class="u-btn3" onclick="cancelEditPlaylist()"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="g-wrap-right3" id="g-wrap-right3">
			<div class="g-wrap2">
				<div>
					<div class="u-bread1">
						<a href="#nowhere" class="s-fc7" id="s-fc7"></a>
						<span class="arr s-fc4">></span>
						<span class="f-fw1">编辑歌曲</span>
					</div>
					<div class="n-base">
						<div class="frm m-frm">
							<div class="itm">
								<span class="must s-fc6">*</span>
								<label class="lab">歌曲名：</label>
								<input type="text" class="u-txt1 txt j-flag" value="" id="auto-id-input1-1">
								<input type="hidden" value="" id="sid-input-hidden">
							</div>
							<div class="itm">
								<span class="must s-fc6"></span>
								<label class="lab">歌手：</label>
								<input type="text" class="u-txt1 txt j-flag" value="" id="auto-id-input2-1">
								<input type="hidden" value="" id="pid-input-hidden">
							</div>
							<div class="itm">
								<span class="must s-fc6"></span>
								<label class="lab">时长：</label>
								<input type="text" class="u-txt1 txt j-flag" value="" id="auto-id-input3-1">
								<input type="hidden" value="" id="pid-input-hidden">
							</div>
							<div class="itm">
								<span class="must s-fc6"></span>
								<label class="lab">专辑：</label>
								<input type="text" class="u-txt1 txt j-flag" value="" id="auto-id-input4-1">
								<input type="hidden" value="" id="pid-input-hidden">
							</div>
							<div class="itm ft">
								<a href="javascript:void(0)" class="u-btn2" onclick="saveSingleSong()"></a>
								<a href="javascript:void(0)" class="u-btn3" onclick="cancelEditSong()"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="fade" class="black_overlay">
	</div>
	<div id="MyDiv" class="white_content">
		<div class="zbar">
			<div class="zttl f-thide">新建歌单</div>
			<div class="zcls" onclick="CloseDiv('MyDiv','fade')">x</div>
		</div>
		<div class="zbody">
			<p>歌单名：<input type="text" class="u-txt j-flag" id="pl-name-create"></p>
		</div>
		<p class="tip s-fc4">可通过“收藏”将音乐添加到新歌单中</p>
		<div class="z-btn">
			<a href="javascript:void(0);" onclick="createPlaylist('MyDiv','fade')" class="z-btn-1">		
			</a>
			<a href="javascript:void(0);" onclick="CloseDiv('MyDiv','fade')" class="z-btn-2">		
			</a>
		</div>
	</div>
	<%@ include file="../Common/footer.jsp" %>
</body>