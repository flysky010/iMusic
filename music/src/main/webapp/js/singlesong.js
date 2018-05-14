

function init(){
    var len = 30;      //默认显示字数
    var ctn = document.getElementById("album-desc-dot"); 
    var expandHeight= ctn.offsetHeight;				//扩展高度
    var shrinkHeight = 0;							//收缩高度
    var content = ctn.innerHTML;                   //获取div里的内容

    //alert(content);
    var span = document.createElement("span");     //创建<span>元素
    var a = document.createElement("a");           //创建<a>元素
    span.innerHTML = content.substring(0,len);     //span里的内容为content的前len个字符
    shrinkHeight = span.offsetHeight;

    a.innerHTML = content.length>len?"... 展开":"";  ////判断显示的字数是否大于默认显示的字数    来设置a的显示        
    a.href = "javascript:void(0)";//让a链接点击不跳转

    a.onclick = function(){
        if(a.innerHTML.indexOf("展开")>0){      //如果a中含有"展开"则显示"收起"
          a.innerHTML = "<<&nbsp;收起";
          span.innerHTML = content;
          var songlist = document.getElementById("song-list");  //获取div对象
          if(expandHeight-shrinkHeight > 200){
        	  document.getElementById("song-list").style.marginTop = (expandHeight-shrinkHeight-200)+"px";
          }else{
        	  document.getElementById("song-list").style.marginTop = 0+"px";
          }
        }else{
            a.innerHTML = "... 展开";
            span.innerHTML = content.substring(0,len);
            document.getElementById("song-list").style.marginTop = 0+"px";
        }
    }
    // 设置div内容为空，span元素 a元素加入到div中
    ctn.innerHTML = "";
    ctn.appendChild(span);
    ctn.appendChild(a);
}