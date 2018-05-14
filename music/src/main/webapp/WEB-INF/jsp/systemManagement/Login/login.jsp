<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<head>
<title>登录iMusic管理系统</title>
</head>

<style>

body{
	font-size:12px;
	font-family:Arial;
}

div.loginDiv{
	width:400px;
	height:300px;
	margin:100px auto;	
	border:5px solid;
	border-color:#C40000;
	border-radius:10px;
	padding:10px;
	display:block;
}

div.loginDiv div.usernameDiv{
	width:250px;
	height:40px;
	margin-top:100px;
	margin-left:auto;
	margin-right:auto;
/* 	border:1px solid; */
/* 	border-color:#C40000; */
}

div.loginDiv div.passwordDiv{
	width:250px;
	height:40px;
	margin-top:10px;
	margin-left:auto;
	margin-right:auto;
/* 	border:1px solid; */
/* 	border-color:#C40000; */
}

div.textDescSpan{
	width:80px;
	height:30px;
	float:left;
	font-size:20px;
	font-family:Arial;
}



div.usernameDiv input,div.passwordDiv input{
	width:170px;
	height:30px;
}

.buttonDiv{
	width:100%;
	height:25px;
}

.cancelDiv{
	display:inline-block;
	width:80px;
	height:25px;
	margin-left:76px;
}

.cancelDiv input{
	width:100%;
	height:25px;
}

.submitDiv{
	display:inline-block;
	width:80px;
	height:25px;
	margin-left:84px;
}

.submitDiv input{
	width:100%;
	height:25px;
}

</style>

<body>
	<div class="loginDiv">
		<form action="login.do" method="post">
			<div class="usernameDiv">
				<div class="textDescSpan">用户名：</div>
				<input type="text" value="" class="usernameInput" name="username"/>
			</div>
			<div class="passwordDiv">
				<div class="textDescSpan">密码：</div>
				<input type="password" value="" class="pwdInput" name="password"/>
			</div>
			<div class="buttonDiv">
				<span class="cancelDiv">
					<input type="button" value="取消" onclick="javascript:history.back(-1);">
				</span>
				<span class="submitDiv">
					<input type="submit" value="登录">
				</span>
			</div>
		</form>
	</div>
</body>