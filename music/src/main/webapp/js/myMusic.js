$(document).ready(function(){
	$(this).find(".pl-song-del").hide();
	$(this).find(".pl-song-edit").hide();
	$(this).find(".g-wrap-right2").hide();
	$(this).find(".g-wrap-right3").hide();
	
	$("#typeName").bind("change",function(){
		//每选中一个元素，就创建一个标签
		console.log($(".li-tag li").length);
		if($(".li-tag li").length<3){
			$a = $('<li>'+$(".typeName").find("option:selected").text()+'</li>');
			//$a.addClass("li-tag-edit");
			$a.addClass("label label-info li-tag-edit");
			$('.li-tag').append($a);
		}else{
//			$(".li-tag li").first().text($(".typeName").find("option:selected").text());
			$a = $('<li>'+$(".typeName").find("option:selected").text()+'</li>');
			//$a.addClass("li-tag-edit");
			$a.addClass("label label-info li-tag-edit");
			$(".li-tag li").last().remove();
			$(".li-tag li").first().before($a);
		}
	});
});

function playmusic(x){
	var aud = x.getElementsByTagName('audio');
	
	aud[0].addEventListener("ended", function() //注册end事件
	{
		console.log("音频已播放完成");
		console.log($(this).next().val());
		x.style.background="url(images/voice_stop.png) no-repeat center bottom";
    	x.style.backgroundSize="cover";
    	
    	//播放完成，更新播放次数
    	var arr = new Array();  
		arr[0]=document.getElementById("rid").value;
		arr[1]=$(this).next().val();
		$.ajax({  
		    type : 'POST',  
		    url: '/updateMyMusicPlayNum', 
		    contentType : "application/json",
		    data : JSON.stringify(arr), 
		    success : function(data) {  
		    	var play_count = document.getElementById("play-count").innerHTML;
		    	
				document.getElementById("play-count").innerHTML = parseInt(play_count) + 1;
		    }  
		});
	});
	
	var audio = x.getElementsByTagName('audio');
	audio[0].volume = .3;
	event.stopPropagation();//防止冒泡
    if(audio[0].paused){ //如果当前是暂停状态
    	x.style.background="url(images/voice_play.png) no-repeat center bottom";
    	x.style.backgroundSize="cover";
        audio[0].play(); //播放
        return;
    }else{//当前是播放状态
    	x.style.background="url(images/voice_stop.png) no-repeat center bottom";
    	x.style.backgroundSize="cover";
        audio[0].pause(); //暂停
    }
}

function play(){
	var td=document.getElementById ("table-rank").rows[1].cells[1];
	var list=td.getElementsByTagName('div');
	var first_song_div=list[1]
	playmusic(first_song_div);
}

function downloadMusic(){
	var x = document.getElementsByTagName("source");
	var arr = new Array();
	for(var i =0;i<x.length;i++){ 
		arr[i] = decodeURI(x[i].src);
	} 
	
	var form=$("<form>");//定义一个form表单
    form.attr("style","display:none");
    form.attr("target","");
    form.attr("method","post");
    form.attr("action","/batchDownload");//请求url
    var input1=$("<input>");
    input1.attr("type","hidden");
    input1.attr("name","rows");//设置属性的名字
     input1.attr("value",JSON.stringify(arr));//设置属性的值
     $("body").append(form);//将表单放置在web中
     form.append(input1);
     form.submit();//表单提交       
	
}

function submitform(){
	var files = document.getElementById('upload-file').files; //files是文件选择框选择的文件对象数组
	if(files.length == 0) return;
	if(files.length > 5){
		alert("亲，一次最多只能上传5首歌曲");
		return;
	}
	var form = new FormData();
	url = '/uploadfileFront';//服务器上传地址
	for(var i=0; i< files.length; i++){
		form.append("files" , files[i] );
    }
	var pid = $("#rid").val();
	form.append("pid",pid);
	
	var xhr = new XMLHttpRequest();
	xhr.open("post", url, true);

	//上传进度事件
	xhr.upload.addEventListener("progress", function(result) {
	    if (result.lengthComputable) {
	        //上传进度
	        var percent = (result.loaded / result.total * 100).toFixed(2); 
	    }
	}, false);

	xhr.addEventListener("readystatechange", function() {
	    var result = xhr;
	    if (result.status != 200) { //error
	        console.log('上传失败', result.status, result.statusText, result.response);
	    } 
	    else if (result.readyState == 4) { //finished
	        console.log('上传成功', result);
	        var pname = $("#pname").val();
	        alert("上传成功！请到["+pname+"]歌单查看");
	    }
	});
	xhr.send(form); //开始上传
}

//弹出隐藏层
function ShowDiv(show_div,bg_div){
	document.getElementById(show_div).style.display='block';
	document.getElementById(bg_div).style.display='block' ;
	var bgdiv = document.getElementById(bg_div);
	bgdiv.style.width = document.body.scrollWidth;
	// bgdiv.style.height = $(document).height();
	$("#"+bg_div).height($(document).height());
};
//关闭弹出层
function CloseDiv(show_div,bg_div){
	document.getElementById(show_div).style.display='none';
	document.getElementById(bg_div).style.display='none';
};
//新建歌单
function createPlaylist(show_div,bg_div){
	let x = '';
	x= document.getElementById('pl-name-create').value;
	
	$.ajax({  
	    type : 'GET',  
	    url: `/addPlaylist?name=${x}`,//'/addPlaylist?name=${x}', 
	    contentType : "application/json",
	    success : function(data) { 
	    	if(data == ""){
	    		console.log("创建失败！");
	    		return;
	    	}
	    	console.log("创建成功！");
	    	var json = data;
	    	var li = document.createElement("li");
	    	li.className="li-"+json.id;
	    	li.id="li-"+json.id;
	    	var div1 = document.createElement("div");
	    	li.appendChild(div1);
	    	var div2 = document.createElement("div");
	    	div2.className="pl-img-div";
	    	div1.appendChild(div2);
	    	var a1 = document.createElement("a");
	    	div2.appendChild(a1);
	    	var img1 = document.createElement("img");
	    	img1.src="";
	    	img1.className ="pl-img";
	    	a1.appendChild(img1);
	    	var p1 = document.createElement("p");
	    	p1.className ="pl-tlt";
	    	div1.appendChild(p1);
	    	var a2 = document.createElement("a");
	    	a2.innerHTML=json.title;
	    	p1.appendChild(a2);
	    	var p2 = document.createElement("p");
	    	p2.innerHTML=json.songnum +"首";
	    	p2.className ="pl-song-num";
	    	div1.appendChild(p2);
	    	var u = document.getElementById("pl-ul");
	    	u.appendChild(li);
	    	//为新创建的“修改与删除”绑定事件
	    	var $div1=$('<div onclick=delPlaylist('+json.id+')>删除</div>'); 
    		$div1.addClass("pl-song-del");
    		var $div2 = $('<div onclick=editPlaylist('+json.id+')>修改</div>'); 
    		$div2.addClass("pl-song-edit");
    		$(li).find(".pl-tlt").after($div1,$div2);
    		$div1.hide();
    		$div2.hide();
    		
    		//为新创建的li绑定鼠标事件
    		li.onmouseover=function dofun1(){
    			li.style.backgroundColor="#F4F2F2";
        		$div1.show();
        		$div2.show();
    		}
    		li.onmouseout=function dofun2(){
    			li.style.backgroundColor="#F9F9F9";
        		$div1.hide();
        		$div2.hide();
    		}
    		
	    	var curHeight=document.getElementById("g-wrap-1").offsetHeight;
	    	console.log(curHeight);
	    	var newHeight=curHeight+40;
	    	document.getElementById("g-wrap-1").style.height = newHeight+"px";//调整整个页面内容的高度
	    	document.getElementById("g-wrap-left").style.height = newHeight+"px";//调整整个页面内容的高度
	    	document.getElementById("g-wrap-right").style.height = newHeight+"px";//调整整个页面内容的高度
	    },
	    error: function(xhr) {
	         // 导致出错的原因较多，以后再研究
	         alert('error:' + JSON.stringify(xhr));
	    }
	});
	
	document.getElementById(show_div).style.display='none';
	document.getElementById(bg_div).style.display='none';
};

function changePlaylist(id){
	var param = "id="+id;
	window.location.href="changePlaylist.do?"+param;
}

$(function(){
    $('ul#pl-ul li').mouseover(
    	function(){
    		$(this).css("background-color","#F4F2F2");
    		$(this).find(".pl-song-del").show();
    		$(this).find(".pl-song-edit").show();
    	});  
    $('ul#pl-ul li').mouseout(
        	function(){
        		$(this).css("background-color","#F9F9F9");
        		$(this).find(".pl-song-del").hide();
        		$(this).find(".pl-song-edit").hide();
        	}); 
});

function delPlaylist(id){
	let x = id;
	$.ajax({  
	    type : 'GET',  
	    url: `/delPlaylist?id=${x}`,
	    contentType : "application/json",
	    success : function(data) { 
	    	if(data == "success"){
	    		console.log("删除成功");
	    		//移除元素
	    		var elem = "#li-"+id;
	    		console.log(elem);
	    		$(elem).remove();
	    		//调整高度
	    		var curHeight=document.getElementById("g-wrap-1").offsetHeight;
		    	
		    	var newHeight=curHeight-40;
		    	document.getElementById("g-wrap-1").style.height = newHeight+"px";//调整整个页面内容的高度
		    	document.getElementById("g-wrap-left").style.height = newHeight+"px";//调整整个页面内容的高度
		    	document.getElementById("g-wrap-right").style.height = newHeight+"px";//调整整个页面内容的高度
	    	}
	    }
	});
}

//跳转到歌单编辑界面
function editPlaylist(id){
	let x = id;
	$.ajax({  
	    type : 'GET',  
	    url: `/toEditPlaylist?id=${x}`,
	    contentType : "application/json",
	    success : function(data) { 
	    	console.log("修改成功");
	    	jArray = data;
	    	//填充数据
	    	$(".s-fc7").text(jArray[1].title);
	    	$(".u-txt1").val(jArray[1].title);
	    	$(".u-txt2").val(jArray[1].pdesc);
	    	$("#edit_cover").attr("src",jArray[1].path);
	    	$("#pid-input-hidden").val(id);
	    	$(".typeName").empty();
	    	for(i=0;i<jArray[0].length;i++){
	    		var $opt=$('<option  value ='+jArray[0][i].catId+'>'+jArray[0][i].catName+'</option>'); 
	    		$(".typeName").append($opt);
	    	}
	    	$('.li-tag').empty();
	    	for(j=0;j<jArray[2].length;j++){
		    	$a = $('<li>'+jArray[2][j].catName+'</li>');
				$a.addClass("label label-info li-tag-edit");
				$('.li-tag').append($a);
	    	}
	    	$("#g-wrap-right").hide();
	    	$(".g-wrap-right2").show();
	    }
	});
}

function save(){
	var files = document.getElementById('auto-id-input2').files; //files是文件选择框选择的文件对象数组
	var image = $("#edit_cover").attr("src");
	if(files.length == 0 && image.length == 0) return;
	
	var form = new FormData();
	url = '/uploadPlaylistOfMyMusic';//服务器上传地址
	if(files.length > 1 && image.length == 0){//图片文件选择
		alert("请选择单个文件上传");
		return;
	}
	var playlistName = $("#auto-id-input1").val();
	$(".li-tag-edit").each(function(){
		form.append("playTypes",$(this).text());
	});
//	var pid = $("#rid").val();
	var pid = $("#pid-input-hidden").val();
	form.append("pid",pid);
	form.append("playlistName",playlistName);
	form.append("textarea",$("#auto-id-textarea").val());
	form.append("files" , files[0]);
	form.append("image" , image);
	
	var xhr = new XMLHttpRequest();
	xhr.open("post", url, true);

	xhr.addEventListener("readystatechange", function() {
	    var result = xhr;
	    console.log(result);
	    if (result.status != 200) { //error
	        console.log('上传失败', result.status, result.statusText, result.response);
	    } 
	    else if (result.readyState == 4) { //finished
	        console.log('上传成功', result);
	        changePlaylist(pid);
	    }
	});
	xhr.send(form); //开始上传
}

function showImg(){
	var files = document.getElementById('auto-id-input2').files; //files是文件选择框选择的文件对象数组
	if(files.length == 0) return;
	var objUrl = getObjectURL(files[0]);
	$("#edit_cover").attr("src",objUrl);
}

//建立一個可存取到該file的url
function getObjectURL(file) 
{
	var url = null ;
	if (window.createObjectURL!=undefined) 
	{ // basic
		url = window.createObjectURL(file) ;
	}
	else if (window.URL!=undefined) 
	{
		// mozilla(firefox)
		url = window.URL.createObjectURL(file) ;
	} 
	else if (window.webkitURL!=undefined) {
		// webkit or chrome
		url = window.webkitURL.createObjectURL(file) ;
	}
	return url;
}

function cancelEditSong(){
	$("#g-wrap-right").show();
	$("#g-wrap-right3").hide();
}

function toEditSong(stitle, stime, singer, sid, albumName){
	$("#g-wrap-right").hide();
	$("#g-wrap-right3").show();
	$("#auto-id-input1-1").val(stitle);
	$("#auto-id-input2-1").val(singer);
	$("#auto-id-input3-1").val(stime);
	$("#auto-id-input4-1").val(albumName);
	$("#sid-input-hidden").val(sid);
}

function cancelEditPlaylist(){
	$("#g-wrap-right").show();
	$("#g-wrap-right2").hide();
}

function saveSingleSong(){
	//保存歌曲更新
	var arr = new Array();  
	var stitle = $("#auto-id-input1-1").val();
	var singer = $("#auto-id-input2-1").val();
	var stime = $("#auto-id-input3-1").val();
	var sid = $("#sid-input-hidden").val();
	var album = $("#auto-id-input4-1").val();
	arr[0]=stitle;
	arr[1]=singer;
	arr[2]=stime;
	arr[3]=sid;
	arr[4]=album;
	$.ajax({  
	    type : 'POST',  
	    url: '/updateSingleSongInfo', 
	    contentType : "application/json",
	    data : JSON.stringify(arr), 
	    success : function(data) {  
	    	console.log("更新成功！");
	    	window.location.href="/myMusic.do"
	    }  
	});
}

