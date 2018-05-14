function submitform(){
    if(document.uploadMusicForm.onsubmit &&
    !document.uploadMusicForm.onsubmit()){ //判断是否正在提交，如果是则直接返回
        return;
    }
 	document.uploadMusicForm.submit(); //调用form的submit()方法完成表单的提交
}

function toUpdate(id){
	var param = "id="+id;
	window.location.href="toFileEdit.do?"+param; 
}

function toDelete(id){
	var param = "id="+id;
	window.location.href="fileDelete.do?"+param;
}

function toFileQuery(){
	var filename = document.getElementById("filename").value;
	var param = "filename="+filename;
	window.location.href="toFileQuery.do?"+param;
}