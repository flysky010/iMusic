<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script src="/js/userInfoList.js" ></script>


<style>
div.userInfoListDiv{
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

div.userInfoListDiv table.userTable{
	align:center;
	border:1px solid #999;
	font-size:12px;
	font-family:Arial;
}

div.userInfoListDiv table.userTable th{  
	text-align: center;  
	vertical-align: middle!important;  
}  

div.userInfoListDiv div.userInfoListHd{
	margin:1px;
}

div.userInfoListDiv button.userAddBtn{
	float:right;
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

<body>
	<%@ include file="../common/head.jsp" %>
	<%@ include file="../common/left.jsp" %>
	<div class="userInfoListDiv">
	<!-- 	<p id="demo">这是一个段落</p> -->
		<div class="userInfoListHd">
			<span>用户名：</span>
			<input name="username" class="blakn-sl" value="" id="username"/>
	<!-- 		<a href="javascript:document.queryForm.submit();" class="btn-sh">查询</a> -->
			<button type="button" onclick="toUserQuery()" class="userQuery" id="userQuery">查询</button>
			<button type="button" onclick="toUserAdd()" class="userAddBtn" id="userAddBtn">新增</button>
		</div>
		<div class="yt-c-div table-responsive">
			<table class="userTable table table-bordered table-hover">
				<thead>
					<tr class="active">
					 <th width="30%">用户名 </th>
					 <th width="30%">密码</th>
					 <th width="15%">状态</th>
					 <th width="25%">操作</th>
					</tr>              
				</thead>
				<tbody>
					<c:forEach items="${uList}" var="userItem" varStatus="st">
						<tr>
				   			<td>${userItem.name}</td>
				 			<td>${userItem.password}</td>
							<td>
								<c:choose>
	     							<c:when test="${userItem.state == 1}">启用</c:when>
	     							<c:otherwise>禁用</c:otherwise>
								</c:choose>
							</td>
							<td  style="text-align:center;"> 
								<a href ="javascript:void(0);" onclick ="toUpdatePassword('${userItem.id}')">编辑</a> 
								<a href ="javascript:void(0);" onclick ="toDelete('${userItem.id}')">删除</a>     
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
</body>

