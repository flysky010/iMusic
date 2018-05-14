<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- 可选的Bootstrap主题文件（一般不使用） -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/jquery-1.11.3.min.js "></script>
<script>
        $(function(){
            $(".panel-heading").click(function(e){
                /*切换折叠指示图标*/
                $(this).find("span").toggleClass("glyphicon-chevron-down");
                $(this).find("span").toggleClass("glyphicon-chevron-up");
            });
        });
</script>
<%    
String path_left = request.getContextPath();   
String basePath_left = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path_left+"/"; 
%> 

<style>

div.leftNavi{
	position:absolute;
	top:100px;
	left:0px;
	width:100px;
	height:300px;
}

.panel-group{max-height:770px;overflow: auto;}
.leftMenu{margin:2px;margin-top:5px;}
.leftMenu .panel-heading{font-size:14px;padding-left:20px;height:36px;line-height:36px;color:white;position:relative;cursor:pointer;}/*转成手形图标*/
.leftMenu .panel-heading span{position:absolute;right:10px;top:12px;}
.leftMenu .menu-item-left{padding: 2px; background: transparent; border:1px solid transparent;border-radius: 6px;}
.leftMenu .menu-item-left:hover{background:#C4E3F3;border:1px solid #1E90FF;}

a:hover{
	text-decoration:none;
}
a{
	color:#333;
}
</style>
<div class="row">
            <div class="col-md-2">
                <div class="panel-group table-responsive" role="tablist">
                    <div class="panel panel-primary leftMenu">
                        <!-- 利用data-target指定要折叠的分组列表 -->
                        <div class="panel-heading" id="collapseListGroupHeading1" data-toggle="collapse" data-target="#collapseListGroup1" role="tab" >
                            <h4 class="panel-title">
                                	系统管理
                                <span class="glyphicon glyphicon-chevron-up right"></span>
                            </h4>
                        </div>
                        <!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
                        <div id="collapseListGroup1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="collapseListGroupHeading1">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <!-- 利用data-target指定URL -->
                                <button class="menu-item-left" data-target="test2.html">
                                    <span class="glyphicon glyphicon-triangle-right"></span>
                                    	<a href="/user/userList.do">系统用户管理</a>
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>
                                    	<a href="/basedataList.do">基础数据管理</a>
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>
                                    	<a href="/showPlaylist.do">歌单管理</a>
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div><!--panel end-->
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading2" data-toggle="collapse" data-target="#collapseListGroup2" role="tab" >
                            <h4 class="panel-title">
                                		文件管理
                                <span class="glyphicon glyphicon-chevron-down right"></span>
                            </h4>
                        </div>
                        <div id="collapseListGroup2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading2">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>
                                    	<a href="/file/fileList.do">音乐文件管理</a> 
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div> 
<!--                     <div class="panel panel-primary leftMenu"> -->
<!--                         <div class="panel-heading" id="collapseListGroupHeading3" data-toggle="collapse" data-target="#collapseListGroup3" role="tab" > -->
<!--                             <h4 class="panel-title"> -->
<!--                                 		文件管理 -->
<!--                                 <span class="glyphicon glyphicon-chevron-down right"></span> -->
<!--                             </h4> -->
<!--                         </div> -->
<!--                         <div id="collapseListGroup3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading2"> -->
<!--                             <ul class="list-group"> -->
<!--                               <li class="list-group-item"> -->
<!--                                 <button class="menu-item-left"> -->
<!--                                     <span class="glyphicon glyphicon-triangle-right"></span>音乐文件管理 -->
<!--                                 </button> -->
<!--                               </li> -->
<!--                             </ul> -->
<!--                         </div> -->
<!--                     </div>  -->
                </div>
            </div>
        </div>
