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
<script src="/js/userInfoEdit.js"></script>
</head>

<style>
.g-wrap-1{
	width:800px;
	height:1024px;
	margin:0px auto;
	border:1px solid #D3D3D3;
}
a {
	cursor: pointer;
    text-decoration: none;
    color: #333;
}
h3 {
    display: block;
    font-weight: bold;
}
body{
	background-color:#F5F5F5;
}
.g-wrap-right2{
	width:100%;
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
</style>

<body style="background-color:#F5F5F5">
	<%@ include file="../Common/nav.jsp" %>
	<div class="g-wrap-1" id="g-wrap-1">
		<div class="g-wrap-right2" id="g-wrap-right2">
			<div class="g-wrap2">
				<div>
					<div class="u-bread1">
						<a href="#nowhere" class="s-fc7" id="s-fc7"></a>
						<span class="f-fw1">编辑个人信息</span>
					</div>
					<div class="n-base">
						<div class="frm m-frm">
							<div class="itm">
								<span class="must s-fc6">*</span>
								<label class="lab">用户名：</label>
								<input type="text" class="u-txt1 txt j-flag" value="${user.name}" id="auto-id-input1">
								<input type="hidden" value="${user.id}" id="pid-input-hidden">
							</div>
<!-- 							<div class="itm"> -->
<!-- 								<label class="lab">介绍：</label> -->
<!-- 								<div class="u-txtwrap f-pr"> -->
<!-- 									<textarea class="u-txt2 area j-flag" id="auto-id-textarea"></textarea> -->
<!-- 								</div> -->
<!-- 							</div> -->
							<div class="itm f-pr">
								<label class="lab">头像：</label>
								<img id="edit_cover" src="${user.pic}">
								<input name="fileupload" type="file" onchange="showImg()" id="auto-id-input2" class="uploadfile">
							</div>
							<div class="itm ft">
								<a href="javascript:void(0)" class="u-btn2" onclick="save()"></a>
								<a href="javascript:void(0)" class="u-btn3" onclick="javascript:history.back(-1);"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../Common/footer.jsp" %>
</body>