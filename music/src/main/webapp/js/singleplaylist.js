$(function(){
    //播放完毕
    $('.mp3Btn').on('ended', function() {
    	console.log("音频已播放完成");
    	console.log($(this).next().val());
    	//播放完成，更新播放次数
    	var arr = new Array();  
		arr[0]=document.getElementById("pid").value;
		arr[1]=$(this).next().val();
		$.ajax({  
		    type : 'POST',  
		    url: '/updatePlaylistTimes', 
		    contentType : "application/json",
		    data : JSON.stringify(arr), 
		    success : function(data) {  
		    	var play_count = document.getElementById("song-num").innerHTML;
		    	
				document.getElementById("song-num").innerHTML = parseInt(play_count) + 1;
		    }  
		});
    })
})

//弹出隐藏层
function ShowDiv(show_div,bg_div,sid){
	$.ajax({  
	    type : 'GET',  
	    url: `/addToPlaylist`,
	    contentType : "application/json",
	    success : function(data) { 
	    	console.log("创建成功！");
	    	$("#pl-ul").empty();//删除被选元素的子元素
	    	if(data == null || data == ""){
	    		alert("请先点击“我的音乐”登陆后，" + '\n' + "再收藏您喜欢的歌曲到歌单。")
	    		return;
	    	}
	    	var jsons = data;
	    	for(var i=0; i<jsons.length; i++){
	    		var li = document.createElement("li");
	    		var u = document.getElementById("pl-ul");
		    	u.appendChild(li);
		    	var div1 = document.createElement("div");
		    	li.appendChild(div1);
		    	var input = document.createElement('input')
		    	input.id="input-h";
		    	$(input).attr("type","hidden");
		    	$(input).attr("value",jsons[i].id);
		    	div1.appendChild(input);
		    	$(li).on("click",function(){  
	                var that=$(this);//获取当前点击的this对象   
	                console.log($(this).find("#input-h").val());
	                $.ajax({  
	            	    type : 'GET',  
	            	    url: `/addSongsToPlaylist?pid=${$(this).find("#input-h").val()}&sid=${sid}`,
	            	    contentType : "application/json",
	            	    success : function(data) {
	            	    	if(data == "success"){
	            	    		document.getElementById(show_div).style.display='none';
	            	    		document.getElementById(bg_div).style.display='none';
	            	    	}else if(data == "repeat"){
	            	    		alert("该歌曲已经被添加到歌单中，请选择其他歌曲添加");
	            	    	}else{
	            	    		alert("收藏歌曲到歌单失败");
	            	    	}
	            	    }
	                });
	            }); 
		    	
		    	var div2 = document.createElement("div");
		    	div2.className="pl-img-div";
		    	div1.appendChild(div2);
		    	var a1 = document.createElement("a");
		    	div2.appendChild(a1);
		    	var img1 = document.createElement("img");
		    	img1.src=jsons[i].path;
		    	img1.className ="pl-img";
		    	a1.appendChild(img1);
		    	var p1 = document.createElement("p");
		    	p1.className ="pl-tlt";
		    	div1.appendChild(p1);
		    	var a2 = document.createElement("a");
		    	a2.innerHTML=jsons[i].title;
		    	p1.appendChild(a2);
		    	var p2 = document.createElement("p");
		    	p2.innerHTML=jsons[i].songnum + "首";
		    	p2.className ="pl-song-num";
		    	div1.appendChild(p2);
		    	 
	    	}
	    	document.getElementById(show_div).style.display='block';
	    	document.getElementById(bg_div).style.display='block' ;
	    	var bgdiv = document.getElementById(bg_div);
	    	bgdiv.style.width = document.body.scrollWidth;
	    	$("#"+bg_div).height($(document).height());
//	    	var curHeight=document.getElementById("g-wrap-1").offsetHeight;
//	    	console.log(curHeight);
//	    	var newHeight=curHeight+40;
//	    	document.getElementById("g-wrap-1").style.height = newHeight+"px";//调整整个页面内容的高度
//	    	document.getElementById("g-wrap-left").style.height = newHeight+"px";//调整整个页面内容的高度
//	    	document.getElementById("g-wrap-right").style.height = newHeight+"px";//调整整个页面内容的高度
	    },
	    error: function(xhr) {
	         // 导致出错的原因较多，以后再研究
	         alert('error:' + JSON.stringify(xhr));
	    }
	});
	
};
//关闭弹出层
function CloseDiv(show_div,bg_div){
	document.getElementById(show_div).style.display='none';
	document.getElementById(bg_div).style.display='none';
};

