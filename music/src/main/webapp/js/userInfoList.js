
function toUpdatePassword(id){
	var param = "id="+id;
	window.location.href="userEdit.do?"+param; 
}

function toDelete(id){
	var param = "id="+id;
	window.location.href="userDelete.do?"+param;
}

function toUserAdd(){
	window.location.href="toUserAdd.do";
}

function toUserQuery(){
	var username = document.getElementById("username").value;
	var param = "username="+username;
	window.location.href="toUserQuery.do?"+param;
}

function getPrePage(){
	var obj = document.getElementById("selectNum"); //定位id
	var index = obj.selectedIndex; // 选中索引
	var num = obj.options[index].text; // 选中文本
	num = num - 1;
	var param = "num="+num;
	window.location.href="userList.do?"+param;
}

function getNextPage(){
	var obj = document.getElementById("selectNum"); //定位id
	var index = obj.selectedIndex; // 选中索引
	var num = obj.options[index].text; // 选中文本
	num = parseInt(num) + 1;
	var param = "num="+num;
	window.location.href="userList.do?"+param;
}

function getCurrentPage2(){
	var sel=document.getElementById("selectNum");
	var num = sel.options[sel.selectedIndex].value;
	var param = "num="+num;
	window.location.href="userList.do?"+param;
}