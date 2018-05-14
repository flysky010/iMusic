
function toUpdate(id){
	var param = "id="+id;
	window.location.href="toBasedataEdit.do?"+param; 
}

function toDelete(id){
	var param = "id="+id;
	window.location.href="basedataDelete.do?"+param;
}

function toBasedataAdd(){
	window.location.href="toBasedataAdd.do";
}

function toBasedataQuery(){
	var singer = document.getElementById("username").value;
	var param = "singer="+singer;
	window.location.href="toBasedataQuery.do?"+param;
}

function getPrePage(){
	var obj = document.getElementById("selectNum"); //定位id
	var index = obj.selectedIndex; // 选中索引
	var num = obj.options[index].text; // 选中文本
	num = num - 1;
	var param = "num="+num;
	window.location.href="basedataList.do?"+param;
}

function getNextPage(){
	var obj = document.getElementById("selectNum"); //定位id
	var index = obj.selectedIndex; // 选中索引
	var num = obj.options[index].text; // 选中文本
	num = parseInt(num) + 1;
	var param = "num="+num;
	window.location.href="basedataList.do?"+param;
}

function getCurrentPage2(){
	var sel=document.getElementById("selectNum");
	var num = sel.options[sel.selectedIndex].value;
	var param = "num="+num;
	window.location.href="basedataList.do?"+param;
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

function save(url){
	var files = document.getElementById('auto-id-input2').files; //files是文件选择框选择的文件对象数组
	var image = $("#edit_cover").attr("src");
	if(files.length == 0 && image.length == 0) return;
	
	var form = new FormData();
	//url = '/addBasedata';//服务器上传地址
	if(files.length > 1 && image.length == 0){//图片文件选择
		alert("请选择单个文件上传");
		return;
	}
	var singer = $("#singer").val();
	var albumName = $("#albumName").val();
	var songName = $("#songName").val();
	var songTime = $("#songTime").val();
	var bid = $("#bid").val();
	form.append("singer",singer);
	form.append("albumName",albumName);
	form.append("songName",songName);
	form.append("songTime",songTime);
	form.append("files" , files[0]);
	form.append("image" , image);
	form.append("bid" , bid);
	var xhr = new XMLHttpRequest();
	xhr.open("post", url, true);

	xhr.addEventListener("readystatechange", function() {
	    var result = xhr;
	    console.log(result);
	    if (result.status != 200) { //error
	        console.log('更新失败', result.status, result.statusText, result.response);
	    } 
	    else if (result.readyState == 4) { //finished
	        console.log('更新成功', result);
	        window.location.href="/basedataList.do";
	    }
	});
	xhr.send(form); //开始上传
}

