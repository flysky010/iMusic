$(document).ready(function(){ 
 $('#myCarousel').carousel({interval:5000});//每隔5秒自动轮播 
 }); 

function toPlaylist(id){
	var param = "type="+id;
	window.location.href = "c_playlist.do?"+param;
}

function toSinglePlaylist(pid){
	var param = "pid="+pid;
	window.location.href = "singleplaylist.do?"+param;
}

function toSingleSong(sid){
	var param = "sid="+sid;
	window.location.href = "toSingleSong.do?"+param;
}

function loadHomePage(){
	window.location.href = "home.do";
}



function loadData(){
	$(".carousel-inner").children().eq(0).addClass("active");	
	$(".carousel-indicators").children().eq(0).addClass("active");
}