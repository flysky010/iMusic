function item_song_bkcolor(){
	changeItem(1);
	var a=document.getElementsByClassName('item');
	if(a.length == 1){
		a[0].style.backgroundColor = "#F2F2F2";
		return;
	}
	for (var i=0;i<a.length;i++){
		if(i%2==0){
			a[i].style.backgroundColor = "#FFF";
		}else{
			a[i].style.backgroundColor = "#F2F2F2";
		}
	}
}

function playmusic(x){
	var aud = x.getElementsByTagName('audio');
	
	aud[0].addEventListener("ended", function() //注册end事件
	{
		console.log("音频已播放完成");
		x.style.background="url(images/voice_stop.png) no-repeat center bottom";
    	x.style.backgroundSize="cover";
    	
    	//播放完成，更新播放次数
    	var arr = new Array();  
		arr[0]=document.getElementById("rid").value;
		$.ajax({  
		    type : 'POST',  
		    url: '/updatePlayNum', 
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

function searchMusic(){
	var x = document.getElementById("m-search-input").value;
	var param = "searchInput="+x;
	window.location.href="/search.do?"+param;
}

function changeItem(id){
	switch(id){
	case 1://单曲
		jQuery("#dan-qu").show();
		jQuery("#ge-ci").hide();
		var x = document.getElementById("menu");
		var x2 = x.getElementsByTagName("a");
		for(var i=0; i<x2.length; i++){
			x2[i].style.borderTop="2px solid #999";
		}
		document.getElementById("li-1").style.borderTop="2px solid #C40000";
		break;
	case 2://歌词
		jQuery("#dan-qu").hide();
		jQuery("#ge-ci").show();
		var x = document.getElementById("menu");
		var x2 = x.getElementsByTagName("a");
		for(var i=0; i<x2.length; i++){
			x2[i].style.borderTop="2px solid #999";
		}
		document.getElementById("li-2").style.borderTop="2px solid #C40000";
		break;
	}
}