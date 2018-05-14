function run(){
	var x=document.getElementsByClassName("songDesc");
	var i;
	for(i=0;i<x.length;i++){
		var rtn= beautySub(x[i].innerHTML,18);
		x[i].innerHTML=rtn;
	}
}
function beautySub(str, len) {
    var reg = /[\u4e00-\u9fa5]/g,    //专业匹配中文
        slice = str.substring(0, len),
        chineseCharNum = (~~(slice.match(reg) && slice.match(reg).length)),
        realen = slice.length*2 - chineseCharNum;
    return str.substr(0, realen) + (realen < str.length ? "..." : "");
}

function initUl(){
    var obj_lis = document.getElementById("dropdown-menu-title").getElementsByTagName("li");
    for(i=0;i<obj_lis.length;i++){
        obj_lis[i].onclick = function(){
            alert(this.innerHTML);
        }
    }
}

function getPlaylistByType(type){
	var param = "type="+type;
	window.location.href="c_playlist.do?"+param; 
}

function toSinglePlaylist(id){
	var param = "pid="+id;
	window.location.href="singleplaylist.do?"+param;
}

function getCurrentPage(num){
	var catName = document.getElementById("catName").innerHTML;
	var param = "num="+num+"&"+"catName="+catName;
	window.location.href="c_playlist.do?"+param;
}

function getCurrentPage2(){
	var sel=document.getElementById("selectNum");
	var num = sel.options[sel.selectedIndex].value;
	var catName = document.getElementById("catName").innerHTML;
	var param = "num="+num+"&"+"catName="+catName;
	window.location.href="c_playlist.do?"+param;
}

function getPrePage(){
	var obj = document.getElementById("selectNum"); //定位id
	var index = obj.selectedIndex; // 选中索引
	var num = obj.options[index].text; // 选中文本
	num = num - 1;
	var catName = document.getElementById("catName").innerHTML;
	var param = "num="+num+"&"+"catName="+catName;
	window.location.href="c_playlist.do?"+param;
}

function getNextPage(){
	var obj = document.getElementById("selectNum"); //定位id
	var index = obj.selectedIndex; // 选中索引
	var num = obj.options[index].text; // 选中文本
	num = parseInt(num) + 1;
	var catName = document.getElementById("catName").innerHTML;
	var param = "num="+num+"&"+"catName="+catName;
	window.location.href="c_playlist.do?"+param;
}


