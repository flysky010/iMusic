<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="/js/file.js" ></script>


<style>
div.musicFileListDiv{
	position:absolute;
	top:100px;
	left:200px;
	width:924px;
	height:700px;
	margin:1px;
	font-size:12px;
	font-family:Arial;
/* 	border:2px solid #999; */
}

div.musicFileListDiv table.fileTable{
	align:center;
	border:1px solid #999;
	font-size:12px;
	font-family:Arial;
	width:100%;
}

div.musicFileListDiv table.fileTable th{  
	text-align: center;  
	vertical-align: middle!important;  
}  

div.musicFileListDiv div.musicFileListHd{
	margin:1px;
	width:100%;
}

div.musicFileListDiv form.uploadForm{
	display:inline-block;
}

.pager{
	overflow:hidden;
}
a.zbtn {
    height: 24px;
    line-height: 24px;
    color: #333;
    text-align: left;
    padding: 0;
}
</style>

<%@ include file="../common/head.jsp" %>
<%@ include file="../common/left.jsp" %>
<div class="musicFileListDiv">
	<div class="musicFileListHd">
		<span>用户名：</span>
		<input type="text" name="filename" placeholder="请输入歌曲名" class="blakn-sl" id="filename"/>
		<button type="button" onclick="toFileQuery()" class="fileQuery" id="fileQuery">查询</button>
<!-- 		<button type="button" onclick="toFileAdd()" class="fileAddBtn" id="fileAddBtn ">上传</button> -->
		<form action="/file/uploadMusicFile.do" class="uploadForm" name="uploadMusicForm" method="post" enctype="multipart/form-data">
			<input type="file" class="uploadInput" id="input" onchange="submitform()"  name="files" multiple="multiple"/>
		</form>
	</div>
	<div class="yt-c-div table-responsive">
		<table class="fileTable table table-bordered table-hover">
			<thead>
				<tr class="active">
				 <th width="25%">专辑名</th>
				 <th width="25%">歌曲名</th>
				 <th width="20%">歌手</th>
				 <th width="15%">文件大小(MB)</th>
				 <th width="15%">操作</th>
				</tr>              
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="mItem" varStatus="st">
					<tr>
			   			<td>${mItem.albumName}</td>
			 			<td>${mItem.stitle}</td>
						<td>${mItem.singer}</td>
						<td>${mItem.size}</td>
						<td  style="text-align:center;"> 
							<a href ="javascript:void(0);" onclick ="toUpdate('${mItem.sid}')">编辑</a> 
							<a href ="javascript:void(0);" onclick ="toDelete('${mItem.sid}')">删除</a>     
			       		</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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

