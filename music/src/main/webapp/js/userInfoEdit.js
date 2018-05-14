$(document).ready(function(){
//	$(this).find(".g-wrap-right2").show();
	$(".g-wrap-right2").show();
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

function save(){
	var files = document.getElementById('auto-id-input2').files; //files是文件选择框选择的文件对象数组
	var image = $("#edit_cover").attr("src");
	if(files.length == 0 && image.length == 0) {
		alert("请选择单个文件上传");
		return;
	}

	var form = new FormData();
	url = '/user/updateUserInfoOfFront';//服务器上传地址
	if(files.length > 1 && image.length == 0){//图片文件选择
		alert("请选择单个文件上传");
		return;
	}
	var username = $("#auto-id-input1").val();
	$(".li-tag-edit").each(function(){
		form.append("playTypes",$(this).text());
	});
	var uid = $("#pid-input-hidden").val();
	form.append("uid",uid);
	form.append("username",username);
//	form.append("textarea",$("#auto-id-textarea").val());
	form.append("files" , files[0]);
	form.append("image" , image);
	
	var xhr = new XMLHttpRequest();
	xhr.open("post", url, true);

	xhr.addEventListener("readystatechange", function() {
	    var result = xhr;
	    console.log(result);
	    if (result.status != 200) { //error
	        console.log('修改失败', result.status, result.statusText, result.response);
	    } 
	    else if (result.readyState == 4 && result.responseText == "success") { //finished
	        console.log('修改成功', result);
	        alert('修改成功');
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

