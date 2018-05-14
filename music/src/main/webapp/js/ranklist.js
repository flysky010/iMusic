function changeRanklist(id){
	var param = "id="+id;
	window.location.href="c_ranklist.do?"+param;
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

function downloadMusic(){
	var x = document.getElementsByTagName("source");
	var arr = new Array();
	for(var i =0;i<x.length;i++){ 
		arr[i] = decodeURI(x[i].src);
	} 
	
//	$.ajax({  
//	    type : 'POST',  
//	    url: '/batchDownload',  
//	    contentType : "application/json" ,
//	    data : JSON.stringify(arr), 
//	    success : function(data) {  
//
//	    }  
//	}); 
	
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

function play(){
	var td=document.getElementById ("table-rank").rows[1].cells[1];
	var list=td.getElementsByTagName('div');
	var first_song_div=list[1]
	playmusic(first_song_div);
}

//$(function(){
//    //播放完毕
//    $('#mp3Btn').on('ended', function() {
//        console.log("音频已播放完成");
//        $('.btn-audio').css({'background':'url(images/voice_stop.png) no-repeat center bottom','background-size':'cover'});
//    })
////    //播放器控制
////    var audio = document.getElementById('mp3Btn');
////    audio.volume = .3;
////    $('.btn-audio').click(function() {
////        event.stopPropagation();//防止冒泡
////        if(audio.paused){ //如果当前是暂停状态
////            $('.btn-audio').css({'background':'url(images/voice_play.png) no-repeat center bottom','background-size':'cover'});
////            audio.play(); //播放
////            return;
////        }else{//当前是播放状态
////            $('.btn-audio').css({'background':'url(images/voice_stop.png) no-repeat center bottom','background-size':'cover'});
////            audio.pause(); //暂停
////        }
////    });
//})